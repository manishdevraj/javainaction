package geeks.in.action.algo.lrucache;

import java.util.Map;

/**
 * Base implementation
 * 
 * @author manishdevraj
 * 
 * @param <K>
 * @param <V>
 */
public interface LRUCache<K, V> {
	public V get(K key);

	public void put(K key, V value);

	public Map<K, V> getCacheRepository();

}
