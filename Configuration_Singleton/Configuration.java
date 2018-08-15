package com.javarush.task.Configuration_Singleton;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by Admin on 15.08.2018.
 */
/*Мне приходится чаще всего использовать этот паттерн при работе с конфигурацией.
Иногда конфигурацию программы удобно хранить в файле.
 Допустим, это будет простой текстовый файл "props.txt" со строками типа "ключ=значение".
  Нам нужно гарантировать, что конфигурация в программе будет в единственном экземпляре.
Вторую мы бы и так не создали, но нужно запретить это делать пользователю класса.*/

/*Теперь для работы с конфигурацией можно использовать конструкцию вида:
String propValue = Configuration.getInstance().getProperty(propKey).

Если имена свойств в "props.txt" меняться не будут, можно описать их в классе таким образом:
public static final String PROP_KEY = "propKey",

а значения получать так:
String propValue = Configuration.getInstance()
    .getProperty(Configuration.PROP_KEY).
*/

public class Configuration {
    private static Configuration _instance = null;

    private Properties props = null;

    private Configuration() {
        props = new Properties();
        try {
            FileInputStream fis = new FileInputStream(
                    new File("props.txt"));
            props.load(fis);
        }
        catch (Exception e) {
            // обработайте ошибку чтения конфигурации
        }
    }

    public synchronized static Configuration getInstance() {
        if (_instance == null)
            _instance = new Configuration();
        return _instance;
    }

    // получить значение свойства по имени
    public synchronized String getProperty(String key) {
        String value = null;
        if (props.containsKey(key))
            value = (String) props.get(key);
        else {
            // сообщите о том, что свойство не найдено
        }
        return value;
    }
}