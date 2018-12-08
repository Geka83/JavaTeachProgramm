package com.ilopX.teach.java._02_SimpleReflection.found;

import com.ilopX.teach.java._02_SimpleReflection.AnnotationNotFoundException;
import com.ilopX.teach.java._02_SimpleReflection.annotation.ID;
import com.ilopX.teach.java._02_SimpleReflection.annotation.Name;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Found {
    public static FoundData Find(Object obj) {
        try {
            return findThrows(obj);
        } catch (AnnotationNotFoundException e) {
            return null;
        }
    }

        String nameValue = null;
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Annotation idAnnotation = field.getAnnotation(ID.class);
            Annotation nameAnnotation = field.getAnnotation(Name.class);

            if(idAnnotation instanceof ID){
                idValue = field.getInt(obj);
            }
            else if (nameAnnotation instanceof Name) {
                nameValue = (String) field.get(obj);
                return new FoundData(idValue, nameValue, (Name) nameAnnotation);
            }
        }
        return null;
    }

    public static void findThrows(Object obj) throws AnnotationNotFoundException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(Name.class) & !field.isAnnotationPresent(ID.class)) {
                throw new AnnotationNotFoundException();
            }
        }
    }
}
