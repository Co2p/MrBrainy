package com.mrbrainy.app;

public class Wait {

    public static void sec(int time){
        try {
            Thread.currentThread();
            Thread.sleep(time);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
