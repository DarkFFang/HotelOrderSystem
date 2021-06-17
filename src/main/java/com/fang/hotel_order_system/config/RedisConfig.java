package com.fang.hotel_order_system.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 配置
 *
 * @author fang
 * @date 2020/12/14
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    /**
     * retemplate相关配置
     *
     * @param factory 工厂
     * @return {@link RedisTemplate <String, Object>}
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        //使用StringRedisSerializer来序列化和反序列化redis的key值
        redisTemplate.setKeySerializer(stringRedisSerializer);
        // 值采用json序列化
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        // 设置hash key 和value序列化模式
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    /**
     * 散列操作
     * 对hash类型的数据操作
     *
     * @param redisTemplate 模板
     * @return {@link HashOperations <String, String, Object>}
     */
    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForHash();
    }

    /**
     * 值操作
     * 对redis字符串类型数据操作
     *
     * @param redisTemplate 模板
     * @return {@link ValueOperations <String, Object>}
     */
    @Bean
    public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForValue();
    }

    /**
     * 列表操作
     * 对链表类型的数据操作
     *
     * @param redisTemplate 模板
     * @return {@link ListOperations <String, Object>}
     */
    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForList();
    }

    /**
     * 集合操作
     * 对无序集合类型的数据操作
     *
     * @param redisTemplate 模板
     * @return {@link SetOperations <String, Object>}
     */
    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForSet();
    }

    /**
     * 集合操作
     * 对有序集合类型的数据操作
     *
     * @param redisTemplate 模板
     * @return {@link ZSetOperations <String, Object>}
     */
    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }


}
