package com.arc.redis.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {

	@Autowired
	RedisClusterConfigurationProperties clusterConfigurationProperties;

	@Bean
	@Primary
	public RedisConnectionFactory jedisConnectionFactory() {

		return new JedisConnectionFactory(clusterConfiguration());
	}

	@Bean
	public RedisClusterConfiguration clusterConfiguration() {
		RedisClusterConfiguration clusterConfiguration = new RedisClusterConfiguration(
				clusterConfigurationProperties.getNodes());
		clusterConfiguration.setUsername("default");
		clusterConfiguration.setPassword(RedisPassword.of("P@9001pp"));
		return clusterConfiguration;
	}

	@Bean
	public RedisTemplate<String, Object> template(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new JdkSerializationRedisSerializer());
		template.setValueSerializer(new JdkSerializationRedisSerializer());
		template.setEnableTransactionSupport(true);
		template.afterPropertiesSet();
		return template;
	}

}
