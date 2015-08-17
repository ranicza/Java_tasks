<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

	<style>
	   <%@include file='css/bootstrap.css' %>
	   <%@include file='css/styles.css' %>
	</style>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Index page</title>
</head>
<body>
	<h1 id='h1-choose'>Please, choose parser in which you want to get information about mobile tariffs and click the button...</h1>

	<div class = 'row'>
        <div class = "col-md-4 col-xs-4">
        	<form action="Controller" method = "post" >
				<input type="hidden" name="command" value="do_sax_parser"/>
				<input type="hidden" name="simpleinfo" value=""/>
				<input type="submit" class="btn btn-primary" value="SAX" /> <br/>
			</form>
        </div>

        <div class = "col-md-4 col-xs-4">
        	 <form action="Controller" method = "post" >
				<input type="hidden" name="command" value="do_stax_parser"/>
				<input type="hidden" name="simpleinfo" value=""/>
				<input type="submit" class="btn btn-primary"  value="STAX" /> <br/>
			</form>
        </div>
        
        <div class = "col-md-4 col-xs-4">
	        <form action="Controller" method = "post" >
				<input type="hidden" name="command" value="do_dom_parser"/>
				<input type="hidden" name="simpleinfo" value=""/>
				<input type="submit" class="btn btn-primary" value="DOM" /> <br/>
			</form>
        </div>
    </div>

</body>
</html>