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

  @Test
  @Order(2)
  void shouldGetAListOfActivities() throws ParseException {
    ActivityService activityService = new ActivityService();
    List<Activity> expected = new ArrayList<>();
    Activity act1 =new Activity();
    act1.setTitle("whoami");
    act1.setId(7L);
    act1.setDescription("description");
    act1.setState(State.ACTIVE);
    act1.setActivityType(ActivityType.TALK);
    Activity act2 =new Activity();
    act2.setTitle("Saiid");
    act2.setId(8L);
    act2.setState(State.ACTIVE);
    act2.setActivityType(ActivityType.FORMATION);
    expected.add(act1);
    expected.add(act2);
    //assertNotSame(expected, activityService.getAll());
    assertEquals(expected,activityService.getAll());
  }




}
