package phonepe.cache.viewer;

import java.util.Map;

import phonepe.cache.model.Cache;
import phonepe.cache.model.Level;

public class CacheViewer {

	public static void viewCache(Cache cache) {
		int idx = 1;
		for(Level level : cache.getLevels()) {
			System.out.println("Level :" + idx++);
			
			printLevel(level);
		}
	}
	
	public static void printLevel(Level level) {
		for(Map.Entry<String, String> entry : level.getData().entrySet() ) {
			System.out.println( entry.getKey() + "  :  " + entry.getValue());
		}
	}
	
	public static void viewUsage(Cache cache) {
		int idx = 1;
		for(Level level : cache.getLevels()) {
			System.out.println("Level :" + idx++ + " ==> " + level.getData().size());
		}
	}
}
