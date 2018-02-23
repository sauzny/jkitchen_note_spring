<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<form id="pagerForm" method="post" action="">
		<input type="hidden" name="pageNum" value="${page.currentPage}" />
		<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	</form>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value,pageNum:1})">
				<option value="10" <c:if test="${page.numPerPage == 10}">selected="selected"</c:if>>10</option>
				<option value="20" <c:if test="${page.numPerPage == 20}">selected="selected"</c:if>>20</option>
				<option value="50" <c:if test="${page.numPerPage == 50}">selected</c:if>>50</option>
				<option value="100" <c:if test="${page.numPerPage == 100}">selected</c:if>>100</option>
				<option value="200" <c:if test="${page.numPerPage == 200}" >selected</c:if>>200</option>
			</select>
			<span>条，共${page.totalCount}条</span>
		</div>
		<div class="pagination" targetType="navTab" totalCount="${page.totalCount}" numPerPage="${page.numPerPage}" pageNumShown="10" currentPage="${page.currentPage}"></div>
	</div>