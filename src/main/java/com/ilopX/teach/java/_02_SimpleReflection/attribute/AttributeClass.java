package com.ilopX.teach.java._02_SimpleReflection.attribute;

import com.ilopX.teach.java._02_SimpleReflection.attribute.ID;
import com.ilopX.teach.java._02_SimpleReflection.attribute.Name;

public class AttributeClass {
    @ID
    private int id;
    @Name(minNameLength = 5, maxNameLength = 10)
    private String name;

    public AttributeClass(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
