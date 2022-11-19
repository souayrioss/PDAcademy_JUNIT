package org.pda.junit.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.pda.junit.entity.*;
import org.pda.junit.service.ICRUDService;
import org.pda.junit.service.ResponsibleService;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@WebServlet(name = "ResponsibleServlet", urlPatterns = {"/responsibles", "/create-responsible", "/insert-responsible", "/update-responsible", "/edit-responsible", "/delete-responsible"})
public class ResponsibleServlet extends HttpServlet {
  ICRUDService<Responsible> responsibleService;
  public void init(){
    responsibleService = new ResponsibleService();
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
        case "/create-responsible":
          createForm(request, response);
          break;
        case "/insert-responsible":
          storeResponsible(request, response);
          break;
        case "/edit-responsible":
          editForm(request, response);
          break;
        case "/update-responsible":
          updateResponsible(request, response);
          break;
        case "/delete-responsible":
          deleteResponsible(request, response);
          break;
        case "/responsibles":
          listResponsibles(request, response);
          break;
      }
    } catch (SQLException | ParseException ex) {
      throw  new ServletException();
    }
  }

  private void createForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException, ServletException, IOException {
    // gender, state, type, role
    request.setAttribute("states", State.values());
    request.setAttribute("genders", Gender.values());
    request.setAttribute("role", Role.RESPONSIBLE);
    request.setAttribute("types", ResponsibleType.values());
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/responsibles/create.jsp");
    dispatcher.forward(request, response);
  }

  private void storeResponsible(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Responsible responsible = new Responsible();
    responsible.setFirstName(request.getParameter("first-name"));
    responsible.setLastName(request.getParameter("last-name"));
    responsible.setPhoneNumber(request.getParameter("phone-number"));
    responsible.setDomain(request.getParameter("domain"));
    responsible.setGender(Gender.valueOf(request.getParameter("gender")));
    responsible.setResponsibleType(ResponsibleType.valueOf(request.getParameter("responsible-type")));
    responsible.setState(State.valueOf(request.getParameter("state")));
    responsible.setRole(Role.RESPONSIBLE);
    responsibleService.add(responsible);
    response.sendRedirect("responsibles");
  }

  private void editForm(HttpServletRequest request, HttpServletResponse response) {

  }

  private void updateResponsible(HttpServletRequest request, HttpServletResponse response) {

  }

  private void deleteResponsible(HttpServletRequest request, HttpServletResponse response) {

  }

  private void listResponsibles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Responsible> responsibleList = responsibleService.getAll();
    request.setAttribute("responsibles", responsibleList);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/responsibles/index.jsp");
    dispatcher.forward(request, response);
  }
}
