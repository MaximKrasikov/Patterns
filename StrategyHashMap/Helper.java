package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Admin on 09.08.2018.
 */
public class Helper {
    /*будет генерировать случайную строку.
     Воспользуемся для этого классами SecureRandom и BigInteger.
      Строка может состоять из цифр и любой из 26 маленьких букв английского алфавита.*/
    public static String generateRandomString(){
        SecureRandom secureRandom= new SecureRandom();
        return new BigInteger(130, new SecureRandom()).toString(36);
    }
    /*должен выводить переданный текст в консоль. Весь дальнейший вывод в программе должен быть реализован через этот метод!*/
    public static void printMessage(String message){
        System.out.println(message);
    }
}
