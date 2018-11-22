
package process_run;

import java.io.File;
import java.util.ArrayList;

public class CSV_Writor {
    ArrayList<File> w_files;
    File outFile;
    File invFile;
    File noFilledOrder;
    Order_Processor pr;
	public CSV_Writor(Order_Processor pr) {
		outFile = new File("/home/yiwei/git/repository/ConcordiaU_Genome_Foundry/src/main/java/res/Output.csv");
		noFilledOrder = new File("/home/yiwei/git/repository/ConcordiaU_Genome_Foundry/src/main/java/res/NoFilledOrder.csv");
		invFile = new File("/home/yiwei/git/repository/ConcordiaU_Genome_Foundry/src/main/java/process_run/Inventory.csv");
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
		String header ="Order Item Shelf Bin Shipping Box Volume";
		
		//write the body
		
		
	}

}
