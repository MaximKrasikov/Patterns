package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

public class Shortener {
    private Long lastId= Long.valueOf(0);//отвечает за  последнее значение идентификатора,
                                        // которое было использовано при добавлении новой строки в хранилище.
     private StorageStrategy storageStrategy; //будет храниться стратегия хранения данных.
    public Shortener(StorageStrategy storageStrategy){
        this.storageStrategy= storageStrategy;
    }
    /* getId будет возвращать идентификатор id для заданной строки.*/
    /* Проверить есть ли переданное значение в хранилище, если есть - вернуть его ключ.
       Если преданного значения нет в хранилище, то:
       Увеличить значение lastId на единицу;
        Добавить в хранилище новую пару ключ-значение (новое значение lastId и переданную строку);
        Вернуть новое значение lastId.*/
    public synchronized Long getId(String string){
        if(storageStrategy.containsValue(string)){
            return storageStrategy.getKey(string);
        }else {
            lastId++;
            storageStrategy.put(lastId,string);
        }
        return lastId;
    }
// getString будет возвращать строку для заданного идентификатора или null, если передан неверный идентификатор.
    /*должен вернуть строку по заданному идентификатору (ключу).
     Предусмотреть возможность вызова методов getId и getString из разных потоков добавив соответствующий модификатор к заголовкам методов.*/
    public synchronized String getString(Long id){
        return storageStrategy.getValue(id);
    }
}
