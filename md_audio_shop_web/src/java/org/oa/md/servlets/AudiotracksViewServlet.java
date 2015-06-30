
package org.oa.md.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.oa.md.dao.DaoFacade;
import org.oa.md.data.AudioTrack;

public class AudiotracksViewServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DaoFacade facade = new DaoFacade(getServletContext());
        List<AudioTrack> audioTracks = facade.getAudioTrackDao().loadAll();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>AudioTracks</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>AudioTracks</h1>");
            out.println("<table border=\"1\" style=\"width:100%\">");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>NAME</th>");
            out.println("<th>AUTHOR ID</th>");
            out.println("<th>DURATION</th>");
            out.println("<th>PRICE</th>");
            out.println("<th>GENRE ID</th>");
            out.println("</tr>");
            for (AudioTrack audioTrack : audioTracks) {
                out.println("<tr>");
                out.println("<td>" + audioTrack.getId() + "</td>");
                out.println("<td>" + audioTrack.getName() + "</td>");
                out.println("<td>" + audioTrack.getAuthorId() + "</td>");
                out.println("<td>" + audioTrack.getDuration() + "</td>");
                out.println("<td>" + audioTrack.getPrice() + "</td>");
                out.println("<td>" + audioTrack.getGenreId() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<a href=\"audiotracks.jsp\">Edit audiotracks</a>");
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
