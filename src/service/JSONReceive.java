package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.javafx.scene.paint.GradientUtils.Parser;
import com.sun.xml.internal.ws.transport.http.client.HttpClientTransport;

import bean.ArticleInfo;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
/**
 * Servlet implementation class JSONReceive
 */
@WebServlet("/JSONReceive")
public class JSONReceive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONReceive() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		List<ArticleInfo> articleInfos = new ArrayList<ArticleInfo>();
		String query = (String) session.getAttribute("query");
		
		HttpClient httpClient =HttpClients.createDefault();
		HttpGet get = new HttpGet(query);
		HttpResponse jsonRseponse = httpClient.execute(get);
		HttpEntity entity = jsonRseponse.getEntity();
		String jsonString = EntityUtils.toString(entity);
		
		System.out.println(jsonString);
		JSONObject jsonobj = JSONObject.fromObject(jsonString);
		JSONObject responseobj =JSONObject.fromObject(jsonobj.get("response"));
		JSONArray info =  jsonobj.getJSONObject("response").getJSONArray("docs");
		//docs	-->web_url;
		//		-->pub_date
		//		-->document_type;
		//		-->headline-->main;
		int size = info.size(); 
		for(int i = 0; i < info.size(); i++) {
			ArticleInfo artin = new ArticleInfo();
			JSONObject doc = JSONObject.fromObject(info.getString(i)) ;
			artin.setWeb_url(doc.get("web_url").toString());
			if(doc.has("pub_date"))
				artin.setPub_date(doc.get("pub_date").toString());
			artin.setDocument_type(doc.get("document_type").toString());
			JSONObject headline = JSONObject.fromObject(doc.get("headline"));
			artin.setMain(headline.get("main").toString());
			articleInfos.add(artin);
		}
		session.setAttribute("articleInfos", articleInfos);
		request.getRequestDispatcher("/DateInsert").forward(request, response);
	}

}
