package com.aistar.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by admin on 2020/2/19.
 */
public class HttpUtil {
    /**
     * 构造通用参数timestamp、sig和respDataType
     *
     * @return
     */
    public static String createCommonParam(String sid, String token) {
        // 时间戳(毫秒)，格式：1547005945480
        long timestamp = System.currentTimeMillis();
        // 签名：MD5(ACCOUNT SID + AUTH TOKEN + timestamp)。共32位（小写）
        String sig = DigestUtils.md5Hex(sid + token + timestamp);
        return "&timestamp=" + timestamp + "&sig=" + sig + "&respDataType=" + Config.RESP_DATA_TYPE;
    }

    /**
     * @param url  功能和操作
     * @param body post数据:
     *             accountSid=7727bb0e0f9b910c48fc1ec5e3xxxxxx&to=186xxxxxxxx&templateid=1000&param=5,test&timestamp=1555570111645&sig=214a2905e44c221c3409b84cdaxxxxxx
     * @return 返回读出的数据
     */
    public static String post(String url, String body) {
        //System.lineSeparator()进行换行。不然会出现windows上可以运行，在其他平台上无法运行
        System.out.println("body:" + System.lineSeparator() + body);
        String result = "";
        try {
            OutputStreamWriter out = null;
            BufferedReader in = null;
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();////得到connection对象
            // 设置连接参数
            conn.setDoOutput(true);//允许写入
            conn.setDoInput(true);//允许读出
            conn.setConnectTimeout(5000);//connect timeout 建立连接的超时时间；
            conn.setReadTimeout(20000);// read timeout 传递数据的超时时间
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");//设置属性，发送数据的时候进行转码
            // 提交数据
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");//字符集编码 UTF-8
            out.write(body);//post数据写入
            out.flush();//刷新写入流
            // 读取返回数据
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = "";
            boolean firstLine = true; // 读第一行不加换行符
            while ((line = in.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;//只有一行，加换行符
                } else {
                    result += System.lineSeparator();//否则页加换行
                }
                result += line;//读出的所有数据
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 回调测试工具方法
     *
     * @param url  功能和操作
     * @param body post数据:
     *             accountSid=7727bb0e0f9b910c48fc1ec5e3xxxxxx&to=186xxxxxxxx&templateid=1000&param=5,test&timestamp=1555570111645&sig=214a2905e44c221c3409b84cdaxxxxxx
     * @return 返回读出的数据
     */
    public static String postHuiDiao(String url, String body) {
        String result = "";
        try {
            OutputStreamWriter out = null;
            BufferedReader in = null;
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            // 设置连接参数
            conn.setDoOutput(true);//允许写入
            conn.setDoInput(true);//允许读出
            conn.setConnectTimeout(5000);//connect timeout 建立连接的超时时间；
            conn.setReadTimeout(20000);// read timeout 传递数据的超时时间
            // 提交数据
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");//字符集编码，UTF-8
            out.write(body);//将post数据写入
            out.flush();//刷新写入流

            // 读取返回数据
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = "";
            boolean firstLine = true; // 读第一行不加换行符
            while ((line = in.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;//只有一行，加换行符
                } else {
                    result += System.lineSeparator();//否则也要加换行符
                }
                result += line;//读出的所有数据
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
