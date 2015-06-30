
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
import org.oa.md.data.Author;



public class AuthorsServiceServlet extends HttpServlet {

    private static final String PARAMETER_METHOD = "method";
    private static final String PARAMETER_ID = "id";
    private static final String PARAMETER_FIRST_NAME = "firstName";
    private static final String PARAMETER_LAST_NAME = "lastName";
    private static final String PARAMETER_AGE = "age";
    private static final String PARAMETER_GENDER = "gender";
    
    private static final String GET_ALL_METHOD = "get";
    private static final String CREATE_METHOD = "create";
    private static final String DELETE_METHOD = "delete";
    private static final String UPDATE_METHOD = "update";
    
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String queryMethod = request.getParameter(PARAMETER_METHOD);

        System.out.println("method " + queryMethod);
        DaoFacade facade = new DaoFacade(getServletContext());
        
        if (GET_ALL_METHOD.equalsIgnoreCase(queryMethod)) {
            List<Author> authors = facade.getAuthorDao().loadAll();
            try (PrintWriter out = response.getWriter()) {
                Gson gson = new Gson();
                gson.toJson(authors, out);
            }
            response.setStatus(HttpServletResponse.SC_OK);
        }  else if (DELETE_METHOD.equalsIgnoreCase(queryMethod)) {
            String idString = request.getParameter(PARAMETER_ID);
            long id = Long.parseLong(idString);
            boolean deleted = facade.getAuthorDao().delete(id);
            try (PrintWriter out = response.getWriter()) {
                if (deleted) {
                    response.setStatus(HttpServletResponse.SC_OK);
                    out.print("{\"response\":\"Author deleted\"}");
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    out.print("{\"error\":\"Failed delete author\"}");
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
        DaoFacade facade = new DaoFacade(getServletContext());
        if (CREATE_METHOD.equalsIgnoreCase(queryMethod)) {
            String firstNameString = request.getParameter(PARAMETER_FIRST_NAME);
            String lastNameString = request.getParameter(PARAMETER_LAST_NAME);
            String ageString = request.getParameter(PARAMETER_AGE);
            int age = Integer.parseInt(ageString);
            String genderString = request.getParameter(PARAMETER_GENDER);
            Author author = new Author(firstNameString, lastNameString, age, genderString);
            boolean created = facade.getAuthorDao().add(author);
            try (PrintWriter out = response.getWriter()) {
                if (created) {
                    response.setStatus(HttpServletResponse.SC_OK);
                    out.print("{\"response\":\"Author created\"}");
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    out.print("{\"error\":\"Failed create author\"}");
                }
            }
        } else if (UPDATE_METHOD.equalsIgnoreCase(queryMethod)) {
            String idString = request.getParameter(PARAMETER_ID);
            String firstNameString = request.getParameter(PARAMETER_FIRST_NAME);
            String lastNameString = request.getParameter(PARAMETER_LAST_NAME);
            String ageString = request.getParameter(PARAMETER_AGE);
            int age = Integer.parseInt(ageString);
            String genderString = request.getParameter(PARAMETER_GENDER);   
            long id = Long.parseLong(idString);
            Author author = new Author(id, firstNameString, lastNameString, age, genderString);
            boolean updated = facade.getAuthorDao().update(author);
            try (PrintWriter out = response.getWriter()) {
                if (updated) {
                    response.setStatus(HttpServletResponse.SC_OK);
                    out.print("{\"response\":\"Author updated\"}");
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    out.print("{\"error\":\"Failed update author\"}");
                }
            }
        }else {
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
