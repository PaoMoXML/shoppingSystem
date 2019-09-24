/**
 * @author XuMenglin
 * @date 2019年9月16日
 *
 */
package com.controller;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.TtsVoiceSender;
import com.github.qcloudsms.TtsVoiceSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;

import org.json.JSONException;
import java.io.IOException;

/**
 * <p>Title: phone</p>
 * <p>Description: </p>
 * @author XuMenglin
 * @date 2019年9月16日
 */
public class phone {
	
	
	public static void main(String[] args) {
		// 短信应用 SDK AppID
		int appid = 1400254604; // SDK AppID 以1400开头
		// 短信应用 SDK AppKey
		String appkey = "4e6e4293373ee48f87620ecbeb7c68a1";
		// 需要发送短信的手机号码
		String[] phoneNumbers = {"17826265706"};
		// 短信模板 ID，需要在短信应用中申请
		int templateId = 420689; // NOTE: 这里的模板 ID`7839`只是示例，真实的模板 ID 需要在短信控制台中申请
		// 签名
		String smsSign = "徐梦麟的学习空间"; // NOTE: 签名参数使用的是`签名内容`，而不是`签名ID`。这里的签名"腾讯云"只是示例，真实的签名需要在短信控制台申请
		
		int a = RandomUtil.randomInt(1000, 10000);
		
		String b = String.valueOf(a);
		
		try {
			  String[] params = {b};
			  SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
			  SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
			      templateId, params, smsSign, "", "");
			  System.out.println(result);
			} catch (HTTPException e) {
			  // HTTP 响应码错误
			  e.printStackTrace();
			} catch (JSONException e) {
			  // JSON 解析错误
			  e.printStackTrace();
			} catch (IOException e) {
			  // 网络 IO 错误
			  e.printStackTrace();
			}
	}

}
