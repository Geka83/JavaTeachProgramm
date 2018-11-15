package com.ilopX.teach.java._02_SimpleReflection;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws Exception{
        var attributeClass = new AttributeClass(150, "Some Name");
        var foundData = Attribute.Find(attributeClass);

        if (foundData != null) {
            System.out.println("Found: " +
                    "id=" + foundData.getIDValue() + " " +
                    "name=" + foundData.getNameValue());
        }
    }
}
