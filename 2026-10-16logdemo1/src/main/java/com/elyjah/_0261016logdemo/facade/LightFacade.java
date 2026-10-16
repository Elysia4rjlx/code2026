package com.elyjah._0261016logdemo.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * 外观模式
 */
@Slf4j
public class LightFacade {

    //三个字段都声明成Light 接口类型，不是具体类型
    private final Light livingRoomLight = new LivingRoomLight();
    private final Light hallLight = new HallLight();
    private final Light diningLight = new DiningLight();

    /**
     * 开所有灯——外观暴露给客户端的统一接口
     */
    public void lightOn() {
        log.info("---开始执行：打开所有灯。。。---");
        livingRoomLight.on();
        hallLight.on();
        diningLight.on();
        log.info("---执行成功！---");
    }

    public void lightOff() {
        log.info("---开始执行：关闭所有灯。。。---");
        livingRoomLight.off();
        hallLight.off();
        diningLight.off();
        log.info("---执行成功！!---");
    }
}