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
					  			<button type="button" class="btn btn-default btn-small" onclick="article_draft_save()">保存草稿</button>
					  			<button type="button" class="btn btn-default btn-small right" onclick="predetail()">预览</button>
					  		
					  		</div>
					  		
					  		<br>
					  		
					  		<div>
					  			
					  			<strong>状态：</strong>
					  			<select>
					  				<option name="state" value="0" <c:if test="${requestScope.articleResult.state eq 0 }">selected="selected" </c:if>>发布</option>
					  				<option name="state" value="1" <c:if test="${requestScope.articleResult.state eq 1 }">selected="selected" </c:if>>草稿</option>
					  			</select>
					  		</div>
					  		
					  		<br>
	
					  		<div>
					  			<button type="button" class="btn btn-primary btn-small right" onclick="save()">
									<c:choose>
										<c:when test="${empty requestScope.articleResult }">发布</c:when>
										<c:otherwise>更新</c:otherwise>
									</c:choose>
								</button>
					  			
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
										      <input type="radio" id ='articleKindId' class='articleKindId' name ='articleKindId' value='${kind[0] }' 
										      	<c:if test="${kind[0] eq requestScope.articleResult.articleKindId}">checked=true </c:if>
										      > 
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
					    		<strong id="articleTagStrong">
					    			本文标签：<c:if test="${requestScope.articleResult != null}"><a>${requestScope.articleResult.articleTag}</a></c:if>
					    		</strong>
						    </div>
						 </div>
					</div>
					
				</div>
			
				<div id="left">
					<div id="input">
					    <input type="text" class="form-control" id="theme" name="theme" placeholder="在此输入标题" aria-describedby="basic-addon1" 
					    value=<c:if test="${requestScope.articleResult != null}">${requestScope.articleResult.theme}</c:if> >
					</div>
					
					<div id="summernote">
						<c:if test="${requestScope.articleResult != null}">${requestScope.articleResult.content}</c:if>
					</div>					
				</div>
				
				
				
				
				
				<input type="hidden" id="content" name="content" value='${requestScope.articleResult.content}'>
				<input type="hidden" id="articleTag" name="articleTag" value="${requestScope.articleResult.articleTag}">
				<input type="hidden" id="state" name="state" value="${requestScope.articleResult.state}">
				<input type="hidden" id="articleId" name="articleId" value="${requestScope.articleResult.articleId}">
			</div>
						
	</form>			
				
</div>
