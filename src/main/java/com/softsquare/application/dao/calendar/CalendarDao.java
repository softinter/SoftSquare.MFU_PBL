package com.softsquare.application.dao.calendar;

import java.util.ArrayList;

import com.softsquare.application.domain.CalendarMapping;

public interface CalendarDao {
	public ArrayList<CalendarMapping> calendarQuery();
	public ArrayList<CalendarMapping> calendarEdit(CalendarMapping calendarMapping);
}
