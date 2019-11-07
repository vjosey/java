package com.skillstorm.examples;

import java.util.Arrays;
import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Maps {

	public static void main(String[] args) {
		// <Key, Value> pairs
		// treemap: natural ordering of the key
		Map<String, List<String>> dictionary = new LinkedHashMap<>();
		dictionary.put("trainee", Arrays.asList("One who is being trained", "Cool peeps"));
		dictionary.put("pickle", Arrays.asList("Pickled cucumber. See \"pickled\"", "Yum eats"));
		dictionary.put(null, Arrays.asList("emptiness"));
		String str = null;
		
		List<String> definition = dictionary.get("trainee");
		//System.out.println(definition);
		
		Set<String> keys = dictionary.keySet();
		System.out.println(keys);
		Collection<List<String>> values = dictionary.values(); // return all the values
		values.size();
		
	}
	
}
