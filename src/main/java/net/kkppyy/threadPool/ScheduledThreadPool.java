package net.kkppyy.threadPool;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class ScheduledThreadPool {
	static final int nThreads = Runtime.getRuntime().availableProcessors();
	public static ScheduledThreadPoolExecutor  scheduled ;
	public static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
	        .setNameFormat("全局任务调度-pool-%d").build();
	static{
		scheduled = new ScheduledThreadPoolExecutor(nThreads * 2,namedThreadFactory);
	}
}
