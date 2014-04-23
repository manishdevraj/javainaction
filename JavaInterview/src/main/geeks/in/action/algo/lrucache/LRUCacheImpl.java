package geeks.in.action.algo.lrucache;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Concrete implementation of LRU cache using Map and ConcurrentLinkedQueue Map
 * is used to store elements where as Queue determines LRU This uses Singleton
 * class that performs double checking on locked object so that if two threads
 * entered synchronized block simultaneously only single object would be created
 * 
 * @author manishdevraj
 * 
 * @param <K>
 * @param <V>
 */
public class LRUCacheImpl<K, V> implements LRUCache<K, V> {
	private static LRUCache CACHE_INSTANCE;
	private final int cacheMaxSize = 5;
	private final Map<K, V> map;
	private final Queue<K> queue;

	private LRUCacheImpl() {
		this.map = new HashMap<K, V>();
		this.queue = new ConcurrentLinkedQueue<K>();
	}

	@SuppressWarnings("rawtypes")
	public static LRUCache getInstance() {
		if (CACHE_INSTANCE == null) {
			synchronized (LRUCache.class) {
				// double checked locking - because second check of Singleton
				// instance with lock
				if (CACHE_INSTANCE == null) {
					CACHE_INSTANCE = new LRUCacheImpl();
				}
			}
		}
		return CACHE_INSTANCE;
	}

	@Override
	public V get(K key) {
		V result = null;
		if (map.containsKey(key)) {
			result = map.get(key);
		}
		markedLatest(key);
		return result;
	}

	@Override
	public void put(K key, V value) {
		if (map.size() == cacheMaxSize) {
			K oldKey = purgeLRU(key);
			map.remove(oldKey);
		}
		map.put(key, value);
		queue.add(key);
	}

	private K purgeLRU(K key) {
		return queue.poll();
	}

	private void markedLatest(K key) {
		queue.remove(key);
		queue.add(key);
	}

	@Override
	public Map<K, V> getCacheRepository() {
		return this.map;
	}

}
