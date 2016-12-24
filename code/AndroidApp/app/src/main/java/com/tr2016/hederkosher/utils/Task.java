package com.tr2016.hederkosher.utils;

/**
 * Created by user on 23/12/16.
 */

public class Task {
    private String task;
    private String set;
    private String repeat;
    private String weight;
    private String timer;

    public Task() {
    }

    public Task(String task, String set, String repeat, String weight, String timer) {
        this.task = task;
        this.set = set;
        this.repeat = repeat;
        this.weight = weight;
        this.timer = timer;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }
}