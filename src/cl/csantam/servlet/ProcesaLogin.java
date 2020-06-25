package cl.csantam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/procesaLogin")
public class ProcesaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcesaLogin() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 final String LOGIN = "usuario";
         final String  PASS = "admin";
		    
		
		 PrintWriter out = response.getWriter();
	 
		 String requestLogin = request.getParameter("login");
		 String requestPass = request.getParameter("pass");
		 
		 boolean usuarioOk = requestLogin.equals( LOGIN );
	     boolean passwordOk = requestPass.equals( PASS );

        if (usuarioOk && passwordOk) {
            // creamos la sesion si el usuario existe
            HttpSession sesionUsuario = request.getSession(true);
            sesionUsuario.setAttribute("nombreSesion", requestLogin);
            
            // pasa la variable de sesion a una variable
            //String usuarioSesion = (String) sesionUsuario.getAttribute("nombreSesion");
            //request.setAttribute("nombreSesion", usuarioSesion);
            
            RequestDispatcher rd = request.getRequestDispatcher("IngresoValores.jsp");
            rd.forward(request, response);

        } else {

        	String _msgError_ = "Usuario o password incorrecto, favor reintentar...";
        	request.setAttribute("_msgError_", _msgError_);
       
        	request.getRequestDispatcher("index.jsp").forward(request, response);
        	
        	/*
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Usuario o password incorrecto, favor reintentar...');");
            out.println("location='index.jsp';");
            out.println("</script>");
            */

        } 
		 
	}

}
