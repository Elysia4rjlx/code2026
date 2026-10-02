package com.elyjah._026_10_02springloc.v1;


public class Main {

    public static void main(String[] args) {

        LandingGearTire landingGearTire = new LandingGearTire();
        Bottom bottom = new Bottom(landingGearTire);
        Ariframe ariframe = new Ariframe(bottom);
        Airplane airplane = new Airplane(ariframe);

        airplane.run();
    }
}