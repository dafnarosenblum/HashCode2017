package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entities.CacheServer;
import Entities.EndPoint;
import Entities.Video;

public class Main {

	public static void main(String[] args) throws IOException {

		// parser work
		List<EndPoint> endPoints = new ArrayList<>();
		List<Video> videos = new ArrayList<>();
		List<CacheServer> cacheServers = new ArrayList<>();
		InputParser.parse(args[0], videos, endPoints, cacheServers);

		// populate the videos list
		List<Video> allVideos = new ArrayList<>();

		// for each video, calculate a list of times saved in each cache server

		for (CacheServer cacheServer : cacheServers) {
			List<Video> videosForServer = VideoAllocator.pickVideosForCacheServer(cacheServer, allVideos);
			cacheServer.setSavedVideos(videosForServer);
			// write result to file
		}

	}

}
