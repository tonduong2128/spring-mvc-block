<%@page import="org.springframework.security.core.userdetails.User"%>
<%@page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Trang chủ</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon"
	href="<c:url value='/template/web/assets/favicon.ico'/>" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="<c:url value='/template/web/css/styles.css'/>"
	rel="stylesheet" />
</head>
<body>
	<!-- Responsive navbar-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container px-5">
			<a class="navbar-brand" href="#!">Start Bootstrap</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#!">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#!">About</a></li>
					<li class="nav-item"><a class="nav-link" href="#!">Contact</a></li>

					<security:authorize access="isAnonymous()">
						<li class="nav-item"><a class="nav-link" href="./dang-nhap">Dang
								nhap </a></li>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<li class="nav-item"><a class="nav-link" href="#">Welcom
								<%=((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()%>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="./dang-xuat">Dang
								xuat </a></li>
					</security:authorize>

				</ul>
			</div>
		</div>
	</nav>