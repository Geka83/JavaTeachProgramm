package com.ilopX.teach.java._02_SimpleReflection;

public class AnnotationNotFoundException extends Exception {
    public AnnotationNotFoundException(String message) {
        System.err.println(message);
    }
}
