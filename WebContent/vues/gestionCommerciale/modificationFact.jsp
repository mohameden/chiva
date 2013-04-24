<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Page de modules</title>
<script src="<%=request.getContextPath()%>/js/commun.js" ></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/styleBoutonsMenu.css" />
</head>

<body>
<div class=demos>
<table bordercolor="#FF6600;" height="100%"  width="100%" align="center" style="border-right-style:solid; border-left-style:solid; border-top-style:solid; border-bottom-style:solid;">
<jsp:include page="/template/header.jsp" />
<tr style="background:#0B415F;">
<td height="20">
<table width="100%">
<tr>
<td width="70%"></td>
	<td>
        <span class="accueil">
			<a href="javascript:document.forms[0].dispatch.value='precedent';
	 document.forms[0].subAction.value='accueil';  
	document.forms[0].submit();" ></a>
	  </span>
	</td>

	<td>
	 	  <span class="authentification">
					<a href="javascript:document.forms[0].dispatch.value='precedent';
	 document.forms[0].subAction.value='authentification';  
	document.forms[0].submit();" ></a>
	  </span>
	</td>
	<td>
	  <span class="deconnexion">
					<a href="javascript:document.forms[0].dispatch.value='infosPatient'; document.forms[0].submit();" ></a>
	  </span>
	</td>
</tr>
</table>
</td>
</tr>
<html:form action="/patientAction">
<input type="hidden" name="dispatch"/>
<input type="hidden" name="subAction"/>
<tr>
<td style="background:#00253E;">
<table width="90%"   align="center" style="background:#00253E;">
<tr>
<td>
<table width="60%"   align="center" cellpadding="10"  style="background:#00253E;">
           
     				  
 	  <tr style="background:#00253E;" align="center" >
			<td  align="center" >
			<span class="FactNorm">
			<a href="javascript:document.forms[0].dispatch.value='infosPatient'; document.forms[0].submit();" />
			</span>
			</td>
			
		
		  </tr>
		  
		  <tr style="background:#00253E;" align="center"  >
			<td  align="center" >
			<span class="FactAss">
			<a href="javascript:document.forms[0].dispatch.value='mainPageHospit'; document.forms[0].submit();" ></a>
			</span>
			</td>
			
		
		  </tr>
		  
	
		 
		 
  
</table>
</td>
</tr>
</table>

</td>
</tr>
</html:form>
<jsp:include page="/template/footer.jsp" />
</table>
</div>
</body>
</html>