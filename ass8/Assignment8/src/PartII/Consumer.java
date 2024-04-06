package PartII;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Consumer implements Runnable {

	public static final int DELAY = 2;
	
	Queue<String> in;
	Map<Character, Integer> out;
	
	public Consumer(Queue<String> in, Map<Character,Integer> out) {
		this.in = in;
		this.out = out;
	}
	
	@Override
	public void run() {
        try{
	    	while (true) {
            
	    		// remove element from the queue
	    		// get the first character of the String you
	    		// got from the queue, and update the count in the map
            
                // if the queue is empty, catch the exception
                // and break the loop
                // if the thread is interrupted, catch the exception
                // and break the loop
            
                String wordElement = null;
                synchronized (in) {
                    while(in.isEmpty()){
                        // try {
                            in.wait();
                        // } catch (InterruptedException e) {
                        //     System.out.println("Ending consumer");
                        //     break;
                        // }
                    }
                    wordElement = in.poll();
                    in.notifyAll();
                }
            
                if(wordElement != null){
                    char firstChar = wordElement.charAt(0); 
                    synchronized(out){
                        out.merge(firstChar, 1, Integer::sum);
                        // if(out.containsKey(firstChar)){
                        //     out.put(firstChar, out.get(firstChar)+1);
                        // } else {
                        //     out.put(firstChar, 1);
                        // }
                    }
                }
                
            
            
	    		// try {
	    		// 	String obj = in.remove();
	    		// 	char c = obj.charAt(0);
	    		// 	if (out.containsKey(c)) {
	    		// 		out.put(c, out.get(c)+1);
	    		// 	} else {
	    		// 		out.put(c, 1);
	    		// 	}
	    		// } catch (NoSuchElementException e) {
	    		// 	System.out.println(e.getMessage());
	    		// 	break;
	    		// }
                
	    		// try {
	    			Thread.sleep((long) (Math.random()*DELAY));
	    		// } catch (InterruptedException e) {
	    		// 	// TODO Auto-generated catch block
	    		// 	e.printStackTrace();
	    		// 	System.out.println("why ending consumer");
	    		// 	break;
	    		// }
	    	}
        } catch (InterruptedException e) {
            System.out.println("Ending consumer");
        }
		
	}

}
