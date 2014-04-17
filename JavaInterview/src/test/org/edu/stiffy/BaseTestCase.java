package org.edu.stiffy;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Base test case that can contain importan and common functionality to be
 * reused across test case methods
 * 
 * @author manishdevraj
 * 
 */
public class BaseTestCase {
	protected <K, V> void printMap(Map<K, V> map) {
		Iterator<Entry<K, V>> it = map.entrySet().iterator();
		System.out.println("---------------------");
		while (it.hasNext()) {
			Entry<K, V> pairs = it.next();
			System.out.println(pairs.getKey() + " = " + pairs.getValue());
		}
	}
}
