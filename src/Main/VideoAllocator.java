package Main;

import org.apache.commons.math3.*;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.linear.SimplexSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import Entities.CacheServer;
import Entities.Video;

public class VideoAllocator {

    public static List<Video> pickVideosForCacheServer(CacheServer cacheServer, List<Video> relevantVideos) {
        List<Video> actualVideos = relevantVideos;
        // remove all videos too big for this cache
        // remove all videos that have no requests at all
        for (Video v : relevantVideos) {
            if (v.getSizeMB() > cacheServer.getSizeMB()) {
                actualVideos.remove(v);
            }
            if (v.totalRequestsSum().equals(0l)) {
                actualVideos.remove(v);
            }
        }
        
        // get from each video the request * time_saved for this cache server
        // also get the size of each video
        double[] timeSavedForThisCacheServer = new double[actualVideos.size()];
        double[] videoSizes = new double[actualVideos.size()];
        for (int v = 0; v < actualVideos.size(); v++) { // Video video : actualVideos) {
            Double timeToAdd = actualVideos.get(v).getTimeSavedPerCacheServer().get(cacheServer.getId());
            timeSavedForThisCacheServer[v] = timeToAdd;
            videoSizes[v] = ((double) actualVideos.get(v).getSizeMB());
        }
        
        // calculate the sum of time saved
        LinearObjectiveFunction sumOfTimeSaved = new LinearObjectiveFunction(timeSavedForThisCacheServer, 0.0);
        // calculate the constraint
        LinearConstraint sizeConstraint = new LinearConstraint(videoSizes, Relationship.LEQ, cacheServer.getSizeMB());
        // solve for maximum time saved
        SimplexSolver solver = new SimplexSolver();
        PointValuePair resultMapping = solver.doOptimize();
        // the result is the list of videos to be stored at this cache server
        double[] resultValues = resultMapping.getPoint();
        for (int i = 0; i < resultValues.length; i++) {
            if (resultValues[i] == 0) {
                actualVideos.remove(i);
            }
        }
        return actualVideos;
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
