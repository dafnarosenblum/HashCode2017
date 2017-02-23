package Entities;

import java.util.HashMap;
import java.util.Map;

public class EndPoint {

	private final int id;
	private final long dataCenterLatency;
	private final Map<CacheServer, Long> cacheServersToLatencies = new HashMap<>();
	private Requests requests;

	public EndPoint(int id, long dataCenterLatency) {
		this.id = id;
		this.dataCenterLatency = dataCenterLatency;
	}

	public Map<CacheServer, Long> getChacheServersToLatencies() {
		return cacheServersToLatencies;
	}

	public Requests getRequest() {
		return requests;
	}

	public void addCacheToLatency(CacheServer cache, Long latency) {
		cacheServersToLatencies.put(cache, latency);
	}

	public void setRequests(Requests requests) {
		this.requests = requests;
	}
}
