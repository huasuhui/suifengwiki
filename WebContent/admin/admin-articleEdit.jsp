<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					  			状态：草稿 <a>编辑</a>
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
						    		<div class="radio">
									    <label>
									      <input type="radio" name ='articleKindId' value='1'> Linux
									    </label>
									</div>
						    		<div class="radio">
									    <label>
									      <input type="radio" name ='articleKindId' value='2'> Java
									    </label>
									</div>
						    		<div class="radio">
									    <label>
									      <input type="radio" name ='articleKindId' value='3'> Python
									    </label>
									</div>
						    	</div>
						  </div>
					</div>
					
					<div class="panel panel-default">
					  <div class="panel-heading">标签</div>
						  <div class="panel-body">
						    <div id="tag">
						    		<input type="text" name="tag">
						    		<button>添加</button>
						    	</div>
						  </div>
					</div>
					
				</div>
			
				<div id="left">
					<div id="input">
					    <input type="text" class="form-control" name="theme" placeholder="在此输入标题" aria-describedby="basic-addon1">
					</div>
					
					<div id="summernote">hello,summernote</div>					
				</div>
				
				<input type="hidden" id="content" name="content" value="huasuhui2">
				<input type="hidden" id="content" name="username" value="huasuhui">
			</div>
						
	</form>			
				
</div>
