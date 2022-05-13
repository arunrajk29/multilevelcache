package phonepe.cache.processer;

import phonepe.cache.errorhandling.KeyNotFoundException;
import phonepe.cache.model.Cache;
import phonepe.cache.model.Level;
import phonepe.cache.processer.strategy.EvictionStrategy;

public class CacheUtil {

	public static synchronized Level insertKey(Cache cache, String key, String value, int levelNo, EvictionStrategy strategy) {
		
		if(levelNo <= cache.getAllowedLevels()) {
			if( cache.getLevels() == null || cache.getLevels().size() < levelNo) {
				cache.getLevels().add(new Level());
			}
			
			Level level = cache.getLevels().get(levelNo-1);
			if(level.getData().size() < cache.getLevelSize()) {
				level.getData().put(key, value);
				return level;
			} else if(level.getData().size() == cache.getLevelSize()) {
				level.getData().put(key, value);
				String keyToEvict = strategy.evict(level);
				String valueToEvict = level.getData().get(keyToEvict);
				insertKey(cache, keyToEvict, valueToEvict, levelNo+1, strategy);
				level.getData().remove(keyToEvict);
			}
			return level;
		}
		return null;
	}
	
	public static Level getKeyLevel(Cache cache, String key) throws KeyNotFoundException {
	
		for(Level level : cache.getLevels()) {
			if(level.getData().containsKey(key)) {
				return level;
			}
		}
		throw new KeyNotFoundException();
	}
	
	public static void removeKey(Cache cache, String key) throws KeyNotFoundException {
		
		for(Level level : cache.getLevels()) {
			if(level.getData().containsKey(key)) {
				level.getData().remove(key);
				return;
			}
		}
		throw new KeyNotFoundException();
	}
}
