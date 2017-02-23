package Entities;

import java.util.List;

public class Video {

	private final int id;
	private final int sizeMB;
	private List<Double> timeSavedPerCacheServer;
	private List<Long> requests; 

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
	
	public List<Double> getTimeSavedPerCacheServer() {
	    return timeSavedPerCacheServer;
	}
	
	public void addTimeSavedPerCacheServer(Double timeSaved) {
	    timeSavedPerCacheServer.add(timeSaved);
	}
	
	public List<Long> getRequests() {
	    return requests;
	}
	
	public Long totalRequestsSum() {
	    Long totalRequests = 0L;
	    for (Long l : requests) {
	        totalRequests += l;
	    }
	    return totalRequests;
	}

}
