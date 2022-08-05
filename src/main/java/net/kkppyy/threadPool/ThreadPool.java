package net.kkppyy.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletionService;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class ThreadPool {
	static final int nThreads = Runtime.getRuntime().availableProcessors();
	public static ThreadPoolExecutor mainfixedThreadPool;
	public static ThreadPoolExecutor geofixedThreadPool;
	public static ThreadPoolExecutor parfixedThreadPool;
	public static ThreadPoolExecutor insertfixedThreadPool;
	public static ThreadPoolExecutor materfixedThreadPool;
	public static ThreadPoolExecutor ossfixedThreadPool;
	public static Executor singlefixedThreadPool;
	public static CompletionService<String> completionService;
	public static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
	        .setNameFormat("全局-pool-%d").build();
	public static ThreadFactory geonamedThreadFactory = new ThreadFactoryBuilder()
			.setNameFormat("全局几何-pool-%d").build();
	public static ThreadFactory insertnamedThreadFactory = new ThreadFactoryBuilder()
			.setNameFormat("插入线程池-pool-%d").build();
	public static ThreadFactory maternamedThreadFactory = new ThreadFactoryBuilder()
			.setNameFormat("材质-pool-%d").build();
	public static ThreadFactory parThreadFactory = new ThreadFactoryBuilder()
			.setNameFormat("属性-pool-%d").build();
	public static ThreadFactory singleThreadFactory = new ThreadFactoryBuilder()
			.setNameFormat("解析和出库-pool-%d").build();
	public static ThreadFactory ossThreadFactory = new ThreadFactoryBuilder()
			.setNameFormat("oss-pool-%d").build();
	static {
		System.out.println("开始初始化线程池，线程池大小："+(nThreads * 2));
		mainfixedThreadPool = new ThreadPoolExecutor(nThreads * 2, nThreads * 2, 30L, TimeUnit.MINUTES,
				new ArrayBlockingQueue<>(1024), namedThreadFactory,new ThreadPoolExecutor.CallerRunsPolicy());
		geofixedThreadPool = new ThreadPoolExecutor(nThreads * 2, nThreads * 2, 30L, TimeUnit.MINUTES,
				new ArrayBlockingQueue<>(102400), geonamedThreadFactory,new ThreadPoolExecutor.CallerRunsPolicy());
		insertfixedThreadPool = new ThreadPoolExecutor(nThreads * 2, nThreads * 2, 30L, TimeUnit.MINUTES,
				new ArrayBlockingQueue<>(1024), insertnamedThreadFactory,new ThreadPoolExecutor.CallerRunsPolicy());
		materfixedThreadPool = new ThreadPoolExecutor(nThreads * 2, nThreads * 2, 30L, TimeUnit.MINUTES,
				new ArrayBlockingQueue<>(1024), maternamedThreadFactory,new ThreadPoolExecutor.CallerRunsPolicy());
		parfixedThreadPool = new ThreadPoolExecutor(nThreads * 2, nThreads * 2, 30L, TimeUnit.MINUTES,
				new ArrayBlockingQueue<>(1024), parThreadFactory,new ThreadPoolExecutor.CallerRunsPolicy());
		ossfixedThreadPool = new ThreadPoolExecutor(nThreads * 2, nThreads * 2, 30L, TimeUnit.MINUTES,
				new ArrayBlockingQueue<>(1024), ossThreadFactory,new ThreadPoolExecutor.CallerRunsPolicy());
		singlefixedThreadPool = Executors.newSingleThreadExecutor(singleThreadFactory);
	}
}
