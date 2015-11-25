package com.wx.platform.entity;

public class StationRoute {
	
	private Integer id;
	
	private String stationName;
	
	private String toStationName;
	
	private String directRoute;
	
	private Integer directStationCount;
	
	private String nextStationName;
	
	private String route;
	
	private Integer minMetric;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getToStationName() {
		return toStationName;
	}

	public void setToStationName(String toStationName) {
		this.toStationName = toStationName;
	}

	public String getDirectRoute() {
		return directRoute;
	}

	public void setDirectRoute(String directRoute) {
		this.directRoute = directRoute;
	}

	public Integer getDirectStationCount() {
		return directStationCount;
	}

	public void setDirectStationCount(Integer directStationCount) {
		this.directStationCount = directStationCount;
	}

	public String getNextStationName() {
		return nextStationName;
	}

	public void setNextStationName(String nextStationName) {
		this.nextStationName = nextStationName;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Integer getMinMetric() {
		return minMetric;
	}

	public void setMinMetric(Integer minMetric) {
		this.minMetric = minMetric;
	}
	
}
