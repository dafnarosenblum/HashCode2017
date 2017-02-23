package Main;

import java.util.ArrayList;
import java.util.List;

import Entities.CacheServer;

public class Main {

	public static void main(String[] args) {
	    
	    // parser work
	    List<CacheServer> cacheServers = new ArrayList<>();
	    
	    // calculate the capacity of the biggest cache server
	    long largestCacheSize = 0;
	    for (CacheServer cs : cacheServers) {
	        if (cs.getSize() > largestCacheSize) {
	            largestCacheSize = cs.getSize();
	        }
	    }
	    // make a list of all the videos to consider for allocation (all of the videos at this stage)
	    
	    // iterate over the list and remove every video that is too big for any cache server
	    
	    // iterate over the list and remove every video that has no requests
	    
	    // calculate for each video a vector of requests * time_saved for each cache server
	    
	    // for each cache server:
	    // calculate the sum of time saved 
	    // calculate the constraint
	    // solve for maximum time saved
	    
	    // the result is the list of videos to be stored at this cache server

	}

}
