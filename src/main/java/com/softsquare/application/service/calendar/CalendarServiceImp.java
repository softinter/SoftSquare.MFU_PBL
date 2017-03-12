package com.softsquare.application.service.calendar;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.common.util.DateUtils;
import com.softsquare.application.dao.calendar.CalendarDao;
import com.softsquare.application.domain.CalendarMapping;

@Service
public class CalendarServiceImp implements CalendarService {

	@Autowired
	private CalendarDao calendarDao;
	
	@Override
	public ArrayList<CalendarMapping> calendarQuery() {
		ArrayList<CalendarMapping> calendarList = calendarDao.calendarQuery();
		for (CalendarMapping mapping : calendarList) {
			mapping.setStart(DateUtils.formatShortDateCalendar(mapping.getStartDate())+"T"+mapping.getStartTime());
			mapping.setEnd(DateUtils.formatShortDateCalendar(mapping.getEndDate())+"T"+mapping.getEndTime());
			mapping.setStartDate(null);
			mapping.setStartTime(null);
			mapping.setEndDate(null);
			mapping.setEndTime(null);
		}
		return calendarList;
	}

	@Override
	public ArrayList<CalendarMapping> calendarEdit(CalendarMapping calendarMapping) {
		return calendarDao.calendarEdit(calendarMapping);
	}

}
