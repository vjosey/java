package com.skillstorm.threads;

class Processor extends Thread {
    
	// when multiple threads may update this value.. use volatile
	// prevents a variable from cached in a single Thread (ThreadLocal)
    private volatile boolean run = true;
    
    public void run() {
        while(run) {
            System.out.println("Running");
            
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {}
        }
    }
    
    public void shutdown() {
        run = false;
    }
}

public class CacheIssue {

    public static void main(String[] args) throws InterruptedException {
        Processor pro = new Processor();
        pro.start();
        
        Thread.sleep(1000);
        
        pro.shutdown();
    }

}

 