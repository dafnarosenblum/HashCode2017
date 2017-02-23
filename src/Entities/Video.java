package Entities;

import java.util.List;

public class Video {

	private final int id;
	private final int sizeMB;
	private List<Long> timeSavedPerCacheServer;

	public Video(int id, int sizeMB) {
		this.id = id;
		this.sizeMB = sizeMB;
	}

	public int getId() {
		return id;
	}

	public int getSizeMB() {
		return sizeMB;
	}
	
	public List<Long> getTimeSavedPerCacheServer() {
	    return timeSavedPerCacheServer;
	}
	
	public void addTimeSavedPerCacheServer(Long timeSaved) {
	    timeSavedPerCacheServer.add(timeSaved);
	}

}
