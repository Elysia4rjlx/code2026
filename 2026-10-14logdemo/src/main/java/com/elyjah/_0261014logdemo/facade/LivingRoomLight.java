package com.elyjah._0261014logdemo.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LivingRoomLight implements Light {

    @Override
    public void on() {
        log.info("打开客厅灯");
    }

    @Override
    public void off() {
        log.info("关闭客厅灯");
    }
}