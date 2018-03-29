package geeks.in.action;

import geeks.in.action.java.arr.ArrayDuplicate;
import geeks.in.action.algo.lrucache.LRUCache;
import geeks.in.action.algo.lrucache.LRUCacheImpl;

import org.junit.Test;

/**
 * Junit test cases for algorith testing
 * 
 * @author manishdevraj
 * 
 */
public class AlgorithmTest extends BaseTestCase {

	@Test
	public void findMissingNumberinArray() {
		final Integer[] array1 = { 1, 2, 3, 4, 5, 6, 7, 0, 9, 10 };
		ArrayDuplicate.MissingNumArray obj = new ArrayDuplicate.MissingNumArray();
		Number missingNumber = obj.findMissingNumber(array1);
		System.out.println("Array is missing " + missingNumber);
	}

	@Test
	public void lruCache() {
		LRUCache<Integer, Integer> cache = LRUCacheImpl.getInstance();
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.put(5, 5);
		printMap(cache.getCacheRepository());
		cache.get(1);
		cache.get(2);
		cache.put(6, 6);
		printMap(cache.getCacheRepository());
		cache.get(4);
		cache.put(7, 7);
		printMap(cache.getCacheRepository());

		// Though it is singleton we need to use different generic
		// interpretation to avoid type casting issue but it will essentially
		// use same cache instance

		LRUCache<String, String> stringCache = LRUCacheImpl.getInstance();

		stringCache.put("Manish", "Manish");
		printMap(stringCache.getCacheRepository());
	}
}
