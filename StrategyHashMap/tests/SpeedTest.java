package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


import static javafx.beans.binding.Bindings.greaterThan;

/**
 * Created by Admin on 14.08.2018.
 */
/*получить идентификатор для строки используя стратегию HashBiMapStorageStrategy можно быстрее,
 чем используя стратегию HashMapStorageStrategy.*/
public class SpeedTest {
    /*должен возвращать время в миллисекундах необходимое
     для получения идентификаторов для всех строк из strings.
      Идентификаторы должны быть записаны в ids.*/
    public  long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date startGetIds= new Date();
        for(String s:strings){
            ids.add(shortener.getId(s));
        }
        Date endGetIds= new Date();
        return (endGetIds.getTime() - startGetIds.getTime());
    }
    /*должен возвращать время в миллисекундах необходимое
    для получения строк для всех строк из ids.
     Строки должны быть записаны в strings.*/
   public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date startGetStrings= new Date();
        for(Long id:ids){
            strings.add(shortener.getString(id));
        }
       Date endGetStrings= new Date();
       return (endGetStrings.getTime()-startGetStrings.getTime());
    }

    @Test
    public void testHashMapStorage(){

         /*Создавать два объекта типа Shortener,
     один на базе HashMapStorageStrategy,
      второй на базе HashBiMapStorageStrategy. shortener1 и shortener2.*/
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        /*Генерировать с помощью Helper 10000 строк и помещать их в сет со строками, origStrings.*/
        Set<String> origStrings = new HashSet<>();

        Set<Long> idsHashMapStorageStrategy = new HashSet<>();
        Set<Long> idsHashBiMapStorageStrategy = new HashSet<>();
        for(int i=0; i<10000; i++){
            origStrings.add(Helper.generateRandomString());
        }
        /*Получать время получения идентификаторов для origStrings
         (вызывать метод getTimeForGettingIds для shortener1, а затем для shortener2).*/
        Long timeForHashMapStorageStrategy = getTimeForGettingIds(shortener1, origStrings, idsHashMapStorageStrategy);
        Long timeForHashBiMapStorageStrategy = getTimeForGettingIds(shortener2, origStrings, idsHashBiMapStorageStrategy);

        /*Проверять с помощью junit, что время, полученное в предыдущем пункте для shortener1 больше, чем для shortener2.*/
       // Assert.assertThat(timeForHashMapStorageStrategy, greaterThan(timeForHashBiMapStorageStrategy));

        Set<String> stringsHashMapStorageStrategy = new HashSet<>();
        Set<String> stringsHashBiMapStorageStrategy = new HashSet<>();
        Long timeForStringsForHashMapStorageStrategy = getTimeForGettingStrings(shortener1, idsHashMapStorageStrategy, stringsHashMapStorageStrategy);
        Long timeForStringsForHHashBiMapStorageStrategy = getTimeForGettingStrings(shortener2, idsHashBiMapStorageStrategy, stringsHashBiMapStorageStrategy);
        Assert.assertEquals(timeForStringsForHashMapStorageStrategy, timeForStringsForHHashBiMapStorageStrategy, 30);
    }
}
