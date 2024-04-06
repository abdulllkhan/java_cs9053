package PartII;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MonitorQueues implements Runnable {

	Queue<String> stringQueue;
	Map<Character, Integer> letterCount;
	
	private Consumer c1;
	private Consumer c2;
	private Producer p;
	private static final int DELAY = 10;
    // private final Object lock;

	
	public MonitorQueues() {
		stringQueue = new ConcurrentLinkedQueue<String>();
		letterCount = new ConcurrentHashMap<Character,Integer>();
		p = new Producer(stringQueue);
		//m1 = new StringMiddleMan(stringQueue, stringQueue);
		//m2 = new StringMiddleMan(generalPurposeQueue, stringQueue);
		c1 = new Consumer(stringQueue, letterCount);
		c2 = new Consumer(stringQueue, letterCount);
        // lock = new Object();
	}

	@Override
	public void run() {
		Thread producerThread = new Thread(p);
		producerThread.start();
		Thread consumerThread1 = new Thread(c1);
		consumerThread1.start();
		Thread consumerThread2 = new Thread(c2);
		consumerThread2.start();

        try {
            producerThread.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

		while (producerThread.isAlive()) {
			
			if (stringQueue.size() > Producer.MAX_QUEUE_SIZE) {
				System.out.println("Alert. Input Queue > " + Producer.MAX_QUEUE_SIZE + ". Shouldn't happen");
			}
			
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

        consumerThread1.interrupt();
        consumerThread2.interrupt();
        try {
            consumerThread1.join();
            consumerThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		System.out.println("complete");
		int sum=0;
		for (Character c : letterCount.keySet()) {
			System.out.println(c + ": "+ letterCount.get(c));
			sum += letterCount.get(c);
		}
		System.out.println("count is "+ sum);
		// if (stringQueue.size() == 0) {
		// 	System.out.println("stopping consumers");
		// 	consumerThread1.interrupt();
		// 	consumerThread2.interrupt();
		// }
		
		
	}
	
	public static void main(String[] args) {
		
		MonitorQueues mq = new MonitorQueues();
		Thread t = new Thread(mq);
		t.start();
	}
}
