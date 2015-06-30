<%@page import="org.oa.md.dao.DaoFacade" %>
<%@page import="java.util.List" %>
<%@page import="org.oa.md.data.AudioTrack" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Audiotracks</title>
</head>
<body>
<%
    DaoFacade facade = new DaoFacade(request.getServletContext());
    List<AudioTrack> items = facade.getAudioTrackDao().loadAll();
%>

<h1>Audiotracks</h1>
<table border=1>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>AUTHOR ID</th>
        <th>DURATION</th>
        <th>PRICE</th>
        <th>GENRE ID</th>
        <th>UPDATE</th>
        <th>DELETE</th>
    </tr>
    <% for (AudioTrack item : items) {%>
    <tr>
        <td>
            <%= item.getId()%>
        </td>
        <td>
            <%= item.getName()%>
        </td>
        <td>
            <%= item.getAuthorId()%>
        </td>
        <td>
            <%= item.getDuration()%>
        </td>
        <td>
            <%= item.getPrice()%>
        </td>
        <td>
            <%= item.getGenreId()%>
        </td>
        <td>
            <a href="edit_audiotrack.jsp?id=<%= item.getId()%>">UPDATE</a>
        </td>
        <td>
            <a href="audiotracks?method=delete&id=<%=item.getId()%>">DELETE</a>
        </td>
    </tr>

    <% }%>
</table>
<br/>
<a href="edit_audiotrack.jsp"> CREATE </a>

</body>
</html>