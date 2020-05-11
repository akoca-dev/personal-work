package com.akoca.exercise.dto;

import java.io.Serializable;

public abstract class AbstractDto implements Serializable , Cloneable {

    private static final long serialVersionUID = 2560677860237500068L;

    @Override
    public AbstractDto clone() throws CloneNotSupportedException {
        AbstractDto clone = (AbstractDto)super.clone();

        initialize();

        return clone;
    }

    private void initialize() {
        //Initialize object state

        reset();
    }

    protected abstract void reset();
}