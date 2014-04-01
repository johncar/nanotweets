<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Nanotweets Document Viewer Demo</title>
	
	<!--jQuery-->
	<script src="js/jquery-1.6.4.min.js"></script>

	<!--docviewer.js-->
	<script src="//static-v2.crocodoc.com/core/docviewer.js"></script>

	<!--docviewer.js-->
	<script src="js/document.js"></script>
	
	<!--custom CSS-->
  	<link type="text/css" rel="stylesheet" href="css/document.css" />
	
	<!-- Biojs tooltip -->
	<script src="js/Biojs.js"></script>
	<script src="js/Biojs.Tooltip.js"></script>
  	<link type="text/css" rel="stylesheet" href="css/biojs.Tooltip.css" />

</head>
<body style="margin:0;">
  
   <div class="toolbar">
    <!--zoom-->
    <div class="zoom-btns">
      <button class="zoom-out">-</button>
      <button class="zoom-in">+</button>
    </div>

    <!--page navigation-->
    <div class="page-nav">
      <button class="prev">◀</button>
      <span class="label">Page <span class="num">1</span>/<span class="numpages">1</span></span>
      <button class="next">▶</button>
    </div>
	
	<!--custom-->
	<div class="custom-btns">
		<div class="nanotweets-feed-control" style="width:auto">
			<a class="sb circle no-shadow no-border blue twitter" href="#"></a>
			<a class="legend" href="#">Hide Nanotweets</a>
			<a class="legend" href="#" style="display:none;">Show Nanotweets</a>
		</div>
	</div>
	
  </div>
  
  <!--div for viewer-->
  <div id="DocViewer"></div>
  <div id="Nanotweets" class="nanotweets-feed"></div>

  
</body>
</html>