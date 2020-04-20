<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>实验室自主科研预约系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/featherlight.min.css">
	<link href='https://fonts.googleapis.com/css?family=Arimo:400,700' rel='stylesheet' type='text/css'>
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="js/featherlight.min.js"></script> 

</head>
<body>
	<header id="top">
		<div class="wrapper">
			<nav>
				<ul id="navigation">
					<li><a href="#home">实验公告</a></li>
					<li><a href="#home">操作演示</a></li>
					<li><a href="studentServlet">我的预约</a></li>
					<li><a href="adminServlet">管理员</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<section id="banner"><a name="home"></a>
		<div class="wrapper">
			<h2 style="text-align: center;">实验室自主科研预约系统</h2>
			<p class="subtitle">人生天地间，若白马过隙，忽然而已</p>
			<div class="buttons">
				<a href="query.jsp" class="button-1">查询空闲实验室</a>
				<a href="appointServlet" class="button-2">马上预约</a>
			</div>
		</div>
	</section>
</body>
</html>