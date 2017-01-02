package com.tr2016.hederkosher.utils;

/**
 * Created by user on 23/12/16.
 */

public class Task {
    private String name;
    private String set;
    private String repeat;
    private String weight;
    private int pause;
    private int timer;
    private int pauseProcess;
    private int timerProcess;

    public Task() {
    }

    public Task(String name, String set, String repeat, String weight, int timer, int pause) {
        this.name = name;
        this.set = set;
        this.repeat = repeat;
        this.weight = weight;
        this.timer = timer;
        this.pause = pause;
        this.timerProcess = timer;
        this.pauseProcess = pause;
    }

    public String getName() {
        return name;
    }

    public String getSet() {
        return set;
    }

    public String getRepeat() {
        return repeat;
    }

    public String getWeight() {
        return weight;
    }

    public int getPause() {
        return pause;
    }

    public int getTimer() {
        return timer;
    }

    public int getPauseProcess() {
        return pauseProcess;
    }

    public int getTimerProcess() {
        return timerProcess;
    }

    public void setPauseProcess(int pauseProcess) {
        this.pauseProcess = pauseProcess;
    }

    public void setTimerProcess(int timerProcess) {
        this.timerProcess = timerProcess;
    }
}