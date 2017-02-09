package com.tel_ran.hederkosher.test;

import io.github.benas.randombeans.api.Randomizer;

import java.util.Random;

class IntRandomizer implements Randomizer<Integer> {
    private Random random = new Random();
    private int limit;

    public IntRandomizer() {
    }

    public IntRandomizer(int limit) {
        this.limit = limit;
    }

    @Override
    public Integer getRandomValue() {
        return random.nextInt(limit);
    }

    public Integer getRandomValue(int limit) {
        return random.nextInt(limit);
    }
}
