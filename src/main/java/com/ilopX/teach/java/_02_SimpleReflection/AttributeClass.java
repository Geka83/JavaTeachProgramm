package com.ilopX.teach.java._02_SimpleReflection;

public class AttributeClass {
    @Name(minNameLength = 5, maxNameLength = 10)
    private String name;
    @ID
    private int id;

    public AttributeClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
