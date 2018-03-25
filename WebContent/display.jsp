<%@ page import="bean.ArticleInfo"%>
<%@ page import="service.CreateQuery"%>
<%@ page import="service.JSONReceive"%>
<%@ page import="dao.DateInsert"%>
<%@ page import="java.util.ArrayList" import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New York Times Article Search</title>
</head>
<body>
<%
    List<ArticleInfo> articleInfos = (ArrayList<ArticleInfo>)session.getAttribute("articleInfos");
	out.write("<table border=\"2\" cellpadding=\"2\">");
	out.write("<td>Title</td>"+"<td>Doc_Type</td>"+"<td>Date</td>");
	try{
	for(ArticleInfo artin: articleInfos){
		String date ="";
		if(artin.getPub_date()!=null){
			date=artin.getPub_date();
		}else{
			date="Unknow";
		}
	    out.write("<tr>");
		out.write("<td><a target=\"_blank\" href=\"" + artin.getWeb_url()+"\">"+artin.getMain()+"</a>"+"</td>");
		out.write("<td>"+artin.getDocument_type()+"</td>"+"<td>"+date+"</td>");
		out.write("</tr>");
	}
	
	}
	catch(NullPointerException e)
    {
        System.out.println("NullPointerException Caught.");
    }

	
	
	out.write("</table>");

%>

</body>
</html>