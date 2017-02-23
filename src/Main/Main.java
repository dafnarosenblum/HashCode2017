package Main;

import java.util.ArrayList;
import java.util.List;

import Entities.CacheServer;
import Entities.Video;

public class Main {

	public static void main(String[] args) {

		// parser work
	    
		List<CacheServer> cacheServers = new ArrayList<>();
		
		// populate the videos list
		List<Video> allVideos = new ArrayList<>();
		
		// for each video, calculate a list of times saved in each cache server
		
		
		for (CacheServer cacheServer : cacheServers) {
		    List <Video> videosForServer = VideoAllocator.pickVideosForCacheServer(cacheServer, allVideos);
		    cacheServer.setSavedVideos(videosForServer);
		    // write result to file
		}
		
	}

}
