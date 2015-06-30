
package org.oa.md.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.oa.md.dao.DaoFacade;
import org.oa.md.data.Order;


public class OrdersServiceServlet extends HttpServlet {

    private static final String PARAMETER_METHOD = "method";
    private static final String PARAMETER_ID = "id";
    private static final String PARAMETER_ORDER_STATUS = "orderStatus";
    private static final String PARAMETER_ORDER_DATE = "orderDate";
    private static final String PARAMETER_MANAGER_NAME = "managerName";
    private static final String PARAMETER_CUSTOMER = "customer";
    private static final String PARAMETER_SHIPPING_ADDRESS = "shippingAddress";
    private static final String PARAMETER_PRICE = "price";
    
    
    private static final String GET_ALL_METHOD = "get";
    private static final String CREATE_METHOD = "create";
    private static final String DELETE_METHOD = "delete";
    private static final String UPDATE_METHOD = "update";
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        final String queryMethod = request.getParameter(PARAMETER_METHOD);
        System.out.println("method " + queryMethod);
        response.setContentType("application/json;charset=UTF-8");
        DaoFacade facade = new DaoFacade(getServletContext());
        
        if (GET_ALL_METHOD.equalsIgnoreCase(queryMethod)) {
            List<Order> orders = facade.getOrderDao().loadAll();
            try (PrintWriter out = response.getWriter()) {
                Gson gson = new Gson();
                gson.toJson(orders, out);
            }
            response.setStatus(HttpServletResponse.SC_OK);
        } else if (DELETE_METHOD.equalsIgnoreCase(queryMethod)) {
            String idString = request.getParameter(PARAMETER_ID);
            long id = Long.parseLong(idString);
            boolean deleted = facade.getOrderDao().delete(id);
            try (PrintWriter out = response.getWriter()) {
                if (deleted) {
                    response.setStatus(HttpServletResponse.SC_OK);
                    out.print("{\"response\":\"Order deleted\"}");
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    out.print("{\"error\":\"Failed delete order\"}");
                }
            }
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            try (PrintWriter out = response.getWriter()) {
                out.print("{\"error\":\"Not found method\"}");
            }
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        final String queryMethod = request.getParameter(PARAMETER_METHOD);
        System.out.println("method " + queryMethod);
        response.setContentType("application/json;charset=UTF-8");
        DaoFacade facade = new DaoFacade(getServletContext());
        
            if (CREATE_METHOD.equalsIgnoreCase(queryMethod)) {
            String orderStatusString = request.getParameter(PARAMETER_ORDER_STATUS);
            String orderDateString = request.getParameter(PARAMETER_ORDER_DATE);
            String managerNameString = request.getParameter(PARAMETER_MANAGER_NAME);
            String customerString = request.getParameter(PARAMETER_CUSTOMER);
            String shippingAddressString = request.getParameter(PARAMETER_SHIPPING_ADDRESS);
            String priceString = request.getParameter(PARAMETER_PRICE);
            int price = Integer.parseInt(priceString);
            Order order = new Order(orderStatusString, orderDateString, managerNameString, customerString, shippingAddressString,  price);
            boolean created = facade.getOrderDao().add(order);
            try (PrintWriter out = response.getWriter()) {
                if (created) {
                    response.setStatus(HttpServletResponse.SC_OK);
                    out.print("{\"response\":\"Order created\"}");
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    out.print("{\"error\":\"Failed create order\"}");
                }
            }
        } else if (UPDATE_METHOD.equalsIgnoreCase(queryMethod)) {
            String idString = request.getParameter(PARAMETER_ID);
            long id = Long.parseLong(idString);
            String orderStatusString = request.getParameter(PARAMETER_ORDER_STATUS);
            String orderDateString = request.getParameter(PARAMETER_ORDER_DATE);
            String managerNameString = request.getParameter(PARAMETER_MANAGER_NAME);
            String customerString = request.getParameter(PARAMETER_CUSTOMER);
            String shippingAddressString = request.getParameter(PARAMETER_SHIPPING_ADDRESS);
            String priceString = request.getParameter(PARAMETER_PRICE);
            int price = Integer.parseInt(priceString);
            Order order = new Order(id, orderStatusString, orderDateString, managerNameString, customerString, shippingAddressString,  price);
            boolean updated = facade.getOrderDao().update(order);
            try (PrintWriter out = response.getWriter()) {
                if (updated) {
                    response.setStatus(HttpServletResponse.SC_OK);
                    out.print("{\"response\":\"Order updated\"}");
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    out.print("{\"error\":\"Failed update order\"}");
                }
            }
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            try (PrintWriter out = response.getWriter()) {
                out.print("{\"error\":\"Not found method\"}");
            }
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
