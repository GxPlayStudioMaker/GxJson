package com.json.gx.reflection;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.reflect.Field;
import java.util.List;

public class AttributesGet {
public HashMap<String,Object> map;
public List<Object> va = new ArrayList<Object>();
public List<String> names = new ArrayList<String>();
public Class<?> getClassFrom(Object obj){
	return obj.getClass();
}
public void getValueType(Object t){
	  Class<?> gameClass = t.getClass();
        Field[] fields = gameClass.getFields();  // Obter todos os campos públicos

        for (Field field : fields) {
            try {
                field.setAccessible(true);  // Necessário se o campo não for público
                Object value = field.get(t);
              //  System.out.println("Nome do campo: " + field.getName());
             //   System.out.println("Valor do campo: " + value);
				 va.add(value);
				 names.add(field.getName());
				//map.put(field.getName(),value);
				
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}