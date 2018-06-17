package com.niocoder.niocoder.thread;

import lombok.extern.java.Log;

/**
 * Created on 2018/6/17.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Log
public class SyncObj {

    public synchronized void showA(){
        log.info("show A...");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void showB(){
        synchronized (this){
            log.info("show B...");
        }
    }

    public void showC(){
        String s = "1";
        synchronized (s){
            log.info("show C...");
        }
    }
}
