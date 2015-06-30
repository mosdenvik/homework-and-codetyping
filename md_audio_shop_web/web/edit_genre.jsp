<%@page import="org.oa.md.dao.DaoFacade" %>
<%@page import="org.oa.md.data.Genre" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit genre</title>
</head>
<body>
<h1>Edit genre</h1>

<form action="genres" method="POST">
    <%
        String id = request.getParameter("id");
        if (id == null) {%>

    <input type="hidden" name="method" value="create"/>
    Name:
    <input type="text" name="name"><br><br>
    <% } else {
        DaoFacade daoFacade = new DaoFacade(request.getServletContext());
        Genre genre = daoFacade.getGenreDao().findById(Long.parseLong(id));
    %>
    <input type="hidden" name="method" value="update"/>
    Id:
    <input type="text" name="id" value="<%=genre.getId()%>"><br><br>
    Name:
    <input type="text" name="name" value="<%=genre.getName()%>"><br><br>
    <% } %>
    <input type="submit" value="Save">
</form>
</body>
</html>