package cn.esbuy.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload {

	public Map<String, String> saveImage(HttpServletRequest request) throws Exception {
		Map<String, String> result = new HashMap<String, String>();
		// 创建一个FileItem工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 创建文件上传核心组件
		ServletFileUpload fileupload = new ServletFileUpload(factory);
		// 解析请求,获取item
		List<FileItem> items = fileupload.parseRequest(request);
		for (FileItem item : items) {
			// 获取字段名
			String fieldname = item.getFieldName();
			if (item.isFormField()) {
				// 获取字段值，并解决乱码
				String fieldvalue = item.getString("UTF-8");
				// 写入map
				result.put(fieldname, fieldvalue);
			} else {
				// 上传表单项
				String filename = item.getName();
				// 如果没有上传文件
				if (filename == null || filename.equals("")) {
					filename = null;
				} else {
					//选择了文件进行上传
					// 使用日期时间+4位随机数生成图片文件名
					String suffix = item.getName().substring(item.getName().lastIndexOf("."));
					filename = ((int) (Math.random() * 9000) + 1000) + suffix;
					filename = (new SimpleDateFormat("yyyyMMddhhmmss")).format(new Date()) + filename;
					// 获取图片上传路径
					String path = request.getServletContext().getInitParameter("upload");
					path = request.getServletContext().getRealPath(path);
					// 保存文件
					File savefile = new File(path, filename);
					item.write(savefile);
				}
				result.put(fieldname, filename);
			}
		}
		return result;
	}
}
