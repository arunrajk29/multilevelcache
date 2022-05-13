package phonepe.cache.controller;

import phonepe.cache.data.CacheDBService;
import phonepe.cache.errorhandling.KeyNotFoundException;
import phonepe.cache.model.Cache;
import phonepe.cache.model.Level;
import phonepe.cache.processer.CacheUtil;
import phonepe.cache.processer.strategy.EvictionStrategy;
import phonepe.cache.viewer.CacheViewer;

public class CacheService {
	
	CacheDBService dbService;
	
	public CacheService() {
		dbService = new CacheDBService();
	}
	
	public Cache createCache(int allowedLevels, int levelSize) {
		Cache cache = new Cache(allowedLevels, levelSize);
		dbService.persistCache(cache);
		return cache;
	}
	
	public void get(String key, EvictionStrategy strategy) throws KeyNotFoundException {
		Level level = CacheUtil.getKeyLevel(dbService.getCache(), key);
		remove(key);
		write(key, level.getData().get(key), strategy);
		CacheViewer.printLevel(level);
	}
	
	public void write(String key, String value, EvictionStrategy strategy) {
		Level level = dbService.insertKey(key, value, 1, strategy);
		CacheViewer.printLevel(level);
	}
	
	public void remove(String key) throws KeyNotFoundException {
		dbService.removeKey(key);
	}

	public void displayCache() {
		CacheViewer.viewCache(dbService.getCache());
	}
	
	public void viewUsage() {
		CacheViewer.viewUsage(dbService.getCache());
	}
}
