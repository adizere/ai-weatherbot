package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import model.Timeline;

public class TimeService {
	private Timeline timeline;
	
	private static List<String> dateList= Arrays.asList("alaltaieri","ieri","azi","astazi","este","maine","poimaine");
	private static List<String> timeList= Arrays.asList("dimineata","amiazi","amiaza","seara","diseara","noapte");
	
	public TimeService() {
		// TODO Auto-generated constructor stub
	}
	
	public TimeService(String date, String time){
		
	}
	
	public Timeline getTimeline() {
		return timeline;
	}
	
	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
	}
	
	public void getMorningTime(Timeline morning){
		morning.getBegin().set(Calendar.HOUR, 5);
		morning.getBegin().set(Calendar.MINUTE, 0);
		morning.getEnd().set(Calendar.HOUR, 11);
		morning.getEnd().set(Calendar.MINUTE, 59);
	}
	
	public void getMidDayTime(Timeline morning){
		morning.getBegin().set(Calendar.HOUR, 12);
		morning.getBegin().set(Calendar.MINUTE, 0);
		morning.getEnd().set(Calendar.HOUR, 16);
		morning.getEnd().set(Calendar.MINUTE, 59);
	}
	
	public void getEveningTime(Timeline morning){
		morning.getBegin().set(Calendar.HOUR, 17);
		morning.getBegin().set(Calendar.MINUTE, 0);
		morning.getEnd().set(Calendar.HOUR, 21);
		morning.getEnd().set(Calendar.MINUTE, 59);
	}
	
	public void getNightTime(Timeline morning){
		morning.getBegin().set(Calendar.HOUR, 22);
		morning.getBegin().set(Calendar.MINUTE, 0);
		morning.getEnd().set(Calendar.HOUR, 4);
		morning.getEnd().set(Calendar.MINUTE, 59);
	}
}
