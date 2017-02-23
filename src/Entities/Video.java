package Entities;

public class Video {

	private final int id;
	private final int sizeMB;

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

}
