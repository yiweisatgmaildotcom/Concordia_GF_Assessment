package process_run;

public class Order_Processor {
	
	
	CSV_Reader a_reader;
	public Order_Processor(CSV_Reader a_reader) {
		this.a_reader = a_reader; 
	}
	/**
	 * This method will deal with the order one by one.
	 */
	public void order_process() {
		for (int order_ind=0; order_ind<a_reader.getOrders().size(); order_ind++) {
			Tokenizer a_toke= new Tokenizer(a_reader.getOrders().get(order_ind));
			
			
			
		}
	}
	
}
