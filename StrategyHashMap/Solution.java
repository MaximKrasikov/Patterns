package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String [] args){
        /*тест стратегии */

        /*StorageStrategy strategy1= new HashMapStorageStrategy();
        testStrategy(strategy1,1000);*/
        Solution s = new Solution();
        HashMapStorageStrategy strategy = new HashMapStorageStrategy();
        s.testStrategy(strategy, 100);
        OurHashMapStorageStrategy strategy1 = new OurHashMapStorageStrategy();
        s.testStrategy(strategy1, 100);
        FileStorageStrategy strategy2 = new FileStorageStrategy();
        s.testStrategy(strategy2, 100);
        OurHashBiMapStorageStrategy strategy3= new OurHashBiMapStorageStrategy();
        s.testStrategy(strategy3,100);
        HashBiMapStorageStrategy strategy4= new HashBiMapStorageStrategy();
        s.testStrategy(strategy4,100);
        DualHashBidiMapStorageStrategy strategy5 = new DualHashBidiMapStorageStrategy();
        s.testStrategy(strategy5, 100);

    }
    /*. Этот метод должен
    для переданного множества строк возвращать множество идентификаторов. Идентификатор для каждой
    отдельной строки нужно получить, используя shortener.*/
   public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> result= new HashSet<>();
       for(String s : strings){
           result.add(shortener.getId(s));
       }
       return  result;
   }
    /*. Метод будет
    возвращать множество строк, которое соответствует переданному множеству идентификаторов.
    При реальном использовании Shortener, задача получить из множества строк
    множество идентификаторов и наоборот скорее всего не встретится, это нужно исключительно для тестирования.*/
   public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
       Set<String> result= new HashSet<>();
       for(Long id: keys){
           result.add(shortener.getString(id));
       }
       return  result;
   }
    /*Метод будет
    тестировать работу переданной стратегии на определенном количестве
    элементов elementsNumber*/

   public static void  testStrategy(StorageStrategy strategy, long elementsNumber){
       /*Выводить имя класса стратегии. Имя не должно включать имя пакета.*/
       Helper.printMessage("Имя класса стратегии: "+strategy.getClass().getSimpleName());

       /*Генерировать тестовое множество строк, используя Helper и заданное
        количество элементов elementsNumber.*/
       Set<String> strings= new HashSet<>();
       Long[] elements = new Long[(int) elementsNumber];
       for(int i=0 ; i<elementsNumber; i++){
           strings.add(Helper.generateRandomString());
       }
       /*Создавать объект типа Shortener, используя переданную стратегию.*/
       Shortener shortener= new Shortener(strategy);

        /*Замерять и выводить время необходимое для отработки метода getIds
        для заданной стратегии и заданного множества элементов. */
       Date startDateTime= new Date();
       Set<Long> ids= getIds(shortener,strings);
       Date finishDateTime= new Date();
       long deltaTime= finishDateTime.getTime()- startDateTime.getTime();
       Helper.printMessage("Обработка метода getIds: "+Long.toString(deltaTime));

       /*Замерять и выводить время необходимое для отработки метода
        getStrings для заданной стратегии и полученного в предыдущем пункте
        множества идентификаторов.*/
       startDateTime= new Date();
       Set<String> strs= getStrings(shortener,ids);
       finishDateTime= new Date();
       deltaTime= finishDateTime.getTime()- startDateTime.getTime();
       Helper.printMessage("Обработка метода getStrings: "+Long.toString(deltaTime));

       /*Сравнивать одинаковое ли содержимое множества строк, которое было
       сгенерировано и множества, которое было возвращено методом
       getStrings. Если множества одинаковы, то выведи "Тест пройден.",
               иначе "Тест не пройден.".*/
       if (strings.equals(strs)){
           Helper.printMessage("Тест пройден.");
       }else{
           Helper.printMessage("Тест не пройден.");
       }
   }

}
