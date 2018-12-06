package com.ilopX.teach.java._02_SimpleReflection;

import com.ilopX.teach.java._02_SimpleReflection.attribute.AnnotationNotFoundException;
import com.ilopX.teach.java._02_SimpleReflection.attribute.AttributeClass;
import com.ilopX.teach.java._02_SimpleReflection.data.Found;

public class Main {

    public static void main(String[] args) throws AnnotationNotFoundException, IllegalAccessException {
            var attributeClass = new AttributeClass(150, "Some Name");
            Found.findThrows(attributeClass);
            var foundData = Found.Find(attributeClass);

            if (foundData != null) {
                var foundView = new Found.FoundView();
                foundView.printFoundDataValues(foundData);
            } else {
                System.err.println("Found.FoundData foundData == Null!");
            }
    }
}
