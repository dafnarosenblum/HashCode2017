package Entities;

public class Requests {

	private final Video video;
	private final int numberOfRequests;

	public Requests(Video video, int numberOfRequests) {
		this.video = video;
		this.numberOfRequests = numberOfRequests;
	}

	public Video getVideo() {
		return video;
	}

	public int getNumberOfRequests() {
		return numberOfRequests;
	}

}
