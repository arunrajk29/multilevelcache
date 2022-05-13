package phonepe.cache.data;

import phonepe.cache.errorhandling.KeyNotFoundException;
import phonepe.cache.model.Cache;
import phonepe.cache.model.Level;
import phonepe.cache.processer.CacheUtil;
import phonepe.cache.processer.strategy.EvictionStrategy;

public class CacheDBService {
	
	private Cache cache;
	
	public void persistCache(Cache cache) {
		this.cache = cache;
	}
	
	public Cache getCache() {
		return cache;
	}
	
	public Level insertKey(String key, String value, int level, EvictionStrategy strategy) {
		return CacheUtil.insertKey(cache, key, value, level, strategy);
	}
	
	public void removeKey(String key) throws KeyNotFoundException {
		CacheUtil.removeKey(cache, key);
	}

}
