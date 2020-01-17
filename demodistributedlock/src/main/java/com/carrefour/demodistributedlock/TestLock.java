package com.carrefour.demodistributedlock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLock {

    @Autowired
    private DistributedLockHandler distributedLockHandler;

    @RequestMapping("testlock")
    public String testlock(){
        Lock lock=new Lock("jack","liqingjun918");
        if(distributedLockHandler.tryLock(lock)){
            try {
                //为了演示锁的效果，这里睡眠5000毫秒
                System.out.println("执行方法 TestLock");
                Thread.sleep(10000);
            }catch (Exception e){
                e.printStackTrace();
            }
            distributedLockHandler.releaseLock(lock);
            System.out.println("锁已经释放");
        }
        return "test Lock success!";
    }
}