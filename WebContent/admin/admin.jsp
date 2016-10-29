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
			<div id="logo">
				<a href="http://localhost:8080/suifengwiki/admin/admin.jsp">Wiki · Suifeng</a>
			</div>
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
			<c:if test="${param.page=='kindList' }">
				<%@include file="admin-kindList.jsp" %>
			</c:if>
			<c:if test="${ empty param.page}">
				<%@include file="admin-main.jsp" %>
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
		  height: 500,                 // set editor height
		  minHeight: null,             // set minimum height of editor
		  maxHeight: null,             // set maximum height of editor
		  focus: true,               // set focus to editable area after initializing summernote
		  lang: 'zh-CN',// default: 'en-US'
		  callbacks: {
			    onImageUpload: function(files) {
			      //上传图片到服务器，使用了formData对象，至于兼容性...据说对低版本IE不太友好
			      var formData = new FormData();
			      formData.append('file',files[0]);
			      $.ajax({
			        url : 'imageUpload',//后台文件上传接口
			        type : 'POST',
			        data : formData,
			        processData : false,
			        contentType : false,
			        success: function(data) {

			              $("#summernote").summernote('insertImage', data, 'image name'); // the insertImage API  
			        }, 
			      error: function(data) {  

		              $("#summernote").summernote('insertImage', data, 'image name'); // the insertImage API  
		        }
			      });
			    }
			  }
		});
		
		function save(){
			$("#content[value]").val($('#summernote').summernote('code').replace(/(^\s*)|(\s*$)/g, ""));
			$("#state[value]").val($("select").val());
			if(check()){
				$("form").submit();
			}
		}
		
		function check(){
			if($("#theme[value]").val() == null || $("#theme[value]").val() == ""){
				alert("文章标题不能为空！");
				return false;
			}
			
			if($("#content[value]").val() == null || $("#content[value]").val() == ""){
				alert("文章内容不能为空！");
				return false;
			}
			
			if($('.articleKindId:checked').attr("value") == null || $('.articleKindId:checked').attr("value") == ""){
				alert("文章分类不能为空！");
				return false;
			}
			
			if($("#articleTag[value]").val() == null || $("#articleTag[value]").val() == ""){
				alert("文章标签不能为空！");
				return false;
			}
			
			return true;
		}
		
		function addArticleTag(){
			$("#articleTagStrong").html("本文标签：<a>"+$("#articleTagInput").val()+"</a>");
			$("#articleTag[value]").val($("#articleTagInput").val());
			$("#articleTagButton").html("修改");
			return false;
		}
		
		
		function loadArticle(){
			
		}
			
	</script>
</c:if>

<c:if test="${param.page=='kindList' }">
	<script type="text/javascript">
		$("tr").bind("click",function(){
			var kindId = $(this).find("#KindId").html();
			var kindName = $(this).find("#KindName").html();
			$("#articleKindId[value]").val(kindId);
			$("#articleKindName[value]").val(kindName);
			$("#kindAddButton").attr('style','display:none');
			$("#kindUpdateButton").attr('style','');
		});
		
		function kindAdd(){
			$("form").attr("action","kind_add");
			$("form").submit();
		}
		
		function kindUpdate(){
			$("form").attr("action","kind_update");
			$("form").submit();
		}
		
		function kinddelete(){
			$.ajax({
		        url : 'kind_delete',
		        type : 'POST',
		        data : {articleKindId:$("#articleKindId[value]").val(), articleKindName:$("#articleKindName[value]").val()},
		        success: function(data) { 
		        	try{
		        		var info = JSON.parse(data);
			        	alert(info.msg);
		        	}catch(err){
		        		window.location.href = 'kind_list';
		        	}
		        	
		        }, 
		      	error: function(data) {  
	        		alert(data);
	        }
		      });
		}
		
	</script>
</c:if>

