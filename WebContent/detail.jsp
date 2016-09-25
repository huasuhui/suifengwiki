<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="Stylesheet" type="text/css" href="css/suifengwiki.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<!-- header -->
		<div id="header">
			<a href="index">Wiki · Suifeng</a> · ${requestScope.articleResult.theme}
		</div>
	
		<!-- content -->
		<div id="content">
			<div id="toc">
				${requestScope.articleResult.content}
			</div>
		</div>
	
		<div id="footer">
			powered by suifeng
		</div>
	
	</div>

</body>
</html>