<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<div id="admin-articleList">
	
	<div id="list">
		<p>文章列表</p>
	</div>
	<div id="articleListOperate">
		<a href="#">回收站</a>
		<a href="#">草稿箱</a>
		<a href="#">分类查看</a>
		<a href="#">搜索</a>
		<br><br>
	</div>
	
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
					<td width="40%"><s:property value="theme"/></td>
					<td><s:property value="author"/></td>
					<td><s:property value="%{#request.kindMap[articleKindId]}"/></td>
					<td><s:property value="articleTag"/></td>
					<td><s:property value="modifydate"/></td>
				</tr>
			</s:iterator>
			
		</table>
	</div>
	
</div>