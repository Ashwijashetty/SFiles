package new_pack;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {
public static void main(String[] args) {
	Map<Integer, String> map=new HashMap<>();
	map.put(123,"CG");
	map.put(122,"G");
	map.put(123,"CG");
	map.put(13,"CG");
	map.put(null,"CG");
	map.put(null,"C");
System.out.println(map);

Map<Integer, String> map1=new LinkedHashMap<>();
map1.put(123,"CG");
map1.put(122,"G");
map1.put(123,"CG");
map1.put(13,"CG");
map1.put(null,"CG");
map1.put(null,"C");
System.out.println(map1);

Map<Integer, String> map2=new TreeMap<>();
map2.put(123,"CG");
map2.put(122,"G");
map2.put(123,"C1G");
map2.put(13,"CG");
//map2.put(null,"CG");
map2.put(78,"C");
System.out.println(map2);

//to get only values
Collection<String> collection=map2.values();
for(String name:collection){
System.out.println(name);	
}

//to get key and corresponding value

/*Set<Integer> set=map2.keySet();   //map to set output
Iterator<Integer> iterator=set.iterator(); //only on set we can use Iterator
while(iterator.hasNext()){
	int id=iterator.next();
	String name=map2.get(id);   //"get" used to get values using key
	System.out.println(id+":"+name);  //to print both key and values
}
*/

}
}
