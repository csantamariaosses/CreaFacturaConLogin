package cl.csantam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Logout() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			// invalida sesion
			HttpSession sesion = request.getSession();
	        sesion.invalidate();
	       
        	
        	String _msgInfo_ = "Ha cerrado sesion correctamente";
        	request.setAttribute("_msgInfo_", _msgInfo_);
       
        	request.getRequestDispatcher("index.jsp").forward(request, response);
        	/*
	        out.println("<script type='text/javascript'>");
	        out.println("alert('Ha cerrado sesion correctamente');");
	        out.println("location='index.jsp';");
	        out.println("</script>");
	        */
		} catch( Exception ex) {
			out.println("<script type='text/javascript'>");
	        out.println("alert('Ha ocurrido un error al intentar cerrar la sesion.');");
	        out.println("location='index.jsp';");
	        out.println("</script>");
			
		}
        	 
	}
}
