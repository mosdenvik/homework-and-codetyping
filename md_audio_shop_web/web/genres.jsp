<%@page import="org.oa.md.dao.DaoFacade" %>
<%@page import="java.util.List" %>
<%@page import="org.oa.md.data.Genre" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Genres</title>
</head>
<body>
<%
    DaoFacade facade = new DaoFacade(request.getServletContext());
    List<Genre> items = facade.getGenreDao().loadAll();
%>

<h1>Genres</h1>
<table border=1>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>UPDATE</th>
        <th>DELETE</th>
    </tr>
    <% for (Genre item : items) {%>
    <tr>
        <td>
            <%= item.getId()%>
        </td>
        <td>
            <%= item.getName()%>
        </td>
        <td>
            <a href="edit_genre.jsp?id=<%= item.getId()%>">UPDATE</a>
        </td>
        <td>
            <a href="genres?method=delete&id=<%=item.getId()%>">DELETE</a>
        </td>
    </tr>

    <% }%>
</table>
<br/>
<a href="edit_genre.jsp"> CREATE </a>

</body>
</html>
