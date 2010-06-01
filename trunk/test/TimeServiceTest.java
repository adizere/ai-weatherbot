import java.util.Calendar;

import model.Timeline;

import services.TimeService;
import junit.framework.TestCase;


public class TimeServiceTest extends TestCase {

	public TimeServiceTest(String name) {
		super(name);
	}

	public void testTimeService() {
		TimeService ts = new TimeService();
		Timeline tl = new Timeline();
		System.out.println("new time beg" + Timeline.displayCalendar(tl.getBegin()));
		System.out.println("new time end" + Timeline.displayCalendar(tl.getEnd()));
		TimeService.setToday(tl);
		System.out.println("today time beg" + Timeline.displayCalendar(tl.getBegin()));
		System.out.println("today time end" + Timeline.displayCalendar(tl.getEnd()));
		TimeService.setMidDayTime(tl);
		System.out.println("mid time beg" + Timeline.displayCalendar(tl.getBegin()));
		System.out.println("mid time end" + Timeline.displayCalendar(tl.getEnd()));
		
		System.out.println(Timeline.displayCalendar(tl.getBegin()));
		System.out.println(Timeline.displayCalendar(tl.getEnd()));
		System.out.println(Timeline.displayCalendar(ts.getTimeline().getBegin()));
		System.out.println(Timeline.displayCalendar(ts.getTimeline().getEnd()));
		System.out.println();
		assertTrue(ts.getTimeline().covers(tl));
		
		//System.out.println(ts.getTimeline().getBegin().toString());
		//System.out.println(ts.getTimeline().getEnd().toString());
	}

	public void testTimeServiceStringString() {
		TimeService ts = new TimeService("maine", "seara");
		Timeline tl = new Timeline();
		System.out.println("new time beg" + Timeline.displayCalendar(tl.getBegin()));
		System.out.println("new time end" + Timeline.displayCalendar(tl.getEnd()));
		TimeService.setTomorrow(tl);
		System.out.println("tom time beg" + Timeline.displayCalendar(tl.getBegin()));
		System.out.println("tom time end" + Timeline.displayCalendar(tl.getEnd()));
		TimeService.setEveningTime(tl);
		System.out.println("eve time beg" + Timeline.displayCalendar(tl.getBegin()));
		System.out.println("eve time end" + Timeline.displayCalendar(tl.getEnd()));
		
		System.out.println();
		System.out.println(Timeline.displayCalendar(tl.getBegin()));
		System.out.println(Timeline.displayCalendar(tl.getEnd()));
		System.out.println(Timeline.displayCalendar(ts.getTimeline().getBegin()));
		System.out.println(Timeline.displayCalendar(ts.getTimeline().getEnd()));
		assertTrue(ts.getTimeline().covers(tl));
	}

}
