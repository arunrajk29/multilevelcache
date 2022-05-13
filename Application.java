import phonepe.cache.controller.CacheService;
import phonepe.cache.model.Cache;
import phonepe.cache.processer.strategy.EvictionStrategy;
import phonepe.cache.processer.strategy.FIFOStrategy;

public class Application {

	public static void main(String[] args) throws Exception {
		
		CacheService cacheService = new CacheService();
		Cache cache = cacheService.createCache(2, 3);
		
		EvictionStrategy strategy = new FIFOStrategy();
		
		cacheService.write("arun", "1test", strategy);
		cacheService.write("goal", "232", strategy);
		cacheService.write("give", "3432", strategy);
		cacheService.write("53455", "aaa3432", strategy);
		
		cacheService.get("arun", strategy);
		
		cacheService.displayCache();
		cacheService.viewUsage();
	}
	
}
