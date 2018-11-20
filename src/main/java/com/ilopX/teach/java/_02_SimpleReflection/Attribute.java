package com.ilopX.teach.java._02_SimpleReflection;

import java.lang.reflect.Field;

public class Attribute {

    public static class FoundData {
        private int idValue;
        private String nameValue;

        public FoundData(int idValue, String nameValue) {
            this.idValue = idValue;
            this.nameValue = nameValue;
        }
        public int getIDValue() {
            return idValue;
        }

        public String getNameValue() {
            return nameValue;
        }

        public static void printNameAnnotationValues(Object obj) {
            try {
                Field field = obj.getClass().getDeclaredField("name");
                Name anno = field.getAnnotation(Name.class);
                System.out.println("Values of annotation members: "
                        + "minNameLength: " + anno.minNameLength()
                        + ", maxNameLength: " + anno.maxNameLength());
            } catch (NoSuchFieldException | NullPointerException exc) {
                System.out.println("Field or annotation not found!");
            }
        }
    }

    public static FoundData Find(Object obj) throws IllegalAccessException {
        int idValue = 0;
        String nameValue = null;
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Name.class)) {
                nameValue = (String) field.get(obj);
            }
            else if (field.isAnnotationPresent(ID.class)) {
                idValue = (Integer) field.get(obj);
            }
        }
        return new FoundData(idValue, nameValue);
    }
}
