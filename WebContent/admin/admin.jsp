<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wiki·Suifeng后台管理</title>

<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>
<link href="../css/suifengwiki-admin.css"  rel="stylesheet">

</head>
<body>

	<div>
		<!-- header -->
		<div id="admin-header">
			<div id="logo">Wiki · Suifeng</div>
		</div>
		
		<!-- middle -->
		<div id="admin-middle">
		
			<!-- 菜单 -->
			<div id="admin-middle-sidebar">
				<%@include file="admin-menu.jsp" %>
			</div>
			
			<!-- main -->
			<div id="admin-middle-main">
			<c:if test="${param.page=='main' }">
				<%@include file="admin-main.jsp" %>
			</c:if>
			<c:if test="${param.page=='articleList' }">
				<%@include file="admin-articleList.jsp" %>
			</c:if>
			<c:if test="${param.page=='articleEdit' }">
				<%@include file="admin-articleEdit.jsp" %>
			</c:if>
			<c:if test="${param.page=='commonSetup' }">
				<%@include file="admin-setup.jsp" %>
			</c:if>
			<c:if test="${param.page=='passSetup' }">
				<%@include file="admin-passSetup.jsp" %>
			</c:if>
			
<%-- 				<%@include file="admin-main.jsp" %> --%>
<%-- 				<%@include file="admin-articleList.jsp" %> --%>
<%-- 				<%@include file="admin-articleEdit.jsp" %> --%>
<%-- 				<%@include file="setup.jsp" %> --%>

			</div>
		</div>
		
		<!-- footer -->
		<div id="admin-footer"></div>
	</div>




<script src="../js/sidebar-menu.js"></script>
<script>
		$.sidebarMenu($('.sidebar-menu'));
</script>

<c:if test="${param.page=='articleEdit' }">
	<script>
		$('#summernote').summernote({
		  height: 435,                 // set editor height
		  minHeight: null,             // set minimum height of editor
		  maxHeight: null,             // set maximum height of editor
		  focus: true,               // set focus to editable area after initializing summernote
		  lang: 'zh-CN'// default: 'en-US'
		});
		
		function save(){
			$("#content[value]").val($('#summernote').summernote('code'))
	        $("form").submit();
		}
		
	</script>
</c:if>

</body>
</html>