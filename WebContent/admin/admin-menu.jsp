<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<div id="admin-menu">
	<ul class="sidebar-menu">
				
	  				<li class="header">主导航</li>
	  				
	  				<li class="treeview">
						<a href="#">
		  					<i class="fa fa-dashboard"></i> <span>文章</span> <i class="fa fa-angle-right pull-right"></i>
						</a>
						<ul class="treeview-menu">
		  					<li><a href="article_list"><i class="fa fa-circle-o"></i> 已发布文章</a></li>
			  				<li><a href="editArticle_edit"><i class="fa fa-circle-o"></i> 写文章</a></li>
			  				<li><a href="kind_list"><i class="fa fa-circle-o"></i> 分类目录</a></li>
						</ul>
	  				</li>

					<li>
						<a href="article_draft">
		  					<i class="fa fa-calendar"></i> <span>草稿箱</span>
		  					<small id="article_draft_count" class="label pull-right label-warning"></small>
						</a>
	  				</li>

	  				<li class="treeview">
						<a href="#">
		  					<i class="fa fa-dashboard"></i> <span>设置</span> <i class="fa fa-angle-right pull-right"></i>
						</a>
						<ul class="treeview-menu">
		  					<li><a href="article_commonSetup"><i class="fa fa-circle-o"></i> 常规设置</a></li>
						</ul>
	  				</li>
				</ul>
</div>