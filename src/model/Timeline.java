package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Timeline {
	
	private Calendar begin;
	private Calendar end;
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
		this.begin = new GregorianCalendar();
		this.end = new GregorianCalendar();
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
	
	public boolean covers(Timeline timeline){
		if( ( this.begin.before(timeline.getBegin()) || this.begin.equals(timeline.getBegin())) &&
			( this.end.after(timeline.getEnd()) || this.end.equals(timeline.getEnd())) ){
			
			return true;
		}
		return false;
	}
}
