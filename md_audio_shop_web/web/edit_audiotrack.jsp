<%@page import="org.oa.md.dao.DaoFacade" %>
<%@page import="org.oa.md.data.AudioTrack" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit audiotrack</title>
</head>
<body>
<h1>Edit audiotrack</h1>

<form action="audiotracks" method="POST">
    <%
        String id = request.getParameter("id");
        if (id == null) {%>

    <input type="hidden" name="method" value="create"/>
    Name:
    <input type="text" name="name"><br><br>
    Author ID:
    <input type="text" name="authorId"><br><br>
    Duration:
    <input type="text" name="duration"><br><br>
    Price:
    <input type="text" name="price"><br><br>
    Genre ID:
    <input type="text" name="genreId"><br><br>
    

    <% } else {
        DaoFacade daoFacade = new DaoFacade(request.getServletContext());
        AudioTrack audiotrack = daoFacade.getAudioTrackDao().findById(Long.parseLong(id));
    %>
    <input type="hidden" name="method" value="update"/>
    Id:
    <input type="text" name="id" value="<%=audiotrack.getId()%>"><br><br>
    Name:
    <input type="text" name="name" value="<%=audiotrack.getName()%>"><br><br>
    Author iD:
    <input type="text" name="authorId" value="<%=audiotrack.getAuthorId()%>"><br><br>
    Duration:
    <input type="text" name="duration" value="<%=audiotrack.getDuration()%>"><br><br>
    Price:
    <input type="text" name="price" value="<%=audiotrack.getPrice()%>"><br><br>
    Genre ID:
    <input type="text" name="genreId" value="<%=audiotrack.getGenreId()%>"><br><br>

    <% } %>
    <input type="submit" value="Save">
</form>
</body>
</html>