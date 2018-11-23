package process_run;

public class ShoeShop_Manager {

	public static void main(String[] args) {		
		// TODO preprocess, 
		// Cleaning up the *.csv files, get rid of extra "" and useless info.
		
		// INPUT with csv reader
		CSV_Reader a_reader= new CSV_Reader();
		a_reader.start_reading();
		// PROCESS, dealing with order		
		Order_Processor ao_pr = new Order_Processor(a_reader);
		ao_pr.order_process();
		// OUTPUT the three files output.csv, NoFilledOrder.csv and inventory.csv with csv writer
		CSV_Writor a_wtr = new CSV_Writor(ao_pr,a_reader);
		a_wtr.write();
		
	}
}
