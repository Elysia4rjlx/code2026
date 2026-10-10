package com.example.iov.lab._026_10_10springiocdilab2.scan;

import org.springframework.stereotype.Component;

@Component
public class InnerService {

    public void sayHi() {
        System.out.println("hello,InnerService (我在扫描范围内)");
    }
}