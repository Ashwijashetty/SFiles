package new_pack;

import java.util.Hashtable;

public class HashTableDemo {

	public static void main(String[] args) {
		Hashtable<String,String> hashtable=new Hashtable<>();
		hashtable.put("hello", "javaa");
		//hashtable.put("hello", null);
		hashtable.put("good", "place");
		hashtable.put("good", "date");
	System.out.println(hashtable);
	}

}
