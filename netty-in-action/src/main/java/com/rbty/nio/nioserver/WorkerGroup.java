package com.rbty.nio.nioserver;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/5/21 10:59
 */
public class WorkerGroup {
    WorkerEventLoop[] group ;
    public WorkerGroup(int num){
        group = new WorkerEventLoop[num];
    }
}
