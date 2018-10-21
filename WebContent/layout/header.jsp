<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html>
<html ng-app="servsAdm">
<head>
<meta meta charset=utf-8>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<c:out value="${pageContext.servletContext.contextPath}" />/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"  crossorigin="anonymous" />
<link rel="stylesheet" href="<c:out value="${pageContext.servletContext.contextPath}" />/css/site.css">
<script src="<c:out value="${pageContext.servletContext.contextPath}" />/js/jquery.js"></script>
<script src="<c:out value="${pageContext.servletContext.contextPath}" />/js/bootstrap.min.js"></script>
<script src="<c:out value="${pageContext.servletContext.contextPath}" />/js/angular.min.js"></script>
<script src="<c:out value="${pageContext.servletContext.contextPath}" />/js/angular.sanitize.js"></script>
<script src="<c:out value="${pageContext.servletContext.contextPath}" />/js/site.js"></script>
<script src="<c:out value="${pageContext.servletContext.contextPath}" />/js/site-app.js"></script>
<title>Index</title>
</head>
<body>
<input type="hidden" id="contextPath" value="<c:out value="${pageContext.servletContext.contextPath}" />" />
<navbar class="navbar navbar-default">
<div class="container-fluid">
    <div class="navbar-header">
      <p style="font-weight:bolder">ADM:</p>
    </div>

<ul class="nav nav-tabs">
<li><a href="<c:out value="${pageContext.servletContext.contextPath}" />/">Home</a></li>
<li><a href="<c:out value="${pageContext.servletContext.contextPath}" />/adm.do?action=insert">Inserir</a></li>
<li><a href="<c:out value="${pageContext.servletContext.contextPath}" />/adm.do?action=list">Gerenciar</a></li>
<li style="float:right"><form action="<c:out value="${pageContext.servletContext.contextPath}" />/adm.do?action=list&" method="GET">
<input type="hidden"  name="action" value="list" />
<input type="text" placeholder="Pesquisar Nome" name="busca" class="form-control col-xs-8" value="<c:out value='${param.busca}'/>"/>
</form>
</li>
</ul>
</navbar>