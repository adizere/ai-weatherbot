package model;

import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeSet;

public class WeatherData {
	
	String location = "niciunde";
	Set<Label> labels = new TreeSet<Label>();
	Timeline timeline = new Timeline(GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
	
	/**
	 * 
	 */
	public WeatherData() {
		super();
	}
	
	/**
	 * @param location
	 * @param labels
	 * @param timeline
	 */
	public WeatherData(String location, Set<Label> labels, Timeline timeline) {
		super();
		this.location = location;
		this.labels = labels;
		this.timeline = timeline;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Label> getLabels() {
		return labels;
	}

	public void setLabels(Set<Label> labels) {
		this.labels = labels;
	}

	public Timeline getTimeline() {
		return timeline;
	}

	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
	}
	
}
