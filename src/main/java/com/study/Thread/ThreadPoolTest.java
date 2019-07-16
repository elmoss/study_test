package com.study.Thread;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xinfei.wang on 2019/7/16.
 */
public class ThreadPoolTest {

    volatile int finishState = 0;
    static String lock = "true";

    /**
     *
     * @throws InterruptedException
     * @throws ExecutionException
     * 首先使用corePoolSize 核心线程，
     * 当线程数大于corePoolSize ，小于maximumPoolSize，会使用LinkedBlockingDeque的空闲线程
     * 当空闲线程也被占满了，开始增加poolSize，直到maximumPoolSize数，
     * 当大于maximumPoolSize数，执行拒绝策略
     */


    @Test
    public void test4() throws InterruptedException, ExecutionException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 7, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10));
        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService(threadPoolExecutor);

        Runnable runnable = () -> {
            for (int i = 0; i < 50; i++) {
                String name = "name_" + i;
                TestCallable testCallable = new TestCallable(name);
                try {
                    executorCompletionService.submit(testCallable);

                    synchronized (lock) {
                        System.out.print("+++添加任务 name: " + name);
                        System.out.print(" ActiveCount: " + threadPoolExecutor.getActiveCount());
                        System.out.print(" poolSize: " + threadPoolExecutor.getPoolSize());
                        System.out.print(" queueSize: " + threadPoolExecutor.getQueue().size());
                        System.out.println(" taskCount: " + threadPoolExecutor.getTaskCount());
                    }
                } catch (RejectedExecutionException e) {
                    synchronized (lock) {
                        System.out.println("拒绝：" + name);
                    }
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            finishState = 1;
        };

        new Thread(runnable).start();

        // System.out.println(" taskCount: " + threadPoolExecutor.getTaskCount());

        // 添加的任务有被抛弃的。taskCount不一定等于添加的任务。
        int completeCount = 0;
        while (!(completeCount == threadPoolExecutor.getTaskCount() && finishState == 1)) {
            Future<String> take = executorCompletionService.take();
            String taskName = take.get();
            synchronized (lock) {
                System.out.print("---完成任务 name: " + taskName);
                System.out.print(" ActiveCount: " + threadPoolExecutor.getActiveCount());
                System.out.print(" poolSize: " + threadPoolExecutor.getPoolSize());
                System.out.print(" queueSize: " + threadPoolExecutor.getQueue().size());
                System.out.print(" taskCount: " + threadPoolExecutor.getTaskCount());
                System.out.println(" finishTask：" + (++completeCount));

            }
        }

        new Thread(runnable).join();


        while (threadPoolExecutor.getPoolSize() > 0) {
            Thread.sleep(1000);
            synchronized (lock) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                System.out.print(simpleDateFormat.format(new Date()));
                //System.out.print("name: " + taskName);
                System.out.print(" ActiveCount: " + threadPoolExecutor.getActiveCount());
                System.out.print(" poolSize: " + threadPoolExecutor.getPoolSize());
                System.out.print(" queueSize: " + threadPoolExecutor.getQueue().size());
                System.out.println(" taskCount: " + threadPoolExecutor.getTaskCount());
            }
        }

        // Tell threads to finish off.
        threadPoolExecutor.shutdown();
        // Wait for everything to finish.
        while (!threadPoolExecutor.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("complete");
        }

    }
}
