package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Timeline {
	
	private long id;
	
	private Calendar begin;
	private Calendar end;
	
	
	/**
	 * @param id
	 * @param begin
	 * @param end
	 */
	public Timeline(long id, Calendar begin, Calendar end) {
		super();
		this.id = id;
		this.begin = begin;
		this.end = end;
	}
	
	/**
	 * @param begin
	 * @param end
	 */
	public Timeline(Calendar begin, Calendar end) {
		super();
		this.begin = begin;
		this.end = end;
	}
	/**
	 * 
	 */
	public Timeline() {
		super();
		Calendar beg = Calendar.getInstance();
		this.begin = beg;
		Calendar end = Calendar.getInstance();
		this.end = end;
	}
	
	public Calendar getBegin() {
		return begin;
	}
	
	public void setBegin(Calendar begin) {
		this.begin = begin;
	}
	
	public Calendar getEnd() {
		return end;
	}
	
	public void setEnd(Calendar end) {
		this.end = end;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean covers(Timeline timeline){
		if( ( this.begin.before(timeline.getBegin()) || this.begin.equals(timeline.getBegin())) &&
			( this.end.after(timeline.getEnd()) || this.end.equals(timeline.getEnd())) ){
			
			return true;
		}
		return false;
	}
	
	public static String displayCalendar(Calendar c){
		String dc = " " + (c.get(Calendar.DATE)+1) + "." + (c.get(Calendar.MONTH)+1) + "." + c.get(Calendar.YEAR) + " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
		return dc;
	}
}
