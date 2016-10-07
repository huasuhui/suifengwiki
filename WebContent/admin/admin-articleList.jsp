<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<div id="admin-articleList">
	
	<div id="list">
		<form action="admin_listSearch" id="listSearchForm">
			<div class="input-group" id="adminlistSearch">
				<input type="hidden" id="searchstate" name="state" 
					<c:if test="${requestScope.state eq 0}">value="0"</c:if>
					<c:if test="${requestScope.state eq 1}">value="1"</c:if>
				>
				<input type="text" class="form-control" id="theme" name="theme">
				<span  class="input-group-addon" onclick="listSearch();" style="cursor:pointer">Search</span>
			</div>
		</form>
	
		<p>文章列表 -
		<c:if test="${requestScope.state eq 0}">已发布</c:if>
		<c:if test="${requestScope.state eq 1}">草稿</c:if>
		
		
		
		</p>
	</div>
	<form action="" method="post">
		<div id="articleListOperate" >
			<input type="hidden" id="articleId" name="articleId" value="">
			<input type="hidden" id="state" name="state" 
				<c:if test="${requestScope.state eq 0}">value="0"</c:if>
				<c:if test="${requestScope.state eq 1}">value="1"</c:if>
			>
			<a href="#" onclick="adminList_to_Edit()">编辑</a>
			<a href="#" onclick="adminList_to_Delete()">回收站</a>
			
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				  分类查看
				  <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
				    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
				    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
				    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
				  </ul>
			</div>
			
			<br><br>
		</div>
	</form>
<%-- 	${requestScope.articles} --%>
	<div id="table" >
		<table class="table table-hover" >
			<tr>
				<td width="3%"><input type="checkbox" name="article" id=""></td>
				<td width="40%">标题</td>
				<td>作者</td>
				<td>分类目录</td>
				<td>标签</td>
				<td>发布日期</td>
			</tr>
		
			<s:iterator value="%{#request.articles}" var="article">
				<tr>
					<td width="3%"><input type="checkbox" name="article" id=<s:property value="articleId"/>></td>
					<td width="40%"><a href="../detail?articleId=<s:property value="articleId"/>" target="_blank"><s:property value="theme"/></a></td>
					<td><s:property value="author"/></td>
					<td><s:property value="%{#request.kindMap[articleKindId]}"/></td>
					<td><s:property value="articleTag"/></td>
					<td><s:property value="modifydate"/></td>
				</tr>
			</s:iterator>
			
		</table>
	</div>
	
</div>