import java.util.*;

class Person {
	private String name;
	private LinkedList<Chain> list;
	public Person(){
		name = null;
		list = new LinkedList<Chain>();
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setList(LinkedList<Chain> list){
		this.list = list;
	}
	public LinkedList<Chain> getList(){
		return this.list;
	}
	public void addChain(Chain c){
		list.add(c);
	}
	public Chain getLastChain(){
		if(list==null)
			return list.getLast();
		else 
			return null;
	}
	@Override
	public String toString(){
		return "name: "+name+" BlockChain: "+list.toString();
	}
}