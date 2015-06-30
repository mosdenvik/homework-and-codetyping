<%@page import="org.oa.md.dao.DaoFacade" %>
<%@page import="org.oa.md.data.Album" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit album</title>
</head>
<body>
<h1>Edit album</h1>

<form action="albums" method="POST">
    <%
        String id = request.getParameter("id");
        if (id == null) {%>

    <input type="hidden" name="method" value="create"/>
    Name:
    <input type="text" name="name"><br><br>
    Year:
    <input type="text" name="year"><br><br>

    <% } else {
        DaoFacade daoFacade = new DaoFacade(request.getServletContext());
        Album album = daoFacade.getAlbumDao().findById(Long.parseLong(id));
    %>
    <input type="hidden" name="method" value="update"/>
    Id:
    <input type="text" name="id" value="<%=album.getId()%>"><br><br>
    Name:
    <input type="text" name="name" value="<%=album.getName()%>"><br><br>
    Year:
    <input type="text" name="year" value="<%=album.getYear()%>"><br><br>

    <% } %>
    <input type="submit" value="Save">
</form>
</body>
</html>