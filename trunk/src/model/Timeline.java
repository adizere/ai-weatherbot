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
		this.begin.set(Calendar.MILLISECOND, 0);
		this.end.set(Calendar.MILLISECOND, 0);
	}
	
	/**
	 * @param begin
	 * @param end
	 */
	public Timeline(Calendar begin, Calendar end) {
		super();
		this.begin = begin;
		this.end = end;
		this.begin.set(Calendar.MILLISECOND, 0);
		this.end.set(Calendar.MILLISECOND, 0);
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
		this.begin.set(Calendar.MILLISECOND, 0);
		this.end.set(Calendar.MILLISECOND, 0);
	}
	
	public Calendar getBegin() {
		return begin;
	}
	
	public void setBegin(Calendar begin) {
		this.begin = begin;
		this.begin.set(Calendar.MILLISECOND, 0);
	}
	
	public Calendar getEnd() {
		return end;
	}
	
	public void setEnd(Calendar end) {
		this.end = end;
		this.end.set(Calendar.MILLISECOND, 0);
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean covers(Timeline timeline){
//		if( ( this.begin.before(timeline.getBegin()) || this.begin.equals(timeline.getBegin())) &&
//			( this.end.after(timeline.getEnd()) || this.end.equals(timeline.getEnd())) ){
//			
//			return true;
//		}
//		return false;
		int a = this.begin.compareTo(timeline.begin);
		int b = this.end.compareTo(timeline.end);
		
		if ((a <= 0) && (b >=0))
			return true;
		return false;
		
	}
	
	public static String displayCalendar(Calendar c){
		String dc = " " + c.get(Calendar.DATE) + "." + (c.get(Calendar.MONTH)+1) + "." + c.get(Calendar.YEAR) + " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
		return dc;
	}

	@Override
	public String toString() {
		String timeB = this.displayCalendar(begin);
		String timeE = this.displayCalendar(end);
		return "[" + timeB + ", " + timeE + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Timeline t = (Timeline) obj;
		if(!t.getBegin().equals(begin))
			return false;
		if(!t.getEnd().equals(end))
			return false;
		return true;
	}
}
