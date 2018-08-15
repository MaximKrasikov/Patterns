package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Admin on 09.08.2018.
 */
/* аналог Map.Entry<> */
public class Entry implements Serializable {

    /*реализация будет поддерживать только тип Long для ключа и только String для значения. */
    Long key;
    String value;
    Entry next;
    int hash;

    public Entry(int hash, Long key, String value, Entry next){
        this.hash= hash;
        this.key= key;
        this.value= value;
        this.next= next;
    }
    public Long getKey(){
        return key;
    }
    public String getValue(){
        return  value;
    }
    /*(e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
      (e.getValue()==null ? 0 : e.getValue().hashCode())*/
    public int hashCode(){
        return (key==null? 0: key.hashCode())^(value==null ? 0: value.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Entry))
            return false;

        Long k1 = getKey();
        Long k2 = ((Entry) o).getKey();
        String v1 = getValue();
        String v2 = ((Entry) o).getValue();
        if (k1 == k2 || (k1 != null && k1.equals(k2))) {
            if (v1 == v2 || (v1 != null && v1.equals(v2))) {
                return true;
            }
        }

        return false;
    }

    public String toString(){
        return new String(key + "=" + value);
    }
}
