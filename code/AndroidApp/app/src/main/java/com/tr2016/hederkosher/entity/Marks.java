package com.tr2016.hederkosher.entity;

import java.util.List;

/**
 * Created by Igor on 12.08.2016.
 */
public class Marks {
    private Object object;
    private List<Mark> markList;

    public Marks(Object object, List<Mark> markList) {
        checkObj(object);

        this.object = object;
        this.markList = markList;
    }

    private void checkObj(Object object) {
        Class cl = object.getClass();
        if (!cl.isAnnotationPresent(Markable.class))
            throw new RuntimeException("Class is not markable");
    }

    public Marks() {
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        checkObj(object);
        this.object = object;
    }

    public List<Mark> getMarkList() {
        return markList;
    }

    public void setMarkList(List<Mark> markList) {
        this.markList = markList;
    }
}
