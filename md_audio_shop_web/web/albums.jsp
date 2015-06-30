<%@page import="org.oa.md.dao.DaoFacade" %>
<%@page import="java.util.List" %>
<%@page import="org.oa.md.data.Album" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Albums</title>
</head>
<body>
<%
    DaoFacade facade = new DaoFacade(request.getServletContext());
    List<Album> items = facade.getAlbumDao().loadAll();
%>

<h1>Albums</h1>
<table border=1>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>YEAR</th>
        <th>UPDATE</th>
        <th>DELETE</th>
    </tr>
    <% for (Album item : items) {%>
    <tr>
        <td>
            <%= item.getId()%>
        </td>
        <td>
            <%= item.getName()%>
        </td>
        <td>
            <%= item.getYear()%>
        </td>
        <td>
            <a href="edit_album.jsp?id=<%= item.getId()%>">UPDATE</a>
        </td>
        <td>
            <a href="albums?method=delete&id=<%=item.getId()%>">DELETE</a>
        </td>
    </tr>

    <% }%>
</table>
<br/>
<a href="edit_album.jsp"> CREATE </a>

</body>
</html>