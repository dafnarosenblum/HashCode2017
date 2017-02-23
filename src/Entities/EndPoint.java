package Entities;

import java.util.Map;

public class EndPoint {

	private final int id;
	private final long dataCenterLatency;
	private final Map<CacheServer, Long> cacheServersToLatencies;
	private final Requests requests;

	public EndPoint(int id, long dataCenterLatency, Map<CacheServer, Long> cacheServersToLatencies, Requests request) {
		this.id = id;
		this.dataCenterLatency = dataCenterLatency;
		this.cacheServersToLatencies = cacheServersToLatencies;
		this.requests = request;
	}

	public Map<CacheServer, Long> getChacheServersToLatencies() {
		return cacheServersToLatencies;
	}

	public Requests getRequest() {
		return requests;
	}
}
