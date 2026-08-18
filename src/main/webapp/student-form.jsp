<%@ page import="com.example.model.Student" %>

<%
    Student student =
            (Student) request.getAttribute("student");

    boolean edit =
            student != null;
%>

<!DOCTYPE html>

<html>

<head>

    <title>
        <%= edit ? "Edit Student" : "Add Student" %>
    </title>

    <link rel="stylesheet"
          href="css/style.css">

</head>

<body>

<div class="container">

    <h1>
        <%= edit ? "Edit Student" : "Add Student" %>
    </h1>


    <form action="students"
          method="post">

        <% if (edit) { %>

            <input type="hidden"
                   name="id"
                   value="<%=student.getId()%>">

        <% } %>


        <label>Name</label>

        <input type="text"
               name="name"
               value="<%= edit ? student.getName() : "" %>"
               required>


        <label>Email</label>

        <input type="email"
               name="email"
               value="<%= edit ? student.getEmail() : "" %>"
               required>


        <label>Course</label>

        <input type="text"
               name="course"
               value="<%= edit ? student.getCourse() : "" %>"
               required>


        <button type="submit">
            <%= edit ? "Update Student" : "Save Student" %>
        </button>

    </form>


    <br>

    <a href="students">
        Back to Students
    </a>

</div>

</body>

</html>