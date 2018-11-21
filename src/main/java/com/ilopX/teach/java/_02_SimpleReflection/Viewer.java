package com.ilopX.teach.java._02_SimpleReflection;

import java.lang.annotation.Annotation;

public class Viewer {

    public static void printAnnotationValues(Annotation[] annotations) {
        for(Annotation annotation : annotations){
            if(annotation instanceof Name){
                Name nameAnnotation = (Name) annotation;
                System.out.println("minNameLength: " + nameAnnotation.minNameLength());
                System.out.println("maxNameLength: " + nameAnnotation.maxNameLength());
            }
        }
    }
}
