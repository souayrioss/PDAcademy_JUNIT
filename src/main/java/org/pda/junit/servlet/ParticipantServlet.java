package org.pda.junit.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.pda.junit.entity.*;
import org.pda.junit.service.ICRUDService;
import org.pda.junit.service.ParticipantService;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@WebServlet(name = "ParticipantServlet", urlPatterns = {"/participants", "/create-participant", "/insert-participant", "/update-participant", "/edit-participant", "/delete-participant"})
public class ParticipantServlet extends HttpServlet {
  ICRUDService<Participant> participantService;

  @Override
  public void init() throws ServletException {
    participantService = new ParticipantService();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getServletPath();
    try{
      switch (action){
        case "/create-participant":
          createForm(request, response);
          break;
        case "/insert-participant":
          storeParticipant(request, response);
          break;
        case "/edit-participant":
          editForm(request, response);
          break;
        case "/update-participant":
          updateParticipant(request, response);
          break;
        case "/delete-participant":
          deleteParticipant(request, response);
          break;
        case "/participants":
          listParticipants(request, response);
          break;
      }
    } catch (SQLException | ParseException ex) {
      throw  new ServletException();
    }
  }

  private void listParticipants(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
    request.setAttribute("participants", participantService.getAll());
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/participants/index.jsp");
    dispatcher.forward(request, response);
  }

  private void deleteParticipant(HttpServletRequest request, HttpServletResponse response) {

  }

  private void updateParticipant(HttpServletRequest request, HttpServletResponse response) {

  }

  private void editForm(HttpServletRequest request, HttpServletResponse response) {

  }

  private void storeParticipant(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Participant participant = new Participant();
    participant.setFirstName(request.getParameter("first-name"));
    participant.setLastName(request.getParameter("last-name"));
    participant.setEmail(request.getParameter("email"));
    participant.setPhoneNumber(request.getParameter("phone-number"));
    participant.setRole(Role.PARTICIPANT);
    participant.setDomain(request.getParameter("domain"));
    participant.setStructure(request.getParameter("structure"));
    participant.setGender(Gender.valueOf(request.getParameter("gender")));
    participantService.add(participant);
    response.sendRedirect("participants");
  }

  private void createForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("genders", Gender.values());
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/participants/create.jsp");
    dispatcher.forward(request, response);
  }


}
