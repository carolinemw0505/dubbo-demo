package com.spring.dubbo.service;

import java.util.List;
import java.util.Map;

public interface redisUtilityApi {

    public List<Map<String,Object>> queryAll();

    public List<Map<String,Object>> getByKey(String key);

    public Map<String,Object> getKey(String key);
}
