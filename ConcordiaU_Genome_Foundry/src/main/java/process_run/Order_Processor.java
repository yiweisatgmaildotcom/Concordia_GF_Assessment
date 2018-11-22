package process_run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Order_Processor {
	
	
	CSV_Reader a_reader;
	public Order_Processor(CSV_Reader a_reader) {
		this.a_reader = a_reader; 
	}
	/**
	 * This method will deal with the order one by one.
	 */
	public void order_process() {
		//sort the orders
		Map <String, ArrayList<String>> dict = new HashMap<String, ArrayList<String>>();
		Map <String, ArrayList<String>> dict_tree;
		for (int order_ind=0; order_ind<a_reader.getOrders().size(); order_ind++) {
			Tokenizer a_toke= new Tokenizer(a_reader.getOrders().get(order_ind));
			ArrayList<String> order_value = new ArrayList<String>();
			for(int i=1;i<a_toke.result.length;i++) {
				order_value.add(a_toke.result[i]);
			}
			
			dict.put(a_toke.result[0], order_value);
			
			
		}
		//to check if the treeMap is ordered faster than HashMap? 
		dict_tree = new TreeMap<String, ArrayList<String>>(dict);
	}
	
}
