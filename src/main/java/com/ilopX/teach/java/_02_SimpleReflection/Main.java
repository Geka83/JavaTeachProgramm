package com.ilopX.teach.java._02_SimpleReflection;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        var attributeClass = new AttributeClass(150, "Some Name");

        var foundData = Attribute.Find(attributeClass);

        if (foundData != null) {
            System.out.println("Found: " +
                    "id=" + foundData.getIDValue() + " " +
                    "name=" + foundData.getNameValue());
            Viewer.printAnnotationValues(Attribute.getAnnotationFild(attributeClass, "name"));
        }


    }
}
