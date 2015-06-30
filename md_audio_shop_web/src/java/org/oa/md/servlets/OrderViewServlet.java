
package org.oa.md.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.oa.md.dao.DaoFacade;
import org.oa.md.data.Order;


public class OrderViewServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DaoFacade facade = new DaoFacade(getServletContext());
        List<Order> orders = facade.getOrderDao().loadAll();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Order</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Order</h1>");
            out.println("<table border=\"1\" style=\"width:100%\">");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>ORDER STATUS</th>");
            out.println("<th>ORDER DATE</th>");
            out.println("<th>MANAGER NAME</th>");
            out.println("<th>CUSTOMER</th>");
            out.println("<th>SHIPPING ADDRESS</th>");
            out.println("<th>PRICE</th>");
            out.println("</tr>");
            for (Order order : orders) {
                out.println("<tr>");
                out.println("<td>" + order.getId() + "</td>");
                out.println("<td>" + order.getOrderStatus() + "</td>");
                out.println("<td>" + order.getOrderDate() + "</td>");
                out.println("<td>" + order.getManagerName() + "</td>");
                out.println("<td>" + order.getCustomer() + "</td>");
                out.println("<td>" + order.getShippingAddress() + "</td>");
                out.println("<td>" + order.getPrice() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<a href=\"orders.jsp\">Edit orders</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
