package process_run;

/**
 * this class will split string into an array of string
 * @author yiweisun
 *
 */
public class Tokenizer {
    public String[] result;
    public Tokenizer(String a)
    {
        result = a.split(" ");
        if (result[0].contains(",")){
        	
        	result= a.split(",");
        }
    }
   
    /**
     * This method will return the integer of volumn according to the token position.
     * @param position
     * @return
     */
    public int volumn(int position)
    {
        String temp[] = result[position].split(",");
        return Integer.parseInt(temp[3]);
    }
    /**
     * This method will get order number according to the result positon, it is normally 0
     * in the order lines.
     * @param position
     * @return
     */
    public int order_num(int position) {
    	//String temp[] = result[0];
    	String order_str = result[position];
    	return Integer.parseInt(order_str);
    }
    
}
