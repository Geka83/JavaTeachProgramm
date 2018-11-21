package com.ilopX.teach.java._02_SimpleReflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Found {

    public static class FoundData {
        private int idValue;
        private String nameValue;
        private Annotation[] annotations;

        public FoundData(int idValue, String nameValue, Annotation[] annotations) {
            this.idValue = idValue;
            this.nameValue = nameValue;
            this.annotations = annotations;
        }
        public int getIDValue() {
            return idValue;
        }

        public String getNameValue() {
            return nameValue;
        }

        public Annotation[] getAnnotations() {
            return annotations;
        }
    }

    public static class FoundView {

        public void printValuesAnnotationName(Annotation[] parametersName) {

            for(Annotation annotation : parametersName) {
                Name nameAnnotation = (Name) annotation;
                System.out.println("minNameLength: " + nameAnnotation.minNameLength());
                System.out.println("maxNameLength: " + nameAnnotation.maxNameLength());
            }
        }
    }

    public static FoundData Find(Object obj) throws IllegalAccessException {
        int idValue = 0;
        String nameValue = null;
        Annotation[] parametersName = null;
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Name.class)) {
                nameValue = (String) field.get(obj);
                parametersName = field.getDeclaredAnnotations();
            }
            else if (field.isAnnotationPresent(ID.class)) {
                idValue = (Integer) field.get(obj);
            }
        }
        return new FoundData(idValue, nameValue, parametersName);
    }
}
