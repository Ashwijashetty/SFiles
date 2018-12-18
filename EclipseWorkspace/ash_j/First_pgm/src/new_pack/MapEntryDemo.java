package new_pack;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapEntryDemo {
	public static void main(String[] args) {
	
		Map<Integer, String> map=new TreeMap<>();
		map.put(123,"CG");
		map.put(122,"G");
		map.put(123,"C1G");
		map.put(13,"CG");
		//map.put(null,"CG");
		map.put(78,"C");
		System.out.println(map);
		Set<Entry<Integer, String>> set=map.entrySet();
		Iterator<Entry<Integer, String>> iterator=set.iterator();
		
		while(iterator.hasNext()){
			Entry<Integer, String> entry=iterator.next();
			System.out.println(entry.getKey()+" : "+entry.getValue());
			
		}
		
	}
	
}
