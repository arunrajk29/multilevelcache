package phonepe.cache.processer.strategy;

import phonepe.cache.model.Level;

public class FIFOStrategy implements EvictionStrategy {

	@Override
	public String evict(Level level) {
		if(level == null || level.getData().isEmpty()) {
			return null;
		}
		return level.getData().entrySet().iterator().next().getKey();
	}

}
