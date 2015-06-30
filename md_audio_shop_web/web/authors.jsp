<%@page import="org.oa.md.dao.DaoFacade" %>
<%@page import="java.util.List" %>
<%@page import="org.oa.md.data.Author" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Authors</title>
</head>
<body>
<%
    DaoFacade facade = new DaoFacade(request.getServletContext());
    List<Author> items = facade.getAuthorDao().loadAll();
%>

<h1>Authors</h1>
<table border=1>
    <tr>
        <th>ID</th>
        <th>FIRST NAME</th>
        <th>LAST NAME</th>
        <th>AGE</th>
        <th>GENDER</th>
        <th>UPDATE</th>
        <th>DELETE</th>
    </tr>
    <% for (Author item : items) {%>
    <tr>
        <td>
            <%= item.getId()%>
        </td>
        <td>
            <%= item.getFirstName()%>
        </td>
        <td>
            <%= item.getLastName()%>
        </td>
        <td>
            <%= item.getAge()%>
        </td>
        <td>
            <%= item.getGender()%>
        </td>
        <td>
            <a href="edit_author.jsp?id=<%= item.getId()%>">UPDATE</a>
        </td>
        <td>
            <a href="authors?method=delete&id=<%=item.getId()%>">DELETE</a>
        </td>
    </tr>

    <% }%>
</table>
<br/>
<a href="edit_author.jsp"> CREATE </a>

</body>
</html>