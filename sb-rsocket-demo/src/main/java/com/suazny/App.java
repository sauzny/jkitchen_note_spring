package com.suazny;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        var date = LocalDate.now();
        long money = 200L;
        for(int i=0; i<100; i++){
            System.out.println(date + " = " + money);
            date = date.plusDays(1L);
            money += money*0.2;
        }
    }
}
