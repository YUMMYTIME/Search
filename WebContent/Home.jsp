<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New York Times Article Search</title>
	<style type="text/css">
	#aside{width: 30%; height:100%; float:left; }
	#include{width: 70%; height:100%; float:left;}
	</style>
</head>
<body style="height: 800px">
<div id ="aside">
		<div>
		<form action="CreateQuery" method="POST">
			q: <br/><input type="text" name="q" /><br/>
			fq: <br/><input type="text" name="fq" /><br/>
			begin_date: <br/><input type="text" name="begin_date" /><br/>
			end_date: <br/><input type="text" name="end_date" /><br/>
			fl: <br/><input type="text" name="fl" /><br/>
			hl: <br/><input type="text" name="hl" /><br/>
			page: <br/><input type="text" name="page" /><br/>
			facet_field: <br/><input type="text" name="facet_field" /><br/>
			factet_filter: <br/><input type="text" name="factet_filter" /><br/>
			
			<input type="submit" value="Search" />
		</form>
	</div>
	</div>
	<div id = "include">
 		<jsp:include page ="display.jsp"/>
 	</div>
</body>
</html>