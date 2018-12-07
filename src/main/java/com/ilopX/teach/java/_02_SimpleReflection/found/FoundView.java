package com.ilopX.teach.java._02_SimpleReflection.found;

public class FoundView {
    private FoundData foundData;

    public FoundView(FoundData foundData) {
        this.foundData = foundData;
    }

    @Override
    public String toString() {
        return "Found: "
                    + "id=" + foundData.getIDValue()
                    + " name=" + foundData.getNameValue()
                    + " minNameLength=" + foundData.getNameAnnotation().minNameLength()
                    + " maxNameLength=" + foundData.getNameAnnotation().maxNameLength();
    }
}
