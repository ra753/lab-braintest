package controller;
import service.PersonalityCalculator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns= {"/personality"})
public class PersonalityViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PersonalityViewController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entering do get");
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/personalityView.jsp");
		rd.forward(request, response);
	}

	// create an object for the PersonalityCalculator
	// call the findYourBrainType method using the object created above and pass options as argument.
	// The value returned from the method is of type string.
	// Store the String returned in a string literal called as message
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String options=request.getParameter("selectedOptions");
		
		System.out.println(options);
		
		PersonalityCalculator p = new PersonalityCalculator();
		String message = p.findYourBrainType(options);
		
				

		request.setAttribute("message", message);
		
		if(message!=null)
		{
			if(message.equals("rightbrained")) {
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/rightBrainView.jsp");
				rd.forward(request, response);
			}
			else if(message.equals("leftbrained")) {
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/leftBrainView.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/neutralView.jsp");
				rd.forward(request, response);
			}
		
		}
		}
}
	


