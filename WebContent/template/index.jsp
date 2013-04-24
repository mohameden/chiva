<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.prefs.Preferences" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui-1.8.4.custom/development-bundle/jquery-1.4.2.js"></script>
<script src="<%=request.getContextPath()%>/js/commun.js" ></script>
<title>Insert title here</title>
<script type="text/javascript">
$(window).load(function(){
	  // Le code placé ici sera déclenché
	  // au chargement complet de la page.
	document.forms[0].submit();
	});
</script>

</head>
<body>

<form method="post" action="<%=request.getContextPath()%>/template/frames.jsp">
 	<input type="hidden" name="login_user" value=""/>
</form>

</body>
</html>