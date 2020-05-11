package com.akoca.mvc.domain.test;

import java.io.Serializable;

public class VisitorCount implements Serializable {


    private static final long serialVersionUID = -4553868496095579705L;

    private int count;

    public VisitorCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
