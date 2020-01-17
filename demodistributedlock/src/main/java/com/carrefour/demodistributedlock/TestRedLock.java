package com.carrefour.demodistributedlock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRedLock {

    @Autowired
    private DistributedLocker distributedLocker;

    @RequestMapping("testredlock")
    public String testredlock()throws Exception{
        distributedLocker.lock("test",new AquiredLockWorker<Object>() {

            @Override
            public Object invokeAfterLockAquire() {
                try {
                    System.out.println("执行方法 TestRedLock！");
                    Thread.sleep(10000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return null;
            }

        });
        return "test RedLock success !";
    }
}