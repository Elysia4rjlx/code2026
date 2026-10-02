package com.elyjah._026_10_02springloc.v1;


import org.springframework.beans.factory.annotation.Autowired;

public class Bottom {

    @Autowired
    public Bottom(LandingGearTire landingGearTire) {
        System.out.println("bottom init...");
    }
}