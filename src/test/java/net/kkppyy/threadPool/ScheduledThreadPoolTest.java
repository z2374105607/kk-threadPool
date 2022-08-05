package net.kkppyy.threadPool;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ScheduledThreadPoolTest {
	@Test
	public void threadTest() throws InterruptedException{
	      for (int i = 0; i < 3; i++) {
	            Task worker = new Task("task-" + i);
	            // 只执行一次
//	          scheduledThreadPool.schedule(worker, 5, TimeUnit.SECONDS);
	            // 周期性执行，每5秒执行一次
	            ScheduledThreadPool.scheduled.scheduleAtFixedRate(worker, 0,5, TimeUnit.SECONDS);
	        }

	        Thread.sleep(10000);

	        System.out.println("Shutting down executor...");
	        // 关闭线程池
	        ScheduledThreadPool.scheduled.shutdown();
	        boolean isDone;
	        // 等待线程池终止
	        do {
	            isDone = ScheduledThreadPool.scheduled.awaitTermination(1, TimeUnit.DAYS);
	            System.out.println("awaitTermination...");
	        } while(!isDone);

	        System.out.println("Finished all threads");
	}
}
class Task implements Runnable {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("name = " + name + ", startTime = " + new Date());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + name + ", endTime = " + new Date());
    }

}