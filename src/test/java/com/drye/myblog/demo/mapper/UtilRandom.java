package com.drye.myblog.demo.mapper;

import java.util.concurrent.ThreadLocalRandom;

public class UtilRandom {
    public static String RandomString() {
        StringBuilder builder = new StringBuilder();
        double d = Math.random();
        int rad = (int) (d * 500);
        for (int j = 0; j < rad; j++) {

            for (int k = 0; k < 10; k++) {
                builder.append((char) (ThreadLocalRandom.current().nextInt(33, 128)));
            }
            System.out.print(builder);
        }
        return builder.toString();
    }
}
