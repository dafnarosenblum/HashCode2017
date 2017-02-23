package Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Entities.CacheServer;
import Entities.EndPoint;
import Entities.Video;

public class InputParser {

	public static void parse(String fileName, List<Video> videos, List<EndPoint> endPoints,
			List<CacheServer> cacheServers) throws IOException {
		Iterator<String> lines = Files.lines(Paths.get(fileName)).iterator();
		String[] firstLine = lines.next().split(" ");
		String[] secondLine = lines.next().split(" ");
		int numberOfVideos = Integer.valueOf(firstLine[0]);
		int numberOfEndPoints = Integer.valueOf(firstLine[1]);
		videos = parseVideos(secondLine, numberOfVideos);
		endPoints = parseEndPoints(lines, numberOfEndPoints);
	}

	private static List<EndPoint> parseEndPoints(Iterator<String> lines, int numberOfEndPoints) {
		List<EndPoint> endPoints = new ArrayList<>();
		int endPointsCounter = 0;
		while (endPointsCounter < numberOfEndPoints) {
			String[] dataCenterLatencyAndNumOfCaches = lines.next().split(" ");
			long dataCenterLatency = Long.valueOf(dataCenterLatencyAndNumOfCaches[0]);
			int numOfCaches = Integer.valueOf(dataCenterLatencyAndNumOfCaches[1]);
			EndPoint endPoint = new EndPoint(endPointsCounter, dataCenterLatency);
			endPointsCounter++;
		}
		return endPoints;
	}

	private static List<Video> parseVideos(String[] secondLine, int numberOfVideos) {
		List<Video> videos = new ArrayList<>();
		for (int id = 0; id < numberOfVideos; id++) {
			videos.add(new Video(Integer.valueOf(id), Integer.valueOf(secondLine[id])));
		}
		return videos;
	}
}
