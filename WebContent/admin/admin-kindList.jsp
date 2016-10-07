<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<div id="admin-articleList">
	
	<div id="list">
		<p>分类列表</p>
	</div>
	
	<div id="table" >
		<table class="table table-hover" id="22">
			<tr>
				<td>分类ID</td>
				<td>分类名称</td>
				<td>发布日期</td>
			</tr>
		
			<s:iterator value="%{#request.kindList}" var="kind">
				<tr>
					<td id="KindId"><s:property value="articleKindId"/></td>
					<td id="KindName"><s:property value="articleKindName"/></td>
					<td><s:property value="modifydate"/></td>
				</tr>
			</s:iterator>
			
		</table>
	</div>
	
	<div id="kindAdd">
		<form role="form" action="" method="post">
			<div class="form-group">
			  <label for="articleKindName">分类名称</label>
			  <input type="hidden" id="articleKindId" name="articleKindId" value="">
			  <input type="text" id="articleKindName" name="articleKindName" value="" class="form-control" placeholder="">
			</div>
			<button id="kindAddButton" onclick="kindAdd()"    class="btn btn-primary" style="">添加</button>
			<button id="kindUpdateButton" onclick="kindUpdate()" class="btn btn-primary" style="display:none">修改</button>
			<button onclick="kinddelete();return false;" class="btn btn-primary">删除</button>
		</form>
	</div>
</div>