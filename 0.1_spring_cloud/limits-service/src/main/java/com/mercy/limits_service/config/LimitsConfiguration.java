package com.mercy.limits_service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
 
@Component
@Data
@ConfigurationProperties("limits-service")
public class LimitsConfiguration
{ 
	private int minimum, maximum;
}
