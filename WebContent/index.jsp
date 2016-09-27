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
			<a href="/">Wiki · Suifeng</a>
		</div>
		
		<!-- category_item -->
		<div id="category_item">
		<!-- 
			<li>迭代循环取值,最简单  
		     <s:iterator value="strMap" id="entry">  
		       <s:property value="#entry"/>{  
		        key: <s:property value="key"/>   
		      value:<s:property value="value"/>}|  
		       </s:iterator>  
		      </li>
		 -->

			<s:iterator value="%{#request.kindArticleMaps}" var="kindArticleMap">
				<s:iterator value="kindArticleMap" id="entry"> 
				<div class="category">
					<div class="category_name">
						<s:property value="key"/>
					</div>
					
					<div class="category_list">
						<ul>
							<s:iterator value="value" var="article">
								<li class="category_list_li">
									<a href="detail?articleId=<s:property value="articleId"/>">
										<s:property value="theme"/>
									</a>
								</li>
							</s:iterator>
						</ul>
					</div>	
				</div>
				</s:iterator>
			</s:iterator>
			
		</div>
	
		<!-- footer -->
		<div id="footer">
			powered by suifeng
		</div>
	</div>
</body>
</html>