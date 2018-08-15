package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.ExceptionHandler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

/**
 * Created by Admin on 11.08.2018.
 */
public class FileBucket {
    Path path;//путь к файлу

    public FileBucket() {
        try{
            path =Files.createTempFile(null,null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        }catch(IOException e){
            ExceptionHandler.log(e);// собственный ExHandler
        }
        path.toFile().deleteOnExit();
    }
    //getFileSize должен возвращать размер файла на который указывает path.
   public  long getFileSize(){
       try{
           return Files.size(path);
       }catch(IOException e){
            e.printStackTrace();
       }
       return 0;
    }
    //putEntry должен сериализовывать переданный entry в файл. Учти, каждый entry может содержать еще один entry.
    public void putEntry(Entry entry){
        try(ObjectOutputStream objectOutputStream= new ObjectOutputStream(Files.newOutputStream(path)) ){
            objectOutputStream.writeObject(entry);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    // getEntry должен забирать entry из файла. Если файл имеет нулевой размер, вернуть null.
    public Entry getEntry()  {
        Entry entry= null;
        if(getFileSize()<=0){
            return null ;
        }
        try(ObjectInputStream inputStream= new ObjectInputStream(Files.newInputStream(path))){
            try {
                entry= (Entry)inputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return entry;
    }

    //удалять файл на который указывает path.
    public void remove(){
        try {
            Files.delete(path);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
