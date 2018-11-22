package process_run;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import res.*;

public class CSV_Reader {
	
	LinkedList<Inventory> inv_list;
	ArrayList <String> orders ;
	public LinkedList<Inventory> getInv_list() {
		return inv_list;
	}
	public void CSV_Reader() {
		//this reader needs to read two files 
		inv_list = new LinkedList<Inventory>();
		orders = new ArrayList<String>();
		
	}
	public void start_reading() {
		//read inventory and put them into the LinkedList inv_list
		File csvFile = new File("Inventory.csv");
		//String
		BufferedReader br = null;

        try {
        	String fileName = csvFile.getCanonicalPath();
            
            String line = "";
            String cvsSplitBy = " ";           
            
         // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            br = 
                new BufferedReader(fileReader);
            int line_ctr=0;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] invents = line.split(cvsSplitBy);
                line_ctr ++;
                System.out.println(invents);

            }

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
		//read input.csv and put them into an ArrayList<String[]>
		
	}
	
}
