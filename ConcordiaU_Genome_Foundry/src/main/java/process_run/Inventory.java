package process_run;

public class Inventory {
	String shelf;
	String Bin;
	String Item;
	int Volumn;
	public String getShelf() {
		return shelf;
	}
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}
	public String getBin() {
		return Bin;
	}
	public void setBin(String bin) {
		Bin = bin;
	}
	public String getItem() {
		return Item;
	}
	public void setItem(String item) {
		Item = item;
	}
	public int getVolumn() {
		return Volumn;
	}
	public void setVolumn(int volumn) {
		Volumn = volumn;
	}
	/**
	 * This constructor will use the reading lines of inventory.csv to create objects line by line.
	 *  
	 * @param shelf
	 * @param bin
	 * @param item
	 * @param volumn
	 */
	public Inventory(String shelf, String bin, String item, int volumn) {
		super();
		this.shelf = shelf;
		this.Bin = bin;
		this.Item = item;
		this.Volumn = volumn;
	}
	public Inventory() {
		
	}
}
