package com.primaseller.leanstartupbar.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Queue {
	private static Queue _instnce = null;
	private final BlockingQueue<Runnable> workerQueue;
	
	 private Queue(){
		 workerQueue = new LinkedBlockingQueue<Runnable>();
		 Thread t = new Worker();
         t.start();
	 }

		public static Queue getInstnce() {
			if( _instnce == null) 
				_instnce = new Queue();
			return _instnce;
		}
	 
	 

	    public void addTask(Runnable r){
	        try {
	            workerQueue.put(r);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    
	    public class Worker  extends Thread {

	    	public void run() {
	    		while (true) {
	    			try {
	    				
	    				Runnable r = workerQueue.take();
	    				r.run();
	    			} catch (InterruptedException e) {
	    				e.printStackTrace();
	    			} catch (RuntimeException e) {
	    				e.printStackTrace();
	    			}
	    		}
	    	}
	    }
}
