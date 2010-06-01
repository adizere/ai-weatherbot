package model;

import java.util.GregorianCalendar;

public class WeatherData {
	
	private long id;
	String location = "niciunde";
	Label label;
	private long label_id;
	Timeline timeline = new Timeline(GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
	private long timeline_id;
	
	/**
	 * 
	 */
	public WeatherData() {
		super();
	}

	/**
	 * @param id
	 * @param location
	 * @param labelId
	 * @param timelineId
	 */
	public WeatherData(long id, String location, long labelId, long timelineId) {
		super();
		this.id = id;
		this.location = location;
		label_id = labelId;
		timeline_id = timelineId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public long getLabel_id() {
		return label_id;
	}

	public void setLabel_id(long labelId) {
		label_id = labelId;
	}

	public Timeline getTimeline() {
		return timeline;
	}

	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
	}

	public long getTimeline_id() {
		return timeline_id;
	}

	public void setTimeline_id(long timelineId) {
		timeline_id = timelineId;
	}

	@Override
	public String toString() {
		return "WeatherData [id=" + id + ", label=" + label + ", location="
				+ location + ", timeline=" + timeline + "]";
	}
	
	
	
	
}
