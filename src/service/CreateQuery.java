package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateQuery
 */
@WebServlet("/CreateQuery")
public class CreateQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String api_key = "122634bf8fbf4add88ee80ade62f6d8d";
		Boolean set = false;
		String q = request.getParameter("q");
		String fq = request.getParameter("fq");
		String begin_date = request.getParameter("begin_date");
		String end_date = request.getParameter("end_date");
		String fl = request.getParameter("fl");
		String hl = request.getParameter("hl");
		String page = request.getParameter("page");
		String facet_field = request.getParameter("facet_field");
	    //String facet_filter =request.getParameter("facet_filter");
		
		String query = "http://api.nytimes.com/svc/search/v2/articlesearch.json?";
		if(q!="") {
			query += "q="+q;
			set = true;
		}
		
		if(fq!=""&&set==true)
			query += "&fq="+fq;
		else if(fq!=""&&set==false) {
			query += "fq="+fq;
			set = true;
		}
		
		if(begin_date!=""&&set==true)
			query += "&begin_date="+begin_date;
		else if(begin_date!=""&&set==false) {
			query += "begin_date="+begin_date;
			set = true;
			
		}
		if(end_date!=""&&set==true)
			query += "&end_date="+end_date;
		else if(end_date!=""&&set==false) {
			query += "end_date="+end_date;
			set = true;
		}
		
		if(fl!=""&&set==true)
			query += "&fl="+fl;
		else if(fl!=""&&set==false) {
			query += "fl="+fl;
			set = true;
		}
		
		if(hl!=""&&set==true)
			query += "&hl="+hl;
		else if(hl!=""&&set==false) {
			query += "hl="+hl;
			set = true;
		}
		
		if(page!=""&&set==true)
			query += "&page="+page;
		else if(page!=""&&set==false) {
			query += "page="+page;
			set = true;
		}
		
		if(facet_field!=""&&set==true)
			query += "&facet_field="+facet_field;
		else if(facet_field!=""&&set==false) {
			query += "facet_field="+facet_field;
			set = true;
		}
		
		/*if(fq!=""&&set==true)
			query += "&facet_filter="+facet_filter;
		else if(facet_filter!=""&&set==false) {
			query += "facet_filter="+facet_filter;
			set = true;
		}*/
		
		if(set==true) {
			query += "&api-key=" + api_key;
		}
		
		session.setAttribute("query", query);
		request.getRequestDispatcher("/JSONReceive").forward(request, response);
		
	System.out.println(query);
	}

}
