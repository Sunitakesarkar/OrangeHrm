package testUtility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Practice_Collection {
	public static void main (String[] args) {
		 System.out.println("--------------ArrayList----------------");
		//Array
		ArrayList al = new ArrayList();
		al.add(111);
		al.add("Test");
		al.add("true");
		al.add(111);
		al.add(null);
		al.add(null);
		
		System.out.println(al);
		System.out.println(al.get(1));
	
   //add(); to add the data in collection object
   //remove(); to delete specific data from collection
   //get();  to get/retrieve the data from collection
    System.out.println("--------------LinkedList----------------");
	
    //LinkedList
    LinkedList ll = new LinkedList();
	ll.add(111);
	ll.add("Test");
	ll.add("true");
	ll.add(111);
	ll.add(null);
	ll.add(null);
	
	System.out.println(ll);
    
	System.out.println("--------------HashSet----------------");
    //Set
	HashSet hs = new HashSet();
	hs.add(111);
	hs.add("Test");
	hs.add("true");
	hs.add("a");
	hs.add(111);
	hs.add(null);
	hs.add(null);
	hs.add(null);
	
	
	System.out.println(hs);
	
	System.out.println("------------------------------");
	
	HashSet hs2 = new HashSet();
	hs2.addAll(al);             //adding one collection into another
	
	System.out.println(hs2);
	
	System.out.println("--------------LinkedHashSet----------------");
	//LinkedHashSet
	LinkedHashSet Linkedhs = new LinkedHashSet();
	Linkedhs.add(111);
	Linkedhs.add("Test");
	Linkedhs.add("true");
	Linkedhs.add("a");
	Linkedhs.add(111);
	Linkedhs.add(null);
	Linkedhs.add(null);
	Linkedhs.add(null);
	
	HashSet hs3 = new HashSet();
	hs3.add("aa");
	hs3.add("bb");
	hs3.add("cc");
	hs3.add("abc");
	System.out.println(Linkedhs);
	System.out.println(hs3);
	System.out.println("-------------TreeSet-----------------");
	
	TreeSet ts = new TreeSet();
	ts.add("11");
	ts.add("22");
	ts.add("33");
	ts.add("10");
	ts.add("11");
	System.out.println(ts);
	
	ArrayList al2 = new ArrayList();
	al2.addAll(ts);
	System.out.println(al2.get(2));
	
	}

	
	
}
