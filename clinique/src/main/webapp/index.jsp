<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ page import="java.util.prefs.Preferences" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>

<%
    String hideToolbar = (String) Preferences.systemRoot().node("Browser").get("hidetoolbar", "true").toLowerCase();
%>

<html>
<head>
<title>Authentification</title>

<script src="<%=request.getContextPath()%>/js/commun.js" ></script>
<script src="<%=request.getContextPath()%>/js/browsers.js" ></script>

<link type="text/css" href="<%=request.getContextPath()%>/js/jquery-ui-1.8.18.custom/css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />	
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui-1.8.18.custom/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui-1.8.18.custom/js/jquery-ui-1.8.18.custom.min.js"></script>
<link type="text/css" href="<%=request.getContextPath()%>/js/jquery-ui-1.8.18.custom/development-bundle/demos/demos.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/styleBoutonsMenu.css" />


 <% if ("true".equals(hideToolbar.toLowerCase())) { %>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/browsers.js"></script>
        <script type="text/javascript">

        hideToolbar();

       </script>
        <% } %>
 

</head>

<body>

<table bordercolor="#FF6600;" height="100%"  width="100%" align="center" style="border-right-style:solid; border-left-style:solid; border-top-style:solid; border-bottom-style:solid;">
<jsp:include page="/template/header.jsp" />
<tr>
<td style="background:#00253E;">
<table width="30%"   align="center" style="background:#FFFFFF;">
<tr>
<td>
<table width="100%"   align="center" style="background:#00253E; ">
           
          <tr  align="center" style="background:#FFFFFF; border-left-color:#CBE4F4; border-left-style:solid;" >
            <td colspan="3" style="font-weight:bold"><font style="oblique" color="#F"  size="4"> AUTHENTIFICATION </font></td>
          </tr>
		 
		  <html:form action="/authentification.do">
		  <tr style="background:#00253E; " >
			<td  width="10%"></td>
			<td  width="40%" style="font-weight:bold; font-size:14; color: white;">Login</td>
			<td>
			  <html:text styleClass="champText" property="loginUser" size ="23"/>
		   </td>
		  </tr>
		  
		  <tr  style="background:#00253E;">
			<td width="10%"></td>
			<td width="40%" style="font-weight:bold; font-size:14;  color: white; ">Mot de passe</td>
			<td>
			  <html:password styleClass="champText" property="password" size ="23"/>
			</td>
		  </tr>
		  
  <tr style="background:#00253E;">
    <td colspan="3" align="center">
   
	<input type="button" onclick="document.forms[0].submit();" value="Connexion" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  />
  
        </td>
  </tr>
  </html:form>
  
</table>
</td>
</tr>
</table>
</td>
</tr>
<jsp:include page="/template/footer.jsp"/>
</table>

</body>
</html>