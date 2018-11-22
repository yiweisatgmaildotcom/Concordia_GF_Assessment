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
        if (result[0].contains(";")){
        	
        	result= a.split(";");
        }
    }
   
    
    public int volumn(int position)
    {
        String temp[] = result[position].split(" ");
        return Integer.parseInt(temp[3]);
    }
    public int order_num(int position) {
    	//String temp[] = result[0];
    	String order_str = result[position];
    	return Integer.parseInt(order_str);
    }
}
