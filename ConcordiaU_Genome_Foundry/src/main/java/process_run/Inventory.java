package process_run;

public class Inventory {
	String shelf;
	String bin;
	String item;
	int volumn;
	public String getShelf() {
		return shelf;
	}
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}
	public String getBin() {
		return bin;
	}
	public void setBin(String bin) {
		bin = bin;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		item = item;
	}
	public int getVolumn() {
		return volumn;
	}
	public void setVolumn(int volumn) {
		volumn = volumn;
	}
	
	/**
	 * This constructor will use the reading lines of inventory.csv to create objects line by line.
	 * Since the read/write in are all strings, we need 
	 * Convert using Integer.toString(int)
	 * Convert using String.valueOf(int) 
	 * @param shelf
	 * @param bin
	 * @param item
	 * @param volumn
	 */
	public Inventory(String shelf, String bin, String item, int volumn) {
		super();
		this.shelf = shelf;
		this.bin = bin;
		this.item = item;
		this.volumn = volumn;
	}
	public Inventory() {
		
	}
}
