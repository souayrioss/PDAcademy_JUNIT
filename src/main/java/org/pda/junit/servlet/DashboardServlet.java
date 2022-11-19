package org.pda.junit.servlet;

import java.io.*;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.pda.junit.entity.Activity;
import org.pda.junit.entity.Exercise;
import org.pda.junit.entity.Participant;
import org.pda.junit.service.*;

@WebServlet(name = "dashboardServlet", value = "/dashboard")
public class DashboardServlet extends HttpServlet {
  IFilterService<Activity> filterActService;
  IFilterService<Exercise> filterExeService;
  IFilterService<Participant> filterParService;
  ICRUDService<Activity> activityGetAll;
  public void init(){
    filterActService = new ActivityService();
    activityGetAll = new ActivityService();
    filterExeService = new ExerciseService();
    filterParService = new ParticipantService();
  }


  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    HttpSession session = request.getSession(false);
    if (session == null) {
      request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    long countActivity = filterActService.getCount();
    List<Activity> activities = activityGetAll.getAll();
    long countExercise = filterExeService.getCount();
    long countParticipant = filterParService.getCount();
    request.setAttribute("countActivity", countActivity);
    request.setAttribute("countExercise", countExercise);
    request.setAttribute("countParticipant", countParticipant);
    request.setAttribute("activities", activities);
    Date today = new Date();
    request.setAttribute("today", today);
    this.getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);
  }

  public void destroy() {
  }
}
