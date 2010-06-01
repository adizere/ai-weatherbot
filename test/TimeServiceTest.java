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
		TimeService.setToday(tl);
		TimeService.setMidDayTime(tl);
		
		System.out.println(Timeline.displayCalendar(tl.getBegin()));
		System.out.println(Timeline.displayCalendar(tl.getEnd()));
		System.out.println(Timeline.displayCalendar(ts.getTimeline().getBegin()));
		System.out.println(Timeline.displayCalendar(ts.getTimeline().getEnd()));
		System.out.println();
		assertTrue(ts.getTimeline().equals(tl));

	}

	public void testTimeServiceStringString() {
		TimeService ts = new TimeService("maine", "seara");
		Timeline tl = new Timeline();
		TimeService.setTomorrow(tl);
		TimeService.setEveningTime(tl);
		
		System.out.println();
		System.out.println(Timeline.displayCalendar(tl.getBegin()));
		System.out.println(Timeline.displayCalendar(tl.getEnd()));
		System.out.println(Timeline.displayCalendar(ts.getTimeline().getBegin()));
		System.out.println(Timeline.displayCalendar(ts.getTimeline().getEnd()));
		assertTrue(ts.getTimeline().equals(tl));
		
	}

}
