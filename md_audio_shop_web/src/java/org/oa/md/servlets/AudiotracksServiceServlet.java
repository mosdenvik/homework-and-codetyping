package org.oa.md.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.oa.md.dao.DaoFacade;
import org.oa.md.data.AudioTrack;



public class AudiotracksServiceServlet extends HttpServlet {

    private static final String PARAMETER_METHOD = "method";
    private static final String PARAMETER_ID = "id";
    private static final String PARAMETER_NAME = "name";
    private static final String PARAMETER_AUTHOR_ID = "authorId";
    private static final String PARAMETER_DURATION = "duration";
    private static final String PARAMETER_PRICE = "price";
    private static final String PARAMETER_GENRE_ID = "genreId";
    
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
            List<AudioTrack> audioTracks = facade.getAudioTrackDao().loadAll();
            try (PrintWriter out = response.getWriter()) {
                Gson gson = new Gson();
                gson.toJson(audioTracks, out);
            }
            response.setStatus(HttpServletResponse.SC_OK);
        } else if (DELETE_METHOD.equalsIgnoreCase(queryMethod)) {
            String idString = request.getParameter(PARAMETER_ID);
            long id = Long.parseLong(idString);
            boolean deleted = facade.getAudioTrackDao().delete(id);
            try (PrintWriter out = response.getWriter()) {
                if (deleted) {
                    response.setStatus(HttpServletResponse.SC_OK);
                    out.print("{\"response\":\"AudioTrack deleted\"}");
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    out.print("{\"error\":\"Failed delete audioTrack\"}");
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
            String nameString = request.getParameter(PARAMETER_NAME);
            String authorIdString = request.getParameter(PARAMETER_AUTHOR_ID);
            long authorId = Long.parseLong(authorIdString);
            String durationString = request.getParameter(PARAMETER_DURATION);
            Time duration = Time.valueOf(durationString);
            String priceString = request.getParameter(PARAMETER_PRICE);
            int price = Integer.parseInt(priceString);
            String genderIdString = request.getParameter(PARAMETER_GENRE_ID);
            long genreId = Long.parseLong(genderIdString);
            AudioTrack audioTrack = new AudioTrack(nameString, authorId, duration, price, genreId);
            boolean created = facade.getAudioTrackDao().add(audioTrack);
            try (PrintWriter out = response.getWriter()) {
                if (created) {
                    response.setStatus(HttpServletResponse.SC_OK);
                    out.print("{\"response\":\"AudioTrack created\"}");
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    out.print("{\"error\":\"Failed create audioTrack\"}");
                }
            }
        } else if (UPDATE_METHOD.equalsIgnoreCase(queryMethod)) {
            String idString = request.getParameter(PARAMETER_ID);
            long id = Long.parseLong(idString);
            String nameString = request.getParameter(PARAMETER_NAME);
            String authorIdString = request.getParameter(PARAMETER_AUTHOR_ID);
            long authorId = Long.parseLong(authorIdString);
            String durationString = request.getParameter(PARAMETER_DURATION);
            Time duration = Time.valueOf(durationString);
            String priceString = request.getParameter(PARAMETER_PRICE);
            int price = Integer.parseInt(priceString);
            String genreIdString = request.getParameter(PARAMETER_GENRE_ID);
            long genreId = Long.parseLong(genreIdString);
            AudioTrack audioTrack = new AudioTrack(id, nameString, authorId, duration, price, genreId);
            boolean updated = facade.getAudioTrackDao().update(audioTrack);
            try (PrintWriter out = response.getWriter()) {
                if (updated) {
                    response.setStatus(HttpServletResponse.SC_OK);
                    out.print("{\"response\":\"AudioTrack updated\"}");
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    out.print("{\"error\":\"Failed update audioTrack\"}");
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
