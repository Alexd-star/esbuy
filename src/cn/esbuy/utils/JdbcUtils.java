package cn.esbuy.utils;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
    /** 驱动 */
    private static String driver = "com.mysql.jdbc.Driver";

    /** 地址 */
    private static String url = "jdbc:mysql:///day11?serverTimezone=UTC&characterEncoding=utf8";

    /** 用户名 */
    private static String username = "root";

    /** 密码 */
    private static String password = "123";

    /**
     * 1.静态代码块:加载驱动
     */
    static {
        try {
            driver = "com.mysql.jdbc.Driver";
            url = "jdbc:mysql:///day11?serverTimezone=UTC&characterEncoding=utf8";
            username = "root";
            password = "123";
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Description: 获取连接的公共方法<br/>
     * @author liYan
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);

    }

    /**
     * Description:关闭资源的公共方法 <br/>
     * @author liYan
     * @param rs
     * @param st
     * @param conn
     */
    public static void close(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Description: MD5加密的公共方法，传入密码，返回加密后的密码<br/>
     * @author liYan
     * @param pwd
     * @return
     */
    public static String MD5Tools(String pwd) {
        String[] digitals = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
        String result = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(pwd.getBytes("utf-8"));
            for (int i = 0; i < bytes.length; i++) {
                int num = bytes[i];
                if (num < 0) {
                    num = num + 255;
                }
                int j = num / 16;
                int k = num % 16;
                result = digitals[j] + digitals[k] + result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
