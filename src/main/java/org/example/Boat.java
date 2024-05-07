package org.example;

/**
 * @author rd_qinglin_mu
 * @description polymorlism
 * @单据标识
 * @date 2024/5/7 15:21
 **/
public class Boat extends Vehicle{
    @Override
    void go(){
        System.out.println("The boat begins moving");
    }
}
