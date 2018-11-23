package process_run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CSV_Reader {
	
	LinkedList<Inventory> inv_list;
	ArrayList <String> orders ;
	public ArrayList<String> getOrders() {
		return orders;
	}
	ArrayList<File> files;
	/**
	 * This method will return the inventory list.
	 * @return
	 */
	public LinkedList<Inventory> getInv_list() {
		return inv_list;
	}
	/**
	 * This is the constructor.
	 */
	public CSV_Reader() {
		//this reader needs to read two files 
		inv_list = new LinkedList<Inventory>();
		orders = new ArrayList<String>();
		files = new ArrayList<File>();
	}
	public void start_reading() {
		//read inventory and put them into the LinkedList inv_list
		File csvFile = new File("/home/yiwei/git/repository/ConcordiaU_Genome_Foundry/src/main/java/process_run/Inventory.csv");
		if (files.add(csvFile)) {
			File inputFile = new File("/home/yiwei/git/repository/ConcordiaU_Genome_Foundry/src/main/java/process_run/Input.csv");
			files.add(inputFile);
		}
		else {
			throw new NullPointerException();
		}
		
		for (int file_ctr=0; file_ctr<files.size();file_ctr++) {
			BufferedReader br = null;
	
	        try {
	        	String fileName = files.get(file_ctr).getCanonicalPath();
	            
	            String line = "";
	            String cvsSplitBy = ",";          
	            
	         // FileReader reads text files in the default encoding.
	            FileReader fileReader = 
	                new FileReader(fileName);
	            // Always wrap FileReader in BufferedReader.
	            br = new BufferedReader(fileReader);
	            int line_ctr=0;
	           // while ((line = br.readLine()) != null ) {
	            while ((line = br.readLine()) != null ) {
	            	// use comma as separator
	            	if (file_ctr==0) {
	            		String[] invents = line.split(cvsSplitBy);
	                   // System.out.println("the volumn in line  "+line_ctr+" is "+invents[3]);
	                    if (line_ctr>=1) {
		                    Inventory an_inv = new Inventory(invents);
		                    inv_list.add(an_inv);
	                    }
	                    line_ctr++;
	            		
	            	}
	            	else {           			
	                               
	                    if (line_ctr>=4 ) {
	            			orders.add(line);
	            			 System.out.println("the order in line  "+line_ctr+" is "+line);
	            		}
	                    line_ctr++;
	                    //TODO only for testing
	                   /* if (line_ctr==10) {
	                    	break;
	                    }*/
	            	}
	              	
	            }
	            System.out.println("The file "+fileName+" total line number is: "+ line_ctr);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	}   
		files.clear();
		
		
	}
	
}
