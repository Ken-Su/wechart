package com.wx.platform.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.wx.platform.util.BeanUtil;
import com.wx.platform.util.JSONUtil;
import com.wx.platform.util.NetWorkCenter;
import com.wx.platform.util.NetWorkCenter.ResponseCallback;

public class PublicBusAPI {
	
	private static final Logger LOG = LoggerFactory.getLogger(PublicBusAPI.class);	
	

	public static String getNextBus(String routeNumber, String station){
		StringBuffer nextbusResult = new StringBuffer();
		List<Map> busResult = getBusResult(routeNumber);
		
		List<Map> busStations = PublicBusAPI.getBusStation(busResult.get(0).get("Id").toString());
		List<Map> nextBusStations = PublicBusAPI.getNextBusStation(busResult.get(0).get("FromStation").toString(), busResult.get(0).get("Name").toString());
		Map<String,Object> minDistanceResult = getMinDistance(busStations, nextBusStations, station);
		
		List<Map> reverseBusStations = PublicBusAPI.getBusStation(busResult.get(1).get("Id").toString());
		List<Map> reverseNextBusStations = PublicBusAPI.getNextBusStation(busResult.get(1).get("FromStation").toString(), busResult.get(1).get("Name").toString());
		Map<String,Object> reverseMinDistanceResult = getMinDistance(reverseBusStations, reverseNextBusStations, station);
		
		if(minDistanceResult == null){
			nextbusResult.append(busResult.get(0).get("Name").toString()+ "往"+busResult.get(0).get("ToStation").toString()+"方向没车了！！！杯具了！！！\n");
			System.out.println("杯具了！！！没车了！！！");
		}else{
			nextbusResult.append(busResult.get(0).get("Name").toString()+ "往"+busResult.get(0).get("ToStation").toString()+"方向的下一趟车离"+station+"还有"+minDistanceResult.get("minNext")+"站,目前在"+minDistanceResult.get("CurrentStation")+"\n");
			System.out.println(busResult.get(0).get("Name").toString()+ "往"+busResult.get(0).get("ToStation").toString()+"方向的下一趟车离"+station+"还有"+minDistanceResult.get("minNext")+"站,目前在"+minDistanceResult.get("CurrentStation"));
		}
		
		if(reverseMinDistanceResult == null){
			nextbusResult.append(busResult.get(1).get("Name").toString()+ "往"+busResult.get(1).get("ToStation").toString()+"方向没车了！！！杯具了！！！\n");
			System.out.println("杯具了！！！没车了！！！");
		}else{
			nextbusResult.append(busResult.get(1).get("Name").toString()+ "往"+busResult.get(1).get("ToStation").toString()+"方向的下一趟车离"+station+"还有"+reverseMinDistanceResult.get("minNext")+"站,目前在"+reverseMinDistanceResult.get("CurrentStation")+"\n");
			System.out.println(busResult.get(1).get("Name").toString()+ "往"+busResult.get(1).get("ToStation").toString()+"方向的下一趟车离"+station+"还有"+reverseMinDistanceResult.get("minNext")+"站,目前在"+reverseMinDistanceResult.get("CurrentStation"));
		}
		return nextbusResult.toString();
	}
	
	private static Map<String,Object> getMinDistance(List<Map> busStations, List<Map> nextBusStations, String station){
		int stationIndex = 0;
		List<Integer> nextBusStationIndex = new ArrayList<Integer>();
		for(int i=0; i<busStations.size(); i++){
			Map busStation = busStations.get(i);
			if(busStation.get("Name").toString().equals(station)){
				stationIndex = i;
				break;
			}
		}
		for(int i=0; i<nextBusStations.size(); i++){
			Map nextBusStation = nextBusStations.get(i);
			for(int j=0; j<busStations.size(); j++){
				Map busStation = busStations.get(j);
				if(busStation.get("Name").toString().equals(nextBusStation.get("CurrentStation").toString())){
					nextBusStationIndex.add(j);
					break;
				}
			}
		}
		int minNext = stationIndex-nextBusStationIndex.get(0);
		for(int i=1; i<nextBusStationIndex.size(); i++){
			int distance = stationIndex-nextBusStationIndex.get(i);
			if(distance>0){
				if(minNext<0){
					minNext = distance;
				}else{
					minNext = minNext>distance ? distance : minNext;
				}
			}
		}
		if(minNext<0){
			return null;
		}else{
			Map<String,Object> resultMap = new HashMap<String, Object>();
			resultMap.put("minNext", minNext);
			resultMap.put("CurrentStation", busStations.get(stationIndex-minNext).get("Name"));
			return resultMap;
		}
	}
	
	public static List<Map> getBusResult(String routeNumber){
		BeanUtil.requireNonNull(routeNumber, "routeNumber is null");
		String url = "http://120.25.149.162/BusLine/WS.asmx/SearchLine";
		String busJson = executePost(url, "{key:'"+routeNumber+"'}");
		List<Map> busResult = JSON.parseArray(JSONUtil.getStringFromJSONObject(busJson, "d").toString(), Map.class);
		return busResult;
	}
	
	public static List<Map> getBusStation(String lineId){
		BeanUtil.requireNonNull(lineId, "lineId is null");
		String url = "http://120.25.149.162/BusLine/WS.asmx/LoadStationByLineId";
		String busJson = executePost(url, "{lineId:'"+lineId+"'}");
		List<Map> busStations = JSON.parseArray(JSONUtil.getStringFromJSONObject(busJson, "d").toString(), Map.class);
		return busStations;
	}
	
	public static List<Map> getNextBusStation(String fromStation, String lineName){
		BeanUtil.requireNonNull(fromStation, "fromStation is null");
		BeanUtil.requireNonNull(lineName, "lineName is null");
		String url = "http://120.25.149.162/BusLine/WS.asmx/GetBusListOnRoad";
		String busJson = executePost(url, "{fromStation:'"+fromStation+"', lineName:'"+lineName+"'}");
		List<Map> nextBusStations = JSON.parseArray(JSONUtil.getStringFromJSONObject(busJson, "d").toString(), Map.class);
		return nextBusStations;
	}
	
	
	public static String executePost(String url, String json){
		BeanUtil.requireNonNull(url, "url is null");
		final StringBuffer result = new StringBuffer();
		NetWorkCenter.post(url, json, new ResponseCallback() {
			@Override
			public void onResponse(int resultCode, String resultJson) {
				if (200 == resultCode) {
					result.append(resultJson);
                }
			}
		});
        return result.toString();
	}
	
	public static void main(String[] args) {
		/*List<Map> busResult = PublicBusAPI.getBusResult(69);
		List<Map> busStations = PublicBusAPI.getBusStation(busResult.get(0).get("Id").toString());
		List<Map> nextBusStations = PublicBusAPI.getNextBusStation(busResult.get(0).get("FromStation").toString(), busResult.get(0).get("Name").toString());
		System.out.println(nextBusStations);*/
		PublicBusAPI.getNextBus("k2", "海怡湾畔");
	}
}
