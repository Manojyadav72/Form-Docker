<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Student" %>

<!DOCTYPE html>

<html>

<head>

    <title>Students</title>

    <link rel="stylesheet"
          href="css/style.css">

</head>

<body>

<div class="container">

    <h1>Student List</h1>

    <a class="btn"
       href="students?action=new">
        Add Student
    </a>

    <br><br>

    <table>

        <tr>

            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Course</th>
            <th>Actions</th>

        </tr>

        <%
            List<Student> students =
                    (List<Student>)
                    request.getAttribute("students");

            for (Student student : students) {
        %>

        <tr>

            <td>
                <%= student.getId() %>
            </td>

            <td>
                <%= student.getName() %>
            </td>

            <td>
                <%= student.getEmail() %>
            </td>

            <td>
                <%= student.getCourse() %>
            </td>

            <td>

                <a class="edit"
                   href="students?action=edit&id=<%=student.getId()%>">
                    Edit
                </a>

                <a class="delete"
                   href="students?action=delete&id=<%=student.getId()%>"
                   onclick="return confirm('Delete this student?');">
                    Delete
                </a>

            </td>

        </tr>

        <%
            }
        %>

    </table>

</div>

</body>

</html>