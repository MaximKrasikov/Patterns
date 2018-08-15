package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Admin on 13.08.2018.
 */
public class FunctionalTest {

    public  void  testStorage(Shortener shortener){
        //Создавать три строки. Текст 1 и 3 строк должен быть одинаковым.
        String str1, str2, str3;
        str1 = Helper.generateRandomString();
        str2 = Helper.generateRandomString();
        str3 = String.copyValueOf(str1.toCharArray());
        // Получать и сохранять идентификаторы для всех трех строк с помощью shortener
        long id1= shortener.getId(str1);
        long id2= shortener.getId(str2);
        long id3 = shortener.getId(str3);
        //Проверять, что идентификатор для 2 строки не равен идентификатору для 1 и 3 строк.
        Assert.assertNotEquals(id1, id2);
        Assert.assertNotEquals(id2, id3);
        //Проверять, что идентификаторы для 1 и 3 строк равны.
        Assert.assertEquals(id1, id3);
        //Получать три строки по трем идентификаторам с помощью shortener.
        String newStr1 = shortener.getString(id1);
        String newStr2 = shortener.getString(id2);
        String newStr3 = shortener.getString(id3);
        //Проверять, что строки, полученные в предыдущем пункте, эквивалентны оригинальным.
        Assert.assertEquals(str1, newStr1);
        Assert.assertEquals(str2, newStr2);
        Assert.assertEquals(str3, newStr3);
    }

    /*создавать подходящую стратегию,
    создавать объект класса Shortener на базе этой стратегии и вызывать метод testStorage для него.*/
    @Test
    public void testHashMapStorageStrategy(){
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }
    @Test
    public void testOurHashMapStorageStrategy(){
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy(){
        Shortener shortener = new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy(){
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){
        Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }
}
