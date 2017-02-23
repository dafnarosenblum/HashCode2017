package Main;

import java.util.List;

import Entities.CacheServer;
import Entities.Video;

public class VideoAllocator {

    public static List<Video> pickVideosForCacheServer(CacheServer cacheServer, List<Video> relevantVideos) {
        // remove all videos too big for this cache
        // remove all videos that have no requests at all
        for (Video v : relevantVideos) {
            if (v.getSizeMB() > cacheServer.getSizeMB()) {
                relevantVideos.remove(v);
            }
            if (false) { // v.getRequests() == 0
                relevantVideos.remove(v);
            }
        }
        // calculate for each video a vector of requests * time_saved for this cache server
        
        // calculate the sum of time saved
        // calculate the constraint
        // solve for maximum time saved

        // the result is the list of videos to be stored at this cache server
        
        return relevantVideos;
    }
}

/*
 * // calculate the capacity of the biggest cache server
    long largestCacheSize = 0;
    for (CacheServer cs : cacheServers) {
        if (cs.getSizeMB() > largestCacheSize) {
            largestCacheSize = cs.getSizeMB();
        }
    }
    // make a list of all the videos to consider for allocation (all of the videos at this stage)

    // iterate over the list and remove every video that is too big for any cache server

    // iterate over the list and remove every video that has no requests
 */
