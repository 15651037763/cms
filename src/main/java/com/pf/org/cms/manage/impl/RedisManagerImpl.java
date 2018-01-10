package com.pf.org.cms.manage.impl;

import com.pf.org.cms.manage.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: pf
 * @Date: 2017/12/28 19:57
 * @Description:
 */
@Service(value = "redisManager")
public class RedisManagerImpl implements RedisManager {
    @Autowired
    private StringRedisTemplate redisTemp;

    @Override
    public String getStr(String key) {
        return redisTemp.opsForValue().get(key);
    }

    @Override
    public String getSubStr(String key, long start, long end) {
        return redisTemp.opsForValue().get(key, start, end);
    }

    @Override
    public void setStr(String key, String value) {
        redisTemp.opsForValue().set(key, value);
    }

    @Override
    public void setStrAndExpire(String key, String value, long timeout) {
        redisTemp.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    @Override
    public void setStrAndCover(String key, String value, long offset) {
        redisTemp.opsForValue().set(key, value, offset);
    }

    @Override
    public boolean setStrIfAbsent(String key, String value) {
        return redisTemp.opsForValue().setIfAbsent(key, value);
    }

    @Override
    public void multiSetStr(Map<String, String> params) {
        redisTemp.opsForValue().multiSet(params);
    }

    @Override
    public boolean multiSetStrIfAbsent(Map<String, String> params) {
        return redisTemp.opsForValue().multiSetIfAbsent(params);
    }

    @Override
    public long getExpire(String key) {
        return redisTemp.getExpire(key);
    }

    @Override
    public boolean setExpire(String key, long timeout) {
        return redisTemp.expire(key, timeout, TimeUnit.SECONDS);
    }

    @Override
    public boolean hasKey(String key) {
        return redisTemp.hasKey(key);
    }

    @Override
    public void delete(String key) {
        redisTemp.delete(key);
    }

    @Override
    public void multiDelete(List keys) {
        redisTemp.delete(keys);
    }

    @Override
    public boolean renameKeyIfAbsent(String oldKey, String newKey) {
        return redisTemp.renameIfAbsent(oldKey, newKey);
    }

    @Override
    public boolean hasHashKey(String key, Object hashKey) {
        return redisTemp.opsForHash().hasKey(key, hashKey);
    }

    @Override
    public Object hashGet(String key, Object hashKey) {
        return redisTemp.opsForHash().get(key, hashKey);
    }

    @Override
    public Map getHashMap(String key) {
        return redisTemp.opsForHash().entries(key);
    }

    @Override
    public long hashDelete(String key, Object... hashKeys) {
        return redisTemp.opsForHash().delete(key, hashKeys);
    }

    @Override
    public void hashPut(String key, Object hashKey, Object hashValue) {
        redisTemp.opsForHash().put(key, hashKey, hashValue);
    }

    @Override
    public boolean hashPutIfAbsent(String key, Object hashKey, Object hashValue) {
        return redisTemp.opsForHash().putIfAbsent(key, hashKey, hashValue);
    }

    @Override
    public void setHashMap(String key, HashMap map) {
        redisTemp.opsForHash().putAll(key, map);
    }

    @Override
    public List getList(String key) {
        return redisTemp.opsForList().range(key, 0, -1);
    }

    @Override
    public void leftListPush(String key, String... values) {
        redisTemp.opsForList().leftPushAll(key, values);
    }

    @Override
    public void leftSetList(String key, List value) {
        redisTemp.opsForList().leftPushAll(key, value);
    }

    @Override
    public void rightListPush(String key, String... values) {
        redisTemp.opsForList().rightPushAll(key, values);
    }

    @Override
    public void rightSetList(String key, List value) {
        redisTemp.opsForList().rightPushAll(key, value);
    }

    @Override
    public String leftListPop(String key) {
        return redisTemp.opsForList().leftPop(key);
    }

    @Override
    public String rightListPop(String key) {
        return redisTemp.opsForList().rightPop(key);
    }

    @Override
    public void ListRemove(String key, long count, Object value) {
        redisTemp.opsForList().remove(key, count, value);
    }
}
