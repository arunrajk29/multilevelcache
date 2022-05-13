package phonepe.cache.processer.strategy;

import phonepe.cache.model.Level;

public interface EvictionStrategy {
	public String evict(Level level);
}
