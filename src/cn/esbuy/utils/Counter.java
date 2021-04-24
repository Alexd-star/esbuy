/**
 * Project Name:ESBuy
 * File Name:Counter.java
 * Package Name:cn.esbuy.utils
 * Date:2020年2月17日上午3:33:43
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.esbuy.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Description: 判断当前网站被访问了多少次<br/>
 * Date: 2020年2月17日 上午3:33:43 <br/>
 * 
 * @author liYan
 * @version
 * @see
 */
public class Counter extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Counter() {
        super();
    }

    public static void writeFile(String filename, int count) {

        try {
            PrintWriter out = new PrintWriter(new FileWriter(filename));
            out.println(count);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int readFile(String filename) {
        File f = new File(filename);
        int count = 0;
        if (!f.exists()) {
            writeFile(filename, 0);
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(f));
            try {
                count = Integer.parseInt(in.readLine());
                in.close();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return count;
    }

    public void init() throws ServletException {
        // Put your code here
    }

}
