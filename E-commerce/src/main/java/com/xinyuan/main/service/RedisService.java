package com.xinyuan.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: chenxin
 * @Date: 2019/1/5 20:26
 * @Description:
 */
@Component
public class RedisService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate = null;

    /**
     * 默认过期时长，单位：秒
     */
    public static final long DEFAULT_EXPIRE = 60 * 60 * 24;

    /**
     * 不设置过期时间
     */
    public static final long NOT_EXPIRE = -1;

    /**
     *
     * 功能描述: 是否存在该key
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 20:30
     */
    public boolean existsKey(String key){
        return redisTemplate.hasKey(key);
    }

    /**
     *
     * 功能描述: 重命名key,如果newKey已经存在，则newKey的原值被覆盖
     *
     * @param oldKey
     * @param newKey
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 20:31
     */
    public void renameKey(String oldKey, String newKey){
        redisTemplate.rename(oldKey, newKey);
    }

    /**
     * newKey不存在时才重命名
     * @param oldKey
     * @param newKey
     * @return 成功返回true
     * @date: 2019/1/5 20:31
     */
    public boolean renameKeyNotExist(String oldKey, String newKey){
        return redisTemplate.renameIfAbsent(oldKey, newKey);
    }

    /**
     *
     * 功能描述: 删除key
     *
     * @param key
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 20:35
     */
    public void deleteKey(String key){
        redisTemplate.delete(key);
    }

    /**
     * 删除多个key
     *
     * @param keys
     */
//    public void deleteKey(String... keys) {
//        Set<String> kSet = Stream.of(keys).map(k -> k).collect(Collectors.toSet());
//        redisTemplate.delete(kSet);
//    }

    /**
     * 删除Key的集合
     *
     * @param keys
     */
//    public void deleteKey(Collection<String> keys) {
//        Set<String> kSet = keys.stream().map(k -> k).collect(Collectors.toSet());
//        redisTemplate.delete(kSet);
//    }

    /**
     * 设置key的生命周期
     *
     * @param key
     * @param time
     * @param timeUnit
     */
    public void expireKey(String key, long time, TimeUnit timeUnit) {
        redisTemplate.expire(key, time, timeUnit);
    }

    /**
     * 指定key在指定的日期过期
     *
     * @param key
     * @param date
     */
    public void expireKeyAt(String key, Date date) {
        redisTemplate.expireAt(key, date);
    }

    /**
     * 查询key的生命周期
     *
     * @param key
     * @param timeUnit
     * @return
     */
    public long getKeyExpire(String key, TimeUnit timeUnit) {
        return redisTemplate.getExpire(key, timeUnit);
    }

    /**
     * 将key设置为永久有效
     *
     * @param key
     */
    public void persistKey(String key) {
        redisTemplate.persist(key);
    }

}
