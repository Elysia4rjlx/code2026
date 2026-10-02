package com.elyjah._026_10_02springloc.v1;


import org.springframework.beans.factory.annotation.Autowired;

public class Ariframe {

    @Autowired
    public Ariframe(Bottom bottom) {
        System.out.println("Ariframe init...");
    }
}
