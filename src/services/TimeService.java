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
		setSeconds(timeline);
		setTimelineFromInput(-1, -1);
	}
	
	public TimeService(String date, String time){
		this.timeline = new Timeline();
		int d = -1, t = -1;
		for(int i = 0; i < TimeService.dateList.size(); i++){
			if (TimeService.dateList.get(i).equals(date))
				d = i;
			if (TimeService.dateList.get(i).equals(time))
				d = i;
		}		
		for(int j = 0; j < TimeService.timeList.size(); j++){
			if (TimeService.timeList.get(j).equals(date))
				t = j;
			if (TimeService.timeList.get(j).equals(time))
				t = j;
		}
		System.out.println("d: " + d + " t: " + t);
		setTimelineFromInput(d, t);
	}
	
	public void setTimelineFromInput(int date, int time){		
		if( date == -1 ){
			setToday(timeline);
		}
		else{
			switch (date){
			case 0: setTheDayBeforeYersterday(timeline);
					setMidDayTime(timeline);
					break;
			case 1: setYersterday(timeline);
					setMidDayTime(timeline);
					break;
			case 2: setToday(timeline);
					setMidDayTime(timeline);
					break;
			case 3: setToday(timeline);
					setMidDayTime(timeline);
					break;
			case 4: setToday(timeline);
					setMidDayTime(timeline);
					break;
			case 5: setTomorrow(timeline);
					setMidDayTime(timeline);
					System.out.println(Timeline.displayCalendar(timeline.getBegin()));
					System.out.println(Timeline.displayCalendar(timeline.getEnd()));
					break;
			case 6: setTheDayAfterTomorrow(timeline);
					setMidDayTime(timeline);
					break;
			}
		}
		
		if( time == -1){
			setMidDayTime(timeline);
		}
		else{
			switch (time){
			case 0: setMorningTime(timeline);
			break;
			case 1: setMidDayTime(timeline);
			break;
			case 2: setMidDayTime(timeline);
			break;
			case 3: setEveningTime(timeline);
			break;
			case 4: setEveningTime(timeline);
			break;
			case 5: setNightTime(timeline);
			break;
			case 6: setNightTime(timeline);
					setYersterday(timeline);
					break;
			case 7: setEveningTime(timeline);
					setYersterday(timeline);
					break;
			}
		}
	}
	
	public Timeline getTimeline() {
		return timeline;
	}
	
	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
	}
	
	public static void setSeconds(Timeline t){
		t.getEnd().set(Calendar.SECOND, 0);
		t.getBegin().set(Calendar.SECOND, 0);
	}
	
	public static void setMorningTime(Timeline morning){
		morning.getBegin().set(Calendar.HOUR_OF_DAY, 5);
		morning.getBegin().set(Calendar.MINUTE, 0);
		morning.getEnd().set(Calendar.HOUR_OF_DAY, 11);
		morning.getEnd().set(Calendar.MINUTE, 59);
		setSeconds(morning);
	}
	
	public static void setMidDayTime(Timeline morning){
		morning.getBegin().set(Calendar.HOUR_OF_DAY, 12);
		morning.getBegin().set(Calendar.MINUTE, 0);
		morning.getEnd().set(Calendar.HOUR_OF_DAY, 16);
		morning.getEnd().set(Calendar.MINUTE, 59);
		setSeconds(morning);
	}
	
	public static void setEveningTime(Timeline morning){
		morning.getBegin().set(Calendar.HOUR_OF_DAY, 17);
		morning.getBegin().set(Calendar.MINUTE, 0);
		morning.getEnd().set(Calendar.HOUR_OF_DAY, 21);
		morning.getEnd().set(Calendar.MINUTE, 59);
		setSeconds(morning);
	}
	
	public static void setNightTime(Timeline morning){
		morning.getBegin().set(Calendar.HOUR_OF_DAY, 22);
		morning.getBegin().set(Calendar.MINUTE, 0);
		morning.getEnd().set(Calendar.HOUR_OF_DAY, 4);
		morning.getEnd().set(Calendar.MINUTE, 59);
		setSeconds(morning);
	}
	
	public static void setTheDayBeforeYersterday(Timeline date){
		date.getBegin().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) - 2); 
		date.getEnd().set(Calendar.DATE, date.getEnd().get(Calendar.DATE) - 2);
		setSeconds(date);
	}
	
	public static void setYersterday(Timeline date){
		date.getBegin().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) - 1); 
		date.getEnd().set(Calendar.DATE, date.getEnd().get(Calendar.DATE) - 1);
		setSeconds(date);
	}
	
	public static void setToday(Timeline date){//useless
		setSeconds(date);
		/*
		date.getBegin().set(Calendar.DATE, date.getBegin().get(Calendar.DATE)); 
		date.getEnd().set(Calendar.DATE, date.getBegin().get(Calendar.DATE));
		*/
	}
	
	public static void setTomorrow(Timeline date){
		date.getBegin().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) + 1); 
		date.getEnd().set(Calendar.DATE, date.getEnd().get(Calendar.DATE) + 1);
		setSeconds(date);
	}
	
	public static void setTheDayAfterTomorrow(Timeline date){
		date.getBegin().set(Calendar.DATE, date.getBegin().get(Calendar.DATE) + 2); 
		date.getEnd().set(Calendar.DATE, date.getEnd().get(Calendar.DATE) + 2);
		setSeconds(date);
	}
	
	/* adi: un fel de setSeconds, da pentru zi */
	
	public static void setDay(Timeline t){
		t.getEnd().set(Calendar.YEAR, 0);
		t.getBegin().set(Calendar.YEAR, 0);
	}
	
}
