package com.example.iov.lab.outofscan;

import org.springframework.stereotype.Service;

@Service
public class OuterService {

    public void sayHi () {
        System.out.println("hello, OuterService（我在扫描范围外）");
    }
}