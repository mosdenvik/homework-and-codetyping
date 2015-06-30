<%@page import="org.oa.md.dao.DaoFacade" %>
<%@page import="org.oa.md.data.Order" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit order</title>
</head>
<body>
<h1>Edit order</h1>

<form action="orders" method="POST">
    <%
        String id = request.getParameter("id");
        if (id == null) {%>

    <input type="hidden" name="method" value="create"/>
    Order status:
    <input type="text" name="orderStatus"><br><br>
    Order date:
    <input type="text" name="orderDate"><br><br>
    Manager name:
    <input type="text" name="managerName"><br><br>
    Customer:
    <input type="text" name="customer"><br><br>
    Shipping address:
    <input type="text" name="shippingAddress"><br><br>
    Price:
    <input type="text" name="price"><br><br>

    <% } else {
        DaoFacade daoFacade = new DaoFacade(request.getServletContext());
        Order order = daoFacade.getOrderDao().findById(Long.parseLong(id));
    %>
    <input type="hidden" name="method" value="update"/>
    Id:
    <input type="text" name="id" value="<%=order.getId()%>"><br><br>
    Order status:
    <input type="text" name="orderStatus" value="<%=order.getOrderStatus()%>"><br><br>
    Order date:
    <input type="text" name="orderDate" value="<%=order.getOrderDate()%>"><br><br>
    Manager name:
    <input type="text" name="managerName" value="<%=order.getManagerName()%>"><br><br>
    Customer:
    <input type="text" name="customer" value="<%=order.getCustomer()%>"><br><br>
    Shipping address:
    <input type="text" name="shippingAddress" value="<%=order.getShippingAddress()%>"><br><br>
    Price:
    <input type="text" name="price" value="<%=order.getPrice()%>"><br><br>

    <% } %>
    <input type="submit" value="Save">
</form>
</body>
</html>