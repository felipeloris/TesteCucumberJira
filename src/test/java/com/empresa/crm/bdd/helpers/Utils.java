package com.empresa.crm.bdd.helpers;

public final class Utils {
    public static void Wait(int timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
