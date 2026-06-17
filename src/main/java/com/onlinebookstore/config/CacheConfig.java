package com.onlinebookstore.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 缓存配置类。
 * <p>默认使用 ConcurrentMapCacheManager 提供本地内存缓存，
 * 无需外部 Redis 即可运行。当 Redis 可用时，Spring Boot 自动配置
 * 会替换为 RedisCacheManager。</p>
 */
@Configuration
@EnableCaching
public class CacheConfig {

    /**
     * 本地缓存管理器。
     * <p>定义 users 和 books 两个缓存区域。
     * 当 Redis 不可用时作为降级方案。</p>
     *
     * @return CacheManager 实例
     */
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("users", "books");
    }
}
