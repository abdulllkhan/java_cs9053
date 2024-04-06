import java.io.*;
import java.util.Scanner;

import java.util.ArrayList;
 
public class ListOfNumbers {
	
    // @SuppressWarnings("rawtypes")
    private ArrayList<RDFTriple<Integer, Integer, Integer>> rdfTripleList;
    private String fileName;
 
    public ListOfNumbers () {
        // create an ArrayList of Pairs of Integers
        this.rdfTripleList = new ArrayList<RDFTriple<Integer, Integer, Integer>>();
    }
    
    public ArrayList<RDFTriple<Integer, Integer, Integer>> getRdfTripleList() {
    	return this.rdfTripleList;
    }
    
    public void createList() {
    	for (int i = 0 ; i < 100 ; i++) {
    		Integer number1 = (int) (Math.random()*10000);
    		Integer number2 = (int) (Math.random()*10000);
    		Integer number3 = (int) (Math.random()*10000);
    		// fill the existing list with RDFTriple objects
    		// of three numbers.
            RDFTriple<Integer, Integer, Integer> rdfTriple = new RDFTriple<Integer, Integer, Integer>(number1, number2, number3);
            rdfTripleList.add(rdfTriple);
    	}
    }
    

    public ListOfNumbers (String fileName) {
    	this();
    	this.fileName = fileName;	
    }
    
    public void readList() throws FileNotFoundException {
    	File file = new File(fileName);
      	Scanner fileReader = new Scanner(file);
        while (fileReader.hasNextLine()) {
        	String line = fileReader.nextLine();
			String[] rdfTripleInfoInString = line.split(" ");
            Integer[] rdfTripleInfo = new Integer[3];
            for(int i = 0; i < 3; i++) {
            	rdfTripleInfo[i] = Integer.valueOf(rdfTripleInfoInString[i]);
            }
            RDFTriple<Integer, Integer, Integer> rdfTriple = new RDFTriple<Integer, Integer, Integer>(rdfTripleInfo[0], rdfTripleInfo[1], rdfTripleInfo[2]);
            rdfTripleList.add(rdfTriple);
      	}
		fileReader.close();
    }
    
    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            // out = new PrintWriter(new FileWriter(this.fileName));
            // File myObj = new File("/outFile.txt");
            String outFile = "outFile.txt";
            File myObj = new File(outFile);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            out = new PrintWriter(new FileWriter("outFile.txt"));
            for (int i = 0; i < rdfTripleList.size(); i++)
                out.println(rdfTripleList.get(i).getSubj() + " " + rdfTripleList.get(i).getPred()+ " " + rdfTripleList.get(i).getObj());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    public static void cat(String fileName) throws FileNotFoundException, IOException{
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try{
            ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
    	    ListOfNumbers.cat("numberfile.txt");
            listOfNumbers.createList();
            listOfNumbers.writeList();
    	    listOfNumbers.readList();
        } catch (FileNotFoundException e) {
            System.err.println("Caught FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
    	
    }

}
