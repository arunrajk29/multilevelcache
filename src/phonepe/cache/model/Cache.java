package phonepe.cache.model;

import java.util.ArrayList;
import java.util.List;

import phonepe.cache.data.CacheDBService;
import phonepe.cache.processer.strategy.EvictionStrategy;

public class Cache {

	private int allowedLevels;
	private int levelSize;
	private List<Level> levels;
	
	private Cache() {}

	public Cache(int allowedLevels, int levelSize) {
		setAllowedLevels(allowedLevels);
		setLevelSize(levelSize);
	}

	public int getAllowedLevels() {
		return allowedLevels;
	}
	public void setAllowedLevels(int allowedLevels) {
		this.allowedLevels = allowedLevels;
	}
	public int getLevelSize() {
		return levelSize;
	}
	public void setLevelSize(int levelSize) {
		this.levelSize = levelSize;
	}
	public List<Level> getLevels() {
		return levels;
	}
	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}
}
