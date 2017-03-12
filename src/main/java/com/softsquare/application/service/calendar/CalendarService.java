package com.softsquare.application.service.calendar;

import java.util.ArrayList;

import com.softsquare.application.domain.CalendarMapping;

public interface CalendarService {
	
	public ArrayList<CalendarMapping> calendarQuery();
	public ArrayList<CalendarMapping> calendarEdit(CalendarMapping calendarMapping);

}
