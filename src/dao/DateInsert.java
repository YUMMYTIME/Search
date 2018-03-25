package dao;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import bean.ArticleInfo;
/**
 * Servlet implementation class DateInsert
 */
@WebServlet("/DateInsert")
public class DateInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		List<ArticleInfo> articleInfos = (ArrayList<ArticleInfo>)session.getAttribute("articleInfos");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url	= "jdbc:mysql://localhost:3306/Search";
			for(ArticleInfo artin: articleInfos) {
				try {
			    Connection connection = (Connection) DriverManager.getConnection(url,"root","root");					
			    Statement statement = connection.createStatement();
				String sql = "insert into article-db VALUES ('"+artin.getWeb_url()+"','"+artin.getMain()+"','"+artin.getDocument_type()+"','"+artin.getPub_date()+"')";
				int result = statement.executeUpdate(sql);
				System.out.println(result);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException e)
	    {
	        System.out.print("NullPointerException Caught");
	    }
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
