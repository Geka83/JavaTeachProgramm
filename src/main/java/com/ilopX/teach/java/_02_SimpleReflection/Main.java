package com.ilopX.teach.java._02_SimpleReflection;
import com.ilopX.teach.java._02_SimpleReflection.example.AttributeClass;
import com.ilopX.teach.java._02_SimpleReflection.found.Found;
import com.ilopX.teach.java._02_SimpleReflection.found.FoundDataView;

public class Main {
    public static void main(String[] args) {
        var attributeClass = new AttributeClass(150, "Some Name");
        try {
            var foundData = Found.findThrows(attributeClass);
            var view = new FoundDataView(foundData);
            view.setVisibleAnnotationParameters(false);
            System.out.println(view);
        } catch (AnnotationNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
