package net.kkppyy.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;

import com.alibaba.ttl.TransmittableThreadLocal;

public class ThreadPoolTest {
	@Test
	public void threadTest() throws InterruptedException, ExecutionException {
		TransmittableThreadLocal<String> parent = new TransmittableThreadLocal<String>();
		InheritableThreadLocal<String> loacl = new InheritableThreadLocal<String>();
		loacl.set("p");
		System.out.println("父线程的值loacl："+loacl.get());
		parent.set("value-set-in-parent");
		System.out.println("父线程的值："+parent.get());
		 Future<String> result=ThreadPool.mainfixedThreadPool.submit(new Callable<String>() {
			@Override
			public String call() {
				System.out.println("子线程名称为"+Thread.currentThread().getName());
				System.out.println("子线程的值parent："+parent.get());
				parent.set("value-set-in-child");
				System.out.println("子线程的值parent："+parent.get());
				TransmittableThreadLocal<String> child = new TransmittableThreadLocal<String>();
				System.out.println("子线程的值child："+child.get());
				child.set("value-set-in-child");
				System.out.println("子线程的值child："+child.get());
				
				System.out.println("子线程的值loacl："+loacl.get());
				loacl.set("p-c");
				System.out.println("子线程的值loacl："+loacl.get());
				return "";
			}
		});
		System.out.println("父线程的值："+parent.get());
		System.out.println("父线程的值loacl："+loacl.get());
		result.get();
		System.out.println("父线程的值："+parent.get());
		System.out.println("父线程的值loacl："+loacl.get());
	}
}
