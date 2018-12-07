package com.ilopX.teach.java._02_SimpleReflection.found;

import com.ilopX.teach.java._02_SimpleReflection.annotation.Name;

public class FoundData {
    private int idValue;
    private String nameValue;
    private Name nameValues;

    public FoundData(int idValue, String nameValue, Name nameValues) {
        this.idValue = idValue;
        this.nameValue = nameValue;
        this.nameValues = nameValues;
    }

    public int getIDValue() {
        return idValue;
    }

    public String getNameValue() {
        return nameValue;
    }

    public Name getNameAnnotation() {
        return nameValues;
    }
}
