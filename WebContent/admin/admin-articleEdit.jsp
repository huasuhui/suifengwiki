<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="s" uri="/struts-tags" %>   

<div id="admin-articleEdit">			
	<form role="form" action="editArticle_save" method="post">
		
			<div id="theme-name">
				<p>撰写新文章</p>
			</div>
			
			<div id="content">
				<div id="right">
					<div class="panel panel-default">
					  <div class="panel-heading">发布</div>
					  <div class="panel-body">
					  		<div>
					  			<button type="button" class="btn btn-default btn-small" disabled="disabled">保存草稿</button>
					  			<button type="button" class="btn btn-default btn-small right" disabled="disabled">预览</button>
					  		
					  		</div>
					  		
					  		<br>
					  		
					  		<div>
					  			
					  			<strong>状态：</strong>
					  			<select>
					  				<option name="state" value="0">发布</option>
					  				<option name="state" value="1">草稿</option>
					  			</select>
					  		</div>
					  		
					  		<br>
	
					  		<div>
					  			<button type="button" class="btn btn-primary btn-small right" onclick="save()">发布</button>
					  			
					  		</div>
					  		
					  </div>

					</div>
					
					<div class="panel panel-default">
					  <div class="panel-heading">分类目录</div>
						  <div class="panel-body">
						    	<div id="kind">
						    	
						    		<s:iterator value="%{#request.kindList}" var="kind">
						    			<div class="radio">
										    <label>
										      <input type="radio" name ='articleKindId' value='${kind[0] }'> 
											  ${kind[1] }
										    </label>
										</div>
						    		</s:iterator>

						    	</div>
						  </div>
					</div>
					
					<div class="panel panel-default">
					  <div class="panel-heading">标签</div>
						  <div class="panel-body">
						    <div>
						    		<input type="text" id="articleTagInput">
						    		<button id="articleTagButton" onclick="addArticleTag();return false;">添加</button>
						    		<br><br>
						    		<strong id="articleTagStrong">本文标签：</strong>
						    		
						    	</div>
						  </div>
					</div>
					
				</div>
			
				<div id="left">
					<div id="input">
					    <input type="text" class="form-control" name="theme" placeholder="在此输入标题" aria-describedby="basic-addon1">
					</div>
					
					<div id="summernote">hello!</div>					
				</div>
				
				<input type="hidden" id="content" name="content" value="">
				<input type="hidden" id="articleTag" name="articleTag" value="">
				<input type="hidden" id="state" name="state" value="">
			</div>
						
	</form>			
				
</div>
