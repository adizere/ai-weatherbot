import java.util.Calendar;

import model.Timeline;

import services.TimeService;
import junit.framework.TestCase;
import java.util.regex.*;

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
		String s = new String("?Hello!? . ,  ' ! ? ! ?!");
		String p = s.replaceAll("(\\p{P})", "");//("Hello!?!?!?!", "[?!]", "");
		String h = s.replaceAll("[?!,.']", "");
		System.out.println("Stringul: " + s + p + h);
		assertTrue(ts.getTimeline().equals(tl));		

	}

	public void testTimeServiceStringString() {
		TimeService ts = new TimeService("maine", "seara");
		Timeline tl = new Timeline();
		TimeService.setMidDayTime(tl);
		TimeService.setTomorrow(tl);
		TimeService.setEveningTime(tl);
		System.out.println();
		System.out.println(TimeService.getVerb(tl));
		
		System.out.println();
		System.out.println(Timeline.displayCalendar(tl.getBegin()));
		System.out.println(Timeline.displayCalendar(tl.getEnd()));
		System.out.println(Timeline.displayCalendar(ts.getTimeline().getBegin()));
		System.out.println(Timeline.displayCalendar(ts.getTimeline().getEnd()));
		assertTrue(ts.getTimeline().equals(tl));
		
	}

}
