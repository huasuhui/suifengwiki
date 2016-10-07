<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="Stylesheet" type="text/css" href="css/suifengwiki.css">
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<!-- header -->
		<div id="header">
			
			<div id="date">
				最后更新&nbsp;${requestScope.articleResult.modifydate} ${requestScope.articleResult.modifytime}
			</div>
		
			<a href="index">Wiki · Suifeng</a> · <Strong>${requestScope.articleResult.theme}</Strong>
		</div>
	
		<!-- content -->
		<div id="content">
			
			<div id="toc"></div>
			
			<div>
				${requestScope.articleResult.content}
			</div>
		</div>
	
		<div id="footer">
			powered by suifeng
		</div>
	
	</div>
<script type="text/javascript">
	function toc(){
		var str="";
		var i=1;
		$("h2").each(function(){
			$(this).attr("id",i);
			var id = $(this).attr("id");
			i++;
			var html = $(this).html();
			str = str + "<li><a href=\"#"+ id +"\">"+ html +"</a></li>";
		});
		str = "<span class=\"toctitle\">Table of Contents</span><ul>" + str + "</ul>";
		$("#toc").html(str);
	}
	toc();
</script>
</body>
</html>