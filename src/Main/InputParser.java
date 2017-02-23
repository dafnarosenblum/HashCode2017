package Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Entities.Video;

public class InputParser {

	public static void parse(String fileName) throws IOException {
		Iterator<String> lines = Files.lines(Paths.get(fileName)).iterator();
		String[] firstLine = lines.next().split(" ");
		String[] secondLine = lines.next().split(" ");
		List<Video> videos = new ArrayList<>();
		for (int id = 0; id < Integer.valueOf(firstLine[0]); id++) {
			videos.add(new Video(Integer.valueOf(id), Integer.valueOf(secondLine[id])));
		}
	}
}
