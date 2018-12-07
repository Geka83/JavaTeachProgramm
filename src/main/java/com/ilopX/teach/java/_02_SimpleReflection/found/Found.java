package com.ilopX.teach.java._02_SimpleReflection.found;

import com.ilopX.teach.java._02_SimpleReflection.attribute.AnnotationNotFoundException;
import com.ilopX.teach.java._02_SimpleReflection.attribute.ID;
import com.ilopX.teach.java._02_SimpleReflection.attribute.Name;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Found {

    public static class FoundData {
        private int idValue;
        private String nameValue;
        private Name nameValues;

        public FoundData(int idValue, String nameValue, Name nameValues) {
            this.idValue = idValue;
            this.nameValue = nameValue;
            this.nameValues = nameValues;
        }
        public int getIDValue() {
            return idValue;
        }

        public String getNameValue() {
            return nameValue;
        }

        public Name getNameValues() {
            return nameValues;
        }
    }

    public static class FoundView {

        public void printFoundDataValues(Found.FoundData foundData) {
            System.out.println("Found: "
                    + "id=" + foundData.getIDValue()
                    + " name=" + foundData.getNameValue()
                    + " minNameLength=" + foundData.getNameValues().minNameLength()
                    + " maxNameLength=" + foundData.getNameValues().maxNameLength());
        }
    }

    public static FoundData Find(Object obj) throws IllegalAccessException {
        int idValue = 0;
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
                throw new AnnotationNotFoundException("AnnotationNotFound");
            }
        }
    }
}
