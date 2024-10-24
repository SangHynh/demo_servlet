package vn.edu.iuh.fit.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.dtos.Student;
import vn.edu.iuh.fit.models.StudentProcessing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Controller", value = "/controller")
public class ControllerServlet extends HttpServlet {
    @Inject
    private StudentProcessing processing;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equalsIgnoreCase("add")){
            String fullname = req.getParameter("fullname");
            String email = req.getParameter("email");

            processing.addStudent(fullname,email);
        }
        else if(action.equalsIgnoreCase("students")){
            List<Student> students = processing.listStudents();
            HttpSession session = req.getSession(true);
            session.setAttribute("students",students);
            resp.sendRedirect("views/list_all_students.jsp");
        }
        else if(action.equalsIgnoreCase("student_by_id")){

        }
        else if(action.equalsIgnoreCase("update")){

        }
        else if(action.equalsIgnoreCase("delete")){

        }
    }
}
