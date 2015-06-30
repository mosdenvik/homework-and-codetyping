<%@page import="org.oa.md.dao.DaoFacade" %>
<%@page import="org.oa.md.data.Author" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit author</title>
</head>
<body>
<h1>Edit author</h1>

<form action="authors" method="POST">
    <%
        String id = request.getParameter("id");
        if (id == null) {%>

    <input type="hidden" name="method" value="create"/>
    First name:
    <input type="text" name="firstName"><br><br>
    Last name:
    <input type="text" name="lastName"><br><br>
    Age:
    <input type="text" name="age"><br><br>
    Gender:
    <input type="text" name="gender"><br><br>
    

    <% } else {
        DaoFacade daoFacade = new DaoFacade(request.getServletContext());
        Author author = daoFacade.getAuthorDao().findById(Long.parseLong(id));
    %>
    <input type="hidden" name="method" value="update"/>
    Id:
    <input type="text" name="id" value="<%=author.getId()%>"><br><br>
    First name:
    <input type="text" name="firstName" value="<%=author.getFirstName()%>"><br><br>
    Last name:
    <input type="text" name="lastName" value="<%=author.getLastName()%>"><br><br>
    Age:
    <input type="text" name="age" value="<%=author.getAge()%>"><br><br>
    Gender:
    <input type="text" name="gender" value="<%=author.getGender()%>"><br><br>

    <% } %>
    <input type="submit" value="Save">
</form>
</body>
</html>