package com.ilopX.teach.java._02_SimpleReflection.found;

public class FoundDataView {
    private FoundData foundData;

    public FoundDataView(FoundData foundData) {
        this.foundData = foundData;
    }
    private boolean visibleAnnotationParameters = false;
    public void setVisibleAnnotationParameters(boolean visible) {
        visibleAnnotationParameters = visible;
    }
    @Override
    public String toString() {
        var renderMessage = "Found: "
                + "id=" + foundData.getIDValue()
                + " name=" + foundData.getNameValue();

        if (visibleAnnotationParameters)
            renderMessage += " minNameLength=" + foundData.getNameAnnotation().minNameLength()
                    + " maxNameLength=" + foundData.getNameAnnotation().maxNameLength();
        return renderMessage;
    }
}
