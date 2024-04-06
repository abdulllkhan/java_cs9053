package PartI;

import java.util.Scanner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.DoubleAdder;

public class LeibnizPi {

    private static final double PI = Math.PI;
    private static int DEFAULT_TERMS = 1_000_000_000;
    private Double result;

    public LeibnizPi(int numTerms, int numThreads) {

    }

    private static void calculatePi(int numTerms, int numThreads) {
        
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        DoubleAdder result = new DoubleAdder();
        Long startTime = System.currentTimeMillis();

        int startIndex = 0;
        int endIndex = numTerms / numThreads;
        int remainder = numTerms % numThreads;

        for (int i = 0; i < numThreads; i++) {
            if (i == numThreads - 1) {
                endIndex += remainder;
            }
            int runStartIndex = startIndex;
            int runEndIndex = endIndex;

            try{
                Runnable task = () -> {
                    double threadResult = 0.0;
                    for (int j = runStartIndex; j < runEndIndex; j++) {
                        double term = ((j % 2 == 0) ? 1.0 : -1.0) / (2 * j + 1);
                        threadResult += term;
                    }
                    result.add(threadResult);
                };
                executorService.execute(task);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            startIndex = endIndex;
            endIndex = startIndex + numTerms / numThreads;
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Double calculatedPi = result.doubleValue() * 4;
        double error = Math.abs(calculatedPi - PI);

        Long endTime = System.currentTimeMillis();

        System.out.println("Calculated Pi: " + calculatedPi);
        System.out.println("Actual Pi: " + PI);
        System.out.println("Absolute Error: " + error);
        System.out.println("Number of Threads: " + numThreads);
        System.out.println("Number of milliseconds taken to complete the thread: " + (endTime - startTime));

    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int numTerms = DEFAULT_TERMS;
        int numThreads = Runtime.getRuntime().availableProcessors();

        System.out.println("Do you want a custom number of iterations and threads? Type 'y' and enter for custom case and anything else to use default values.");
        String customInput = scanner.next();
        if(customInput.equals("y")) {

            try{
                System.out.println("Enter an desired number of iterations to calculate PI:");
                Integer customNumIterations = (Integer)scanner.nextInt();
                System.out.println("Enter an desired number of custom threads to calculate PI:");
                Integer customNumThreads = (Integer)scanner.nextInt();
                if(customNumIterations > 0) {
                    numTerms = customNumIterations;
                }
                
                System.out.println("The custom number of steps entered are: " + customNumIterations);
                if(customNumThreads > numThreads || customNumThreads <= 0) {
                    System.out.println("The custom number of threads entered are greater than the available processors. Using the default number of threads: " + numThreads);
                } else{
                    System.out.println("The custom number of threads entered are: " + customNumThreads);
                    System.out.println("\n\n");
                    calculatePi(numTerms, customNumThreads);
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
                System.exit(-1);
            }

        } else {
            System.out.println("Using default number of iterations and threads.");
        }

        System.out.println("\n\n");
        System.out.println("Total Number of Processors Available: " + numThreads);
        System.out.println("\n\n");

        int power = 0, base = 2;
        while(Math.pow(base, power) <= numThreads) {
            calculatePi(numTerms, (int)Math.pow(base, power));
            System.out.println("\n\n");
            power++;
        }

        // double error = Math.abs(calculatedPi - PI);

        // System.out.println("Calculated Pi: " + calculatedPi);
        // System.out.println("Actual Pi: " + PI);
        // System.out.println("Absolute Error: " + error);
        // System.out.println("Number of Threads: " + numThreads);
        // System.out.println("Number of Available Processors: " + Runtime.getRuntime().availableProcessors());
    }

    
}