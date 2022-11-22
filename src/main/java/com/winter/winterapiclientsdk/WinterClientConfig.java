package com.winter.winterapiclientsdk;

import com.winter.winterapiclientsdk.client.NameClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: winterapi-client-sdk
 * @description: 接口客户端SDK
 * @author: Mr.Ye
 * @create: 2022-11-13 21:33
 **/
@Configuration
@ConfigurationProperties("winter.client")
@ComponentScan
@Data
public class WinterClientConfig {

	private String accessKey;

	private String secretKey;

	@Bean
	public NameClient nameClient() {
		return new NameClient(accessKey, secretKey);
	}
}
