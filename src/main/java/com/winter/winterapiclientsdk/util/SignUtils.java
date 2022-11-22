package com.winter.winterapiclientsdk.util;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

import java.util.Map;

/**
 * @program: winter-interface
 * @description: 签名工具类
 * @author: Mr.Ye
 * @create: 2022-11-12 20:39
 **/
public class SignUtils {

	/**
	 * MD5生成签名
	 *
	 * @param hashMap 用户传递的参数
	 * @param secretKey 密钥
	 * @return 签名
	 */
	public static String genSign(Map hashMap, String secretKey) {
		Digester md5 = new Digester(DigestAlgorithm.MD5);
// 5393554e94bf0eb6436f240a4fd71282
		return md5.digestHex(hashMap.toString() + "," + secretKey);
	}
}
