
package process_run;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import com.opencsv.CSVReader;
import java.io.IOException;
import com.opencsv.CSVWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSV_Writor {
    ArrayList<File> w_files;
    File outFile;
    File invFile;
    File noFilledOrder;
    Order_Processor pr;
    Inventory inv_add;
	public CSV_Writor(Order_Processor pr) {
		outFile = new File("/home/yiwei/git/repository/ConcordiaU_Genome_Foundry/src/main/java/res/Output.csv");
		noFilledOrder = new File("/home/yiwei/git/repository/ConcordiaU_Genome_Foundry/src/main/java/res/NoFilledOrder.csv");
		invFile = new File("/home/yiwei/git/repository/ConcordiaU_Genome_Foundry/src/main/java/res/Inventory.csv");
		w_files = new ArrayList<File> ();
		w_files.add(outFile);
		w_files.add(noFilledOrder);
		w_files.add(invFile);
		this.pr= pr;
		
	}
	public void write() {
		// TODO Auto-generated method stub
		//Use a loop to traverse the Files 
		// open outFile
		// write the header
		//final String STRING_ARRAY_SAMPLE = "./string-array-sample.csv";
		String a_path="";
		//for (File a_file: w_files) {
			try {
				a_path= outFile.getCanonicalPath();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}
		//write the body
		
		try (
	            Writer writer = Files.newBufferedWriter(Paths.get(a_path) );
				
	            CSVWriter csvWriter = new CSVWriter(writer,
	                    CSVWriter.DEFAULT_SEPARATOR,
	                    CSVWriter.NO_QUOTE_CHARACTER,
	                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
	                    CSVWriter.DEFAULT_LINE_END);
	        ) {
			String[] header = {"Order","Item","Shelf","Bin","Shipping Box","Volume"};
	            csvWriter.writeNext(header);
	            //combine filled order with inventory objects
	            for (String key: pr.getDict().keySet()) {
	            	System.out.println("The key, value in dict is " + key + " "+pr.getDict().get(key));	
	            	int order_ctr=0;
	            	for(String val: pr.getDict().get(key) ) {
	            		String[] item = null;
	            		boolean order_head=false;
	            		if(order_ctr==0) {
	            			 order_head=true;	            			 
	            		}        		
	            		
	            		boolean item_check=false;
	            		
	           			for(Inventory inv: pr.getTouchedInv()) {
	           				 if (inv.getItem().equalsIgnoreCase(val)) {
	           					 item_check=true;
	           					 inv_add= inv;
	           					 break;
	           				 }
	           				 else
	           					 continue;
	           			 }	
           			   if (item_check){
           				   if(order_head) {
           					item= new String[]{key, val, inv_add.getShelf(), inv_add.getBin(),key, Integer.toString(1)};
           				   }
           				   else {
           					item= new String[]{"", val, inv_add.getShelf(), inv_add.getBin(),key, Integer.toString(1)}; 
           				   }
           			   }
	            		csvWriter.writeNext(item);
	            		order_ctr++; 
	            	}
	            	
	            	
	            }
	            
	           /* csvWriter.writeNext(new String[]{"Sundar Pichai ♥", "sundar.pichai@gmail.com", "+1-1111111111", "India"});
	            csvWriter.writeNext(new String[]{"Satya Nadella", "satya.nadella@outlook.com", "+1-1111111112", "India"});*/
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            
	        }
		
	}

}
