package com.winter.winterapiclientsdk.client;


import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.winter.winterapiclientsdk.model.User;

import java.util.HashMap;
import java.util.Map;

import static com.winter.winterapiclientsdk.util.SignUtils.genSign;


/**
 * @program: winter-interface
 * @description: 调用name接口的客户端
 * @author: Mr.Ye
 * @create: 2022-11-12 18:51
 **/
public class NameClient {
	private String accessKey;
	private String secretKey;

	public NameClient(String accessKey, String secretKey) {
		this.accessKey = accessKey;
		this.secretKey = secretKey;
	}

	public String getNameByGet(String name) {
		String result1= HttpUtil.get("http://localhost:8123/api/name/?name=" + name);
		System.out.println("result1:" + result1);
		return result1;
	}

	public String getNameByPost(String name) {
		String result2= HttpUtil.get("http://localhost:8123/api/name/?name=" + name);
		System.out.println("result2:" + result2);
		return result2;
	}

	private Map<String, String> getHeaderMap(Object requestParams) {
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("accessKey", accessKey);
//		headerMap.put("secretKey", secretKey);
		headerMap.put("requestParams", requestParams.toString());
		headerMap.put("nonce", RandomUtil.randomString(4));
		headerMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
		headerMap.put("sign", genSign(headerMap, secretKey));
		return headerMap;
	}

	public String getNameByPost(User user) {
		String json = JSONUtil.toJsonStr(user);
		HttpResponse httpResponse = HttpRequest.post("http://localhost:8123/api/name/user").body(json).addHeaders(getHeaderMap(user)).execute();
		System.out.println("result3:" + httpResponse);
		System.out.println(httpResponse.getStatus());
		String result3 = httpResponse.body();
		System.out.println("result3:" + result3);
		return result3;
	}
}
