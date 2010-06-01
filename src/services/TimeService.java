package services;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import model.Timeline;

public class TimeService {
	private Timeline timeline;
	
	private static List<String> dateList= Arrays.asList("alaltaieri","ieri","azi","astazi","este","maine","poimaine");
	private static List<String> timeList= Arrays.asList("dimineata","amiazi","amiaza","seara","diseara","noapte","azi-noapte","aseara");
	
	public TimeService() {
		this.timeline = new Timeline();
	}
	
	public TimeService(String date, String time){
		this.timeline = new Timeline();
		int d = -1, t = -1;
		for(int i = 0; i < TimeService.dateList.size(); i++){
			if (TimeService.dateList.equals(date))
				d = i;
			if (TimeService.dateList.equals(time))
				d = i;
		}		
		for(int i = 0; i < TimeService.timeList.size(); i++){
			if (TimeService.timeList.equals(date))
				d = i;
			if (TimeService.timeList.equals(time))
				d = i;
		}
		setTimelineFromInput(d, t);
	}
	
	public void setTimelineFromInput(int date, int time){
		if( date != -1 ){
			switch (date){
			case 0: setTheDayBeforeYersterday(timeline);
			case 1: setYersterday(timeline);
			case 2: setToday(timeline);
			case 3: setToday(timeline);
			case 4: setToday(timeline);
			case 5: setTomorrow(timeline);
			case 6: setTheDayAfterTomorrow(timeline);
			}
		}
		else {
			setToday(timeline);
		}
		if( time != -1){
			switch (time){
			case 0: setMorningTime(timeline);
			case 1: setMidDayTime(timeline);
			case 2: setMidDayTime(timeline);
			case 3: setEveningTime(timeline);
			case 4: setEveningTime(timeline);
			case 5: setNightTime(timeline);
			case 6: setNightTime(timeline);
			case 7: setEveningTime(timeline);
			}
		}
		else {
			setMidDayTime(timeline);
		}
		
		if(time == 6) setYersterday(timeline);
		if(time == 7) setYersterday(timeline);
	}
	
	public Timeline getTimeline() {
		return timeline;
	}
	
	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
	}
	
	public void setMorningTime(Timeline morning){
		morning.getBegin().set(Calendar.HOUR, 5);
		morning.getBegin().set(Calendar.MINUTE, 0);
		morning.getEnd().set(Calendar.HOUR, 11);
		morning.getEnd().set(Calendar.MINUTE, 59);
	}
	
	public void setMidDayTime(Timeline morning){
		morning.getBegin().set(Calendar.HOUR, 12);
		morning.getBegin().set(Calendar.MINUTE, 0);
		morning.getEnd().set(Calendar.HOUR, 16);
		morning.getEnd().set(Calendar.MINUTE, 59);
	}
	
	public void setEveningTime(Timeline morning){
		morning.getBegin().set(Calendar.HOUR, 17);
		morning.getBegin().set(Calendar.MINUTE, 0);
		morning.getEnd().set(Calendar.HOUR, 21);
		morning.getEnd().set(Calendar.MINUTE, 59);
	}
	
	public void setNightTime(Timeline morning){
		morning.getBegin().set(Calendar.HOUR, 22);
		morning.getBegin().set(Calendar.MINUTE, 0);
		morning.getEnd().set(Calendar.HOUR, 4);
		morning.getEnd().set(Calendar.MINUTE, 59);
	}
	
	public void setTheDayBeforeYersterday(Timeline date){
		date.getBegin().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) - 2); 
		date.getBegin().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) - 2);
		date.getEnd().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) - 2);
		date.getEnd().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) - 2);
	}
	
	public void setYersterday(Timeline date){
		date.getBegin().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) - 1); 
		date.getBegin().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) - 1);
		date.getEnd().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) - 1);
		date.getEnd().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) - 1);
	}
	
	public void setToday(Timeline date){//useless
		/*
		date.getBegin().set(Calendar.DATE, date.getBegin().get(Calendar.DATE)); 
		date.getBegin().set(Calendar.DATE, date.getBegin().get(Calendar.DATE));
		date.getEnd().set(Calendar.DATE, date.getBegin().get(Calendar.DATE));
		date.getEnd().set(Calendar.DATE, date.getBegin().get(Calendar.DATE));
		*/
	}
	
	public void setTomorrow(Timeline date){
		date.getBegin().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) + 1); 
		date.getBegin().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) + 1);
		date.getEnd().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) + 1);
		date.getEnd().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) + 1);
	}
	
	public void setTheDayAfterTomorrow(Timeline date){
		date.getBegin().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) + 2); 
		date.getBegin().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) + 2);
		date.getEnd().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) + 2);
		date.getEnd().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) + 2);
	}
}
