import java.io.*;
class Item implements Serializable {
	private int index;
	private String name;
	private int price;
	public Item(){
		
	}
	public Item(int index,String name,int price){
		this.index = index;
		this.name = name;
		this.price = price;
	}
	public String getName(){
		return name;
	}
	public int getPrice(){
		return price;
	}
	public int getIndex(){
		return index;
	}
	public void setIndex(int index){
		this.index = index;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setPrice(int price){
		this.price = price;
	}
	@Override
	public String toString(){
		return index+" "+name+" "+price;
	}
}