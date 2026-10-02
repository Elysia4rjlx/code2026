package com.elyjah._026_10_02springloc.v1;


import org.springframework.beans.factory.annotation.Autowired;

public class Airplane {

    @Autowired
    public Airplane(Ariframe ariframe) {
        System.out.println("Airplane init...");
    }
    public void run() {
        System.out.println("Airplane run...");
    }
}