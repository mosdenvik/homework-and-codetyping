<%@page import="org.oa.md.dao.DaoFacade" %>
<%@page import="java.util.List" %>
<%@page import="org.oa.md.data.Order" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Orders</title>
</head>
<body>
<%
    DaoFacade facade = new DaoFacade(request.getServletContext());
    List<Order> items = facade.getOrderDao().loadAll();
%>

<h1>Orders</h1>
<table border=1>
    <tr>
        <th>ID</th>
        <th>ORDER STATUS</th>
        <th>ORDER DATE</th>
        <th>MANAGER NAME</th>
        <th>CUSTOMER</th>
        <th>SHIPPING ADDRESS</th>
        <th>PRICE</th>
        <th>UPDATE</th>
        <th>DELETE</th>
    </tr>
    <% for (Order item : items) {%>
    <tr>
        <td>
            <%= item.getId()%>
        </td>
        <td>
            <%= item.getOrderStatus()%>
        </td>
        <td>
            <%= item.getOrderDate()%>
        </td>
        <td>
            <%= item.getManagerName()%>
        </td>
        <td>
            <%= item.getCustomer()%>
        </td>
        <td>
            <%= item.getShippingAddress()%>
        </td>
        <td>
            <%= item.getPrice()%>
        </td>
        <td>
            <a href="edit_order.jsp?id=<%= item.getId()%>">UPDATE</a>
        </td>
        <td>
            <a href="orders?method=delete&id=<%=item.getId()%>">DELETE</a>
        </td>
    </tr>

    <% }%>
</table>
<br/>
<a href="edit_order.jsp"> CREATE </a>

</body>
</html>