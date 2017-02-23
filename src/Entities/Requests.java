package Entities;

public class Requests {

	private final int videoId;
	private final int numberOfRequests;

	public Requests(int videoId, int numberOfRequests) {
		this.videoId = videoId;
		this.numberOfRequests = numberOfRequests;
	}

	public int getVideoId() {
		return videoId;
	}

	public int getNumberOfRequests() {
		return numberOfRequests;
	}

}