<script type="text/javascript">
	function adminList_to_Edit(){
		$("form").attr("action","editArticle_edit");
		var count=0;

		$('input[name="article"]:checked').each(function(){
			count=count+1;
			$("#articleId[value]").val($(this).attr("id"));
		});
		
		if(count != 1){
			alert("目前只支持单选！");
			return false;
		}

		$("form").submit();
		
	}
	
	function adminList_to_Delete(){
		$("form").attr("action","article_delete");
		var count=0;

		$('input[name="article"]:checked').each(function(){
			count=count+1;
			$("#articleId[value]").val($(this).attr("id"));
		});
		
		if(count != 1){
			alert("目前只支持单选！");
			return false;
		}

		$("form").submit();
		
	}
	
	function listSearch(){
		$("#listSearchForm").submit();
	}
	
	function article_draft_save(){
		$("#content[value]").val($('#summernote').summernote('code').replace(/(^\s*)|(\s*$)/g, ""));
		$("#state[value]").val($("select").val());
		if(check()){
			$.ajax({
		        url : 'article_draft_save',
		        type : 'POST',
		        data : {articleId:$("#articleId[value]").val(),theme:$("#theme[value]").val(),content:$('#summernote').summernote('code').replace(/(^\s*)|(\s*$)/g, ""), articleKindId:$("#articleKindId[value]").val(),articleTag:$("#articleTag[value]").val(),state:1},
		        success: function(data) { 
		        	//将articleKindId置上（保存一次以后就有articleKindId了）
		        	$("#articleId[value]").val(data);
		        }
		      });
		}
		
	}
	
	function predetail(){
		$("#content[value]").val($('#summernote').summernote('code').replace(/(^\s*)|(\s*$)/g, ""));
		$("#state[value]").val($("select").val());
		
		if(check()){
			var theme = $("#theme[value]").val();
			var content = $('#summernote').summernote('code').replace(/(^\s*)|(\s*$)/g, "");
			//1.get请求缺陷&符号会截断之后内容 2.长度限制
// 			window.open("../predetail?theme="+theme+"&content="+content,"_blank");
			openWindowWithPost("../predetail",theme,content);
		}
	}
	
	function openWindowWithPost(url,theme,content){
		var newWindow = window.open(url,"_blank");
		if (!newWindow)
		return false;
// 		alert(theme);
// 		alert(content);
		var html = "";
		html += "<!DOCTYPE html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head><body><form id='formid' method='post' action='" + url + "'>";
		html += "<input type='hidden' id = 'theme' name='theme' value='" + theme + "'/>";
		html += "<input type='hidden' name='content' value='" + content + "'/>";
		html += "</form><script src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js\"><\/script> <script type='text/javascript'>$(\"#formid\").submit();";//
		html += "<\/script></body></html>";
		var str = "不能中文"
		newWindow.document.write(html);
		return newWindow;
	} 
	
	function setupSubmit(){
		
		$.ajax({
	        url : 'websiteSetup',
	        type : 'POST',
	        data : {webSiteTheme: $("#webSiteTheme").val(),webSiteEmail: $("#webSiteEmail").val(),
	        		webSiteDateFormat: $("#webSiteDateFormat").val(),webSiteTimeFormat: $("#webSiteTimeFormat").val(),
	        		webSiteFooterSetup: $("#webSiteFooterSetup").val()},
       		success: function(data) {
	        	try{
	        		var info = JSON.parse(data);
		        	alert(info.msg);
	        	}catch(err){
	        		window.location.href = 'article_commonSetup';
	        	}
	        	
	        }, 
	      	error: function(data) {  
        		alert(data);
	      	}
	      });
	}
	
	function setupReset(){
		$("#webSiteTheme").val("");
		$("#webSiteEmail").val("");
		$("#webSiteDateFormat").val("");
		$("#webSiteTimeFormat").val("");
		$("#webSiteFooterSetup").val("");
	}
	
	function getArticle_draft_count(){
		$.ajax({
	        url : 'getArticle_draft_count',
	        type : 'POST',
	        success: function(data) { 
	        	$("#article_draft_count").html(data);
	        }
	      });
	}
	getArticle_draft_count();
	

	
</script>

</body>
</html>