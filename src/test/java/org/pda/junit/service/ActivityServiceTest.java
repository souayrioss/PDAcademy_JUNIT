package org.pda.junit.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.pda.junit.entity.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

  @Test
  @Order(3)
  void shouldGetActivity() throws ParseException {
    ActivityService activityService = new ActivityService();
    Activity expected = new Activity();
    expected.setTitle("whoami");
    expected.setId(7L);
    expected.setDescription("description");
    expected.setState(State.ACTIVE);
    expected.setActivityType(ActivityType.TALK);
    //assertNotSame(expected, activityService.getAll());
    assertEquals(expected,activityService.find(7));
  }
  @Test
  @Disabled
  void shouldGetCountActivity() throws ParseException {
    ActivityService activityService = new ActivityService();
    //assertNotSame(expected, activityService.getAll());
    assertEquals(2,activityService.getCount());
  }
  @Test
  @Disabled
  void shouldUpdateActivity() throws ParseException {
    ActivityService activityService = new ActivityService();

    //assertNotSame(expected, activityService.getAll());
    Responsible responsible = new Responsible();
    responsible.setFirstName("aaaaaa");
    responsible.setLastName("bbbbbbb");
    Exercise exercise = new Exercise();
    exercise.setTitle("eeeeeeeeeecc");
    Activity expected =new Activity();
    expected.setId(7L);
    expected.setTitle("Jdida");
    expected.setState(State.DESACTIVE);
    expected.setActivityType(ActivityType.TALK);
    expected.setDescription("azertyuzz");
    expected.setResponsible(responsible);
    List<Exercise> exerciseList = new ArrayList<>();
    exerciseList.add(exercise);
    expected.setExercises(exerciseList);

    assertEquals(expected, activityService.update(expected));
  }


}
