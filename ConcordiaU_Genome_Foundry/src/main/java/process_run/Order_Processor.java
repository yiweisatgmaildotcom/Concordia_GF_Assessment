package process_run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Order_Processor {
	
	CSV_Reader a_reader;
	ArrayList<String> filledOrder;
	LinkedList<String>noFilledOrder;
	Map <String, ArrayList<String>> dict;
	Map <String, LinkedList<String>> no_dict;
	Map <String, ArrayList<String>> dict_tree ;
	ArrayList<Inventory> touchedInv;
	
	
	public Order_Processor(CSV_Reader a_reader) {
		this.a_reader = a_reader; 
		filledOrder = new ArrayList<String>();
		noFilledOrder = new LinkedList<String>();
		dict = new TreeMap<String, ArrayList<String>>();
		no_dict = new TreeMap<String, LinkedList<String>>();
		dict_tree = new TreeMap<String, ArrayList<String>>();
		touchedInv = new ArrayList<Inventory>();
		
	}
	/**
	 * This method will deal with the order one by one.
	 */
	public void order_process() {
		//sort the orders
		
		for (int order_ind=0; order_ind<a_reader.getOrders().size(); order_ind++) {
			Tokenizer a_toke= new Tokenizer(a_reader.getOrders().get(order_ind));
			ArrayList<String> order_value = new ArrayList<String>();
			for(int i=1;i<a_toke.result.length;i++) {
				order_value.add(a_toke.result[i]);
				//checking the order_value just added
				//System.out.println("The order_value is "+ order_value.get(order_value.size()-1));
			}			
			//dict.put(a_toke.result[0], order_value);
			dict_tree.put(a_toke.result[0], order_value);
			System.out.println("Added dict with <k, v>" + a_toke.result[0]+ " " + dict_tree.get(a_toke.result[0]));
		}
		//to check if the treeMap is ordered faster than HashMap? 
		
		
		for(String key: dict_tree.keySet()) {
			System.out.println("The key, value in dict_tree is " + key + " "+dict_tree.get(key));			
		}
		//order process by order numbers
		for(String key: dict_tree.keySet()) {
			
			System.out.println("Dealing with the order " + key + "... ");
			for (String item: dict_tree.get(key)){
				//if item is matched and volumn is not zero
				System.out.println("the sorted order item in dict_tree is: "+ item);
				boolean filled = false;
//////////////////////////////////////////////////////SEARCH AND MATCHING
				for(int j=0; j<a_reader.getInv_list().size(); j++) {
					String an_item = a_reader.getInv_list().get(j).getItem();
					String a_vol = a_reader.getInv_list().get(j).getVolumn();
					//System.out.println("The item, volumn is :" + an_item+" "+ a_vol);
					if(item.equalsIgnoreCase(an_item)) {
						if(Integer.parseInt(a_vol)>0) {
							filled= true;
							a_reader.getInv_list().get(j).setVolumnMinusOne(a_vol);	
							System.out.println("one item in order FILLED");
							touchedInv.add(a_reader.getInv_list().get(j));
							break;
							
						}	
						System.out.println("dealed with inventory and volumn");
					}
					else {
						continue;
					}								
				}//searching the inventory list end
				if (filled){
					filledOrder.add(item);				
					filled= false;
				}		
				else {
					noFilledOrder.add(item);
					System.out.println("dealing with no Filled orders");
				}
////////////////////////////////////////////END OF SEARCH AND MATCHING /////////////
				
			}
			dict.put(key, filledOrder);
			no_dict.put(key, noFilledOrder);
			filledOrder = new ArrayList<String>();
			noFilledOrder = new LinkedList<String>();
		}//for loop for keys in dict_tree 
		//traverse the dict
		
		for(String key: dict.keySet()) {
					System.out.println("The key, value in dict is " + key + " "+dict.get(key));			
		}
		for(String key: no_dict.keySet()) {
			System.out.println("The key, value in no_dict is " + key + " "+no_dict.get(key));			
}
	}
/////////////////////////////////////////////////////////////////////////////////////////
// setters or getters
/////////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<String> getFilledOrder() {
		return filledOrder;
	}
	public void setFilledOrder(ArrayList<String> filledOrder) {
		this.filledOrder = filledOrder;
	}
	public LinkedList<String> getNoFilledOrder() {
		return noFilledOrder;
	}
	public void setNoFilledOrder(LinkedList<String> noFilledOrder) {
		this.noFilledOrder = noFilledOrder;
	}
	public Map<String, ArrayList<String>> getDict() {
		return dict;
	}
	public void setDict(Map<String, ArrayList<String>> dict) {
		this.dict = dict;
	}
	public Map<String, LinkedList<String>> getNo_dict() {
		return no_dict;
	}
	public void setNo_dict(Map<String, LinkedList<String>> no_dict) {
		this.no_dict = no_dict;
	}
	public Map<String, ArrayList<String>> getDict_tree() {
		return dict_tree;
	}
	public void setDict_tree(Map<String, ArrayList<String>> dict_tree) {
		this.dict_tree = dict_tree;
	}
	public CSV_Reader getA_reader() {
		return a_reader;
	}
	public ArrayList<Inventory> getTouchedInv() {
		return touchedInv;
	}
}
