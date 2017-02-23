package Entities;

import java.util.List;

public class CacheServer {

	private final int id;
	private final long sizeMB;
	private List<Video> savedVideos;

	public CacheServer(int id, long sizeMB) {
		this.id = id;
		this.sizeMB = sizeMB;
	}

	public long getSizeMB() {
		return sizeMB;
	}

	public void addVideo(Video video) {
		savedVideos.add(video);
	}

	public List<Video> getSavedVideos() {
		return savedVideos;
	}
	
	public void setSavedVideos(List<Video> videos) {
        this.savedVideos = videos;
    }

	public int getTotalUsedSpace() {
		return savedVideos.stream().mapToInt(o -> o.getSizeMB()).sum();
	}
}
