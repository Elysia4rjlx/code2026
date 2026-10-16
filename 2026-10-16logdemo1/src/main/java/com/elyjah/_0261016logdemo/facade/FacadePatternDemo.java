package com.elyjah._0261016logdemo.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FacadePatternDemo {
    public static void main(String[] args) {
        //客户端
        //只和LightFacade 外观 打交道，不认识子系统
        LightFacade facade = new LightFacade();

        facade.lightOn();
        facade.lightOff();
    }

}