package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

/**
 * Created by Admin on 16.08.2018.
 */
/*класс является прокси оберткой к originalRetriever*/
public class CachingProxyRetriever implements Retriever{
    private Storage storage;
    private OriginalRetriever originalRetriever;
    private LRUCache<Long, Object> lruCache;

    public CachingProxyRetriever(Storage storage){
        this.storage= storage;
        originalRetriever= new OriginalRetriever(storage);
        lruCache = new LRUCache<>(16);
    }

    @Override
    public Object retrieve(long id) {
        Object obj= lruCache.find(id);// выполняем поиск необходимого объекта в кэше
           if (obj == null) {// если объекта в кэше нет, то выполняем загрузку из storage
            obj = originalRetriever.retrieve(id);
            lruCache.set(id, obj);
        }
        return obj;
    }

}
