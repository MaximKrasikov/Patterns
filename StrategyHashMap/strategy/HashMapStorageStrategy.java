package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.HashMap;

/**
 * Created by Admin on 09.08.2018.
 */
public  class HashMapStorageStrategy implements StorageStrategy {
    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key,value);
    }

    @Override
    public Long getKey(String value) {
        for(Long key:data.keySet()){
            if(data.get(key).equals(value)){
                return key;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }

    private HashMap<Long, String> data= new HashMap<>();

}
