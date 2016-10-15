<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="admin-setup">
	<div id="name">
		常规选项
	</div>
	<br>
	
	<form action="websiteSetup" method="post">
		<table class="table">
			<tr>
				<td width="28%" align="center" style="vertical-align: middle;">站点标题</td>
				<td>
					<input type="text" class="form-control" id="webSiteTheme" name="webSiteTheme" value="${webSiteTheme }">
				</td>
			</tr>
			<tr>
				<td width="28%" align="center" style="vertical-align: middle;">邮箱地址</td>
				<td>
					<input type="text" class="form-control" id="webSiteEmail" name="webSiteEmail" value="${webSiteEmail }">
				</td>
			</tr>
			<tr>
				<td width="28%" align="center" style="vertical-align: middle;">日期格式</td>
				<td>
					<input type="text" class="form-control" id="webSiteDateFormat" name="webSiteDateFormat" value="${webSiteDateFormat }">
				</td>
			</tr>
			<tr>
				<td width="28%" align="center" style="vertical-align: middle;">时间格式</td>
				<td>
					<input type="text" class="form-control" id="webSiteTimeFormat" name="webSiteTimeFormat" value="${webSiteTimeFormat }">
				</td>
			</tr>
			<tr>
				<td width="28%" align="center" style="vertical-align: middle;">页尾设置</td>
				<td>
					<input type="text" class="form-control" id="webSiteFooterSetup" name="webSiteFooterSetup" value="${webSiteFooterSetup }">
				</td>
			</tr>
			
			<tr>
				<td width="28%" align="center" style="vertical-align: middle;">
<!-- 					<input type="submit" value="保存"> -->
					<button onclick = "setupSubmit()">保存</button>
				</td>
				<td>
					<button onclick = "setupReset()">重置</button>
				</td>
			</tr>
		</table>
		
	</form>

</div>
