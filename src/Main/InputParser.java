package Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Entities.CacheServer;
import Entities.EndPoint;
import Entities.Requests;
import Entities.Video;

public class InputParser {

	public static void parse(String fileName, List<Video> videos, List<EndPoint> endPoints,
			List<CacheServer> cacheServers) throws IOException {
		Iterator<String> lines = Files.lines(Paths.get(fileName)).iterator();
		String[] firstLine = lines.next().split(" ");
		String[] secondLine = lines.next().split(" ");
		int numberOfVideos = Integer.valueOf(firstLine[0]);
		int numberOfEndPoints = Integer.valueOf(firstLine[1]);
		int sizeOfCacheServers = Integer.valueOf(firstLine[4]);

		videos.addAll(parseVideos(secondLine, numberOfVideos));
		endPoints.addAll(parseEndPoints(lines, numberOfEndPoints, sizeOfCacheServers, cacheServers));
		parseRequests(lines, endPoints, videos);
	}

	private static void parseRequests(Iterator<String> lines, List<EndPoint> endPoints, List<Video> videos) {
		Map<Integer, EndPoint> endPointsMap = endPoints.stream().collect(Collectors.toMap(x -> x.getId(), x -> x));
		Map<Integer, Video> videosMap = videos.stream().collect(Collectors.toMap(x -> x.getId(), x -> x));
		while (lines.hasNext()) {
			String[] request_line = lines.next().split(" ");
			int videoId = Integer.valueOf(request_line[0]);
			int endPointId = Integer.valueOf(request_line[1]);
			int numOfRequests = Integer.valueOf(request_line[2]);
			Requests requests = new Requests(videosMap.get(videoId), numOfRequests);
			endPointsMap.get(endPointId).setRequests(requests);
		}
	}

	private static List<EndPoint> parseEndPoints(Iterator<String> lines, int numberOfEndPoints, int sizeOfCacheServers,
			List<CacheServer> cacheServers) {
		List<EndPoint> endPoints = new ArrayList<>();
		int endPointsCounter = 0;
		while (endPointsCounter < numberOfEndPoints) {
			String[] dataCenterLatencyAndNumOfCaches = lines.next().split(" ");
			long dataCenterLatency = Long.valueOf(dataCenterLatencyAndNumOfCaches[0]);
			int numOfCaches = Integer.valueOf(dataCenterLatencyAndNumOfCaches[1]);
			EndPoint endPoint = new EndPoint(endPointsCounter, dataCenterLatency);
			addLatenciesToCacheServers(lines, sizeOfCacheServers, numOfCaches, endPoint, cacheServers);
			endPointsCounter++;
		}
		return endPoints;
	}

	private static void addLatenciesToCacheServers(Iterator<String> lines, int sizeOfCacheServers, int numOfCaches,
			EndPoint endPoint, List<CacheServer> cacheServers) {
		for (int cacheCounter = 0; cacheCounter < numOfCaches; cacheCounter++) {
			String[] latenciesToCaches = lines.next().split(" ");
			int cacheId = Integer.valueOf(latenciesToCaches[0]);
			long latency = Long.valueOf(latenciesToCaches[1]);
			CacheServer cacheServer = new CacheServer(cacheId, sizeOfCacheServers);
			cacheServers.add(cacheServer);
			endPoint.addCacheToLatency(cacheServer, latency);
		}
	}

	private static List<Video> parseVideos(String[] secondLine, int numberOfVideos) {
		List<Video> videos = new ArrayList<>();
		for (int id = 0; id < numberOfVideos; id++) {
			videos.add(new Video(Integer.valueOf(id), Integer.valueOf(secondLine[id])));
		}
		return videos;
	}
}
