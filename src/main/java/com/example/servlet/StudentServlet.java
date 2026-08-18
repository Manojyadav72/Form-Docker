package com.example.servlet;

import com.example.dao.StudentDAO;
import com.example.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    private StudentDAO dao;

    @Override
    public void init() {
        dao = new StudentDAO();
    }


    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {

            case "new":

                request.getRequestDispatcher(
                        "student-form.jsp"
                ).forward(request, response);

                break;


            case "edit":

                int editId =
                        Integer.parseInt(
                                request.getParameter("id")
                        );

                Student student =
                        dao.getStudent(editId);

                request.setAttribute(
                        "student",
                        student
                );

                request.getRequestDispatcher(
                        "student-form.jsp"
                ).forward(request, response);

                break;


            case "delete":

                int deleteId =
                        Integer.parseInt(
                                request.getParameter("id")
                        );

                dao.deleteStudent(deleteId);

                response.sendRedirect(
                        "students"
                );

                break;


            default:

                request.setAttribute(
                        "students",
                        dao.getAllStudents()
                );

                request.getRequestDispatcher(
                        "students.jsp"
                ).forward(request, response);
        }
    }


    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");

        String name =
                request.getParameter("name");

        String email =
                request.getParameter("email");

        String course =
                request.getParameter("course");


        Student student =
                new Student(
                        name,
                        email,
                        course
                );


        if (id == null || id.isEmpty()) {

            dao.insertStudent(student);

        } else {

            student.setId(
                    Integer.parseInt(id)
            );

            dao.updateStudent(student);
        }

        response.sendRedirect(
                "students"
        );
    }
}