package com.maktab.task.model;

public class Task {
    private String name;
    private StateEnum stateEnum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StateEnum getStateEnum() {
        return stateEnum;
    }

    public void setStateEnum(StateEnum stateEnum) {
        this.stateEnum = stateEnum;
    }
}
