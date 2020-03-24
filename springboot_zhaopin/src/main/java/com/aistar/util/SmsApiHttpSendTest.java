package com.aistar.util;

import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 短信API发送
 * @author JiangPengFei
 * @version $Id: javaHttpNewApiDemo, v 0.1 2019/1/23 11:42 JiangPengFei Exp $$
 */
public class SmsApiHttpSendTest {

	/**
	 * 短信发送
	 * 文档地址：http://www.miaodiyun.com/developer.html#smsSend
	 */
	private static int code = (int) (Math.random() * 900000 + 100000);//生成六位随机的验证码
	private static String codeStr = String.valueOf(code);//将其转换为String类型
	private static String operation = "/industrySMS/sendSMS";//对应的API地址


	public static String getCode(String phone){
		String accountSid=Config.ACCOUNT_SID;
		String param= null;
		try {
			param = URLEncoder.encode(codeStr,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String templateid="246154";//模板Id
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&to=" + phone +"&param=" + param + "&templateid=" + templateid
				+ HttpUtil.createCommonParam(Config.ACCOUNT_SID,Config.AUTH_TOKEN);

		// 提交请求 result:状态码
		String result = HttpUtil.post(url, body);

		//(换行符) 剔除了平台无关性，写一次代码跑通在Linux上和Window上都能够运行。
		System.out.println("result:" + System.lineSeparator() + result);
		System.out.println(result.getClass());

		//字符串转json对象
		JSONObject jsonObject = JSONObject.parseObject(result);
		String respCode = jsonObject.getString("respCode");
		System.out.println(respCode);

		//反馈-00000状态码标识请求成功，rod:随机验证码
		String defaultRespCode = "00000";
		if (defaultRespCode.equals(respCode)) {
			return codeStr;
		} else {
			return defaultRespCode;
		}
	}
}
