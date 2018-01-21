package com.pf.org.cms.manage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: pf
 * @Date: 2017/12/28 19:16
 * @Description:
 */
public interface RedisManager {
    /**
     * 查询字符串
     *
     * @param key
     * @return
     */
    public String getStr(String key);

    /**
     * 查询字符串（截取start-end）
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public String getSubStr(String key, long start, long end);

    /**
     * 保存字符串
     *
     * @param key
     * @param value
     */
    public void setStr(String key, String value);

    /**
     * 保存字符串（带失效时间，单位秒）
     *
     * @param key
     * @param value
     * @param timeout
     */
    public void setStrAndExpire(String key, String value, long timeout);

    /**
     * 覆盖保存字符串（从偏移量offset开始）
     *
     * @param key
     * @param value
     * @param offset
     */
    public void setStrAndCover(String key, String value, long offset);

    /**
     * 保存字符串(已存在返回false)
     *
     * @param key
     * @param value
     * @return
     */
    public boolean setStrIfAbsent(String key, String value);

    /**
     * 批量保存字符串
     *
     * @param params
     */
    public void multiSetStr(Map<String, String> params);

    /**
     * 批量保存字符串(已存在返回false)
     *
     * @param params
     */
    public boolean multiSetStrIfAbsent(Map<String, String> params);

    /**
     * 查询失效时间（单位秒）
     *
     * @param key
     * @return
     */
    public long getExpire(String key);

    /**
     * 设置失效时间（单位秒）
     *
     * @param key
     * @param timeout
     * @return
     */
    public boolean setExpire(String key, long timeout);

    /**
     * 检查key是否存在
     *
     * @param key
     * @return
     */
    public boolean hasKey(String key);

    /**
     * 删除键值对
     *
     * @param key
     */
    public void delete(String key);

    /**
     * 批量删除键值对
     *
     * @param keys
     */
    public void multiDelete(List keys);

    /**
     * 重命名key
     *
     * @param oldKey
     * @param newKey
     * @return
     */
    public boolean renameKeyIfAbsent(String oldKey, String newKey);

    /**
     * 检查hashKey是否存在
     *
     * @param key
     * @param hashKey
     * @return
     */
    public boolean hasHashKey(String key, Object hashKey);

    /**
     * 查询hashKey值
     *
     * @param key
     * @param hashKey
     * @return
     */
    public Object hashGet(String key, Object hashKey);

    /**
     * 查询哈希表
     *
     * @param key
     * @return
     */
    public Map getHashMap(String key);

    /**
     * 删除hashKey值
     *
     * @param key
     * @param hashKeys
     * @return
     */
    public long hashDelete(String key, Object... hashKeys);

    /**
     * 保存hashKey值
     *
     * @param key
     * @param hashKey
     * @param hashValue
     */
    public void hashPut(String key, Object hashKey, Object hashValue);

    /**
     * 保存hashKey值(已存在返回false)
     *
     * @param key
     * @param hashKey
     * @param hashValue
     */
    public boolean hashPutIfAbsent(String key, Object hashKey, Object hashValue);

    /**
     * 保存哈希表
     *
     * @param key
     * @param map
     */
    public void setHashMap(String key, HashMap map);

    /**
     * 查询list集合
     *
     * @param key
     * @return
     */
    public List getList(String key);

    /**
     * 保存list值至列表头
     *
     * @param key
     * @param values
     */
    public void leftListPush(String key, String... values);

    /**
     * 保存list至列表头
     *
     * @param key
     * @param value
     */
    public void leftSetList(String key, List value);

    /**
     * 保存list值至列表尾
     *
     * @param key
     * @param values
     */
    public void rightListPush(String key, String... values);

    /**
     * 保存list至列表尾
     *
     * @param key
     * @param value
     */
    public void rightSetList(String key, List value);

    /**
     * 弹出列表头元素
     *
     * @param key
     * @return
     */
    public String leftListPop(String key);

    /**
     * 弹出列表尾元素
     *
     * @param key
     * @return
     */
    public String rightListPop(String key);

    /**
     * 删除list中值
     * count> 0：删除等于从头到尾移动count个等于value的元素
     * count <0：删除等于从尾到头移动count个等于value的元素
     * count = 0：删除等于value的所有元素
     *
     * @param key
     * @param count
     * @param value
     */
    public void ListRemove(String key, long count, Object value);

}
