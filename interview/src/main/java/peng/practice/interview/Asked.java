package peng.practice.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Asked {

	static List<String> findTopTenWords(String[] words) {
		List<String> result = new ArrayList<String>();
		if (words == null)
			return null;
		if (words.length <= 10) {
			for (String s : words)
				result.add(s);
			return result;
		}
		//use hash map
		final Map<String, Integer> allwords = new HashMap<String, Integer>();
		for (String s : words) {
			if (allwords.containsKey(s)) {
				int value = allwords.get(s);
				value++;
				allwords.put(s, value);
			} else {
				allwords.put(s, 1);
			}
		}
		
		//sort result
		result = new ArrayList<String>(allwords.keySet());
		Collections.sort(result, new Comparator<Object>() {

			public int compare(Object o1, Object o2) {
				if (allwords.get(o1) < allwords.get(o2))
					return 1;
				else if (allwords.get(o1) > allwords.get(o2))
					return -1;
				else
					return 0;
			}
		});
		return result.subList(0, 10);
	}
	
}
