package org.loukili.javac.service;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.pda.junit.entity.Activity;
import org.pda.junit.entity.ActivityType;
import org.pda.junit.entity.State;
import org.pda.junit.service.ActivityService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityServiceTest {

  @Test
  @Order(1)
  void shouldReturnThePersistedActivity() {
    ActivityService activityService = new ActivityService();
    Activity expected =new Activity();
    expected.setTitle("Saiid");
    expected.setState(State.ACTIVE);
    expected.setActivityType(ActivityType.FORMATION);
    assertEquals(expected, activityService.add(expected));
  }

 

}
