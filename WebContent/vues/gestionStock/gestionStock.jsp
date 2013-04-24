<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<html>
<head>

<title>Page de modules</title>

<script src="<%=request.getContextPath()%>/js/commun.js" ></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/styleBoutonsMenu.css" />



</head>

<body>

<table bordercolor="#FF6600;" height="100%"  width="100%" align="center" style="border-right-style:solid; border-left-style:solid; border-top-style:solid; border-bottom-style:solid;">
<jsp:include page="/template/header.jsp" />
<html:form  action="/gestionStockAction">
<tr>
<td style="background:#00253E;">
 
<input name="dispatch" type="hidden" value=""/>  
<table width="90%"   align="center" style="background:#00253E;">
<tr>
<td>
<table width="60%"   align="center" cellpadding="10"  style="background:#00253E;">
           
     				  
 	  <tr style="background:#00253E;" >
			<td  width="50%">
			<span class="addFournisseur">
			<a href="javascript:document.forms[0].dispatch.value='initSaveFournisseur'; document.forms[0].submit();" />
			</span>
			</td>
			
			<td  width="50%">
			<span class="addProduit">
			<a href="javascript:document.forms[0].dispatch.value='initSaveProduit'; document.forms[0].submit();" />
			</span>
			</td>
		  </tr>
		 
		 <tr style="background:#00253E;" >
			<td  width="50%">
			<span class="entreeStock">
			<a href="javascript:document.forms[0].dispatch.value='initSaveEntreeStock'; document.forms[0].submit();" />
			</span>
			</td>
			
			<td  width="50%">
			<span class="sortieStock">
			<a href="javascript:document.forms[0].dispatch.value='initSaveSortieStock'; document.forms[0].submit();" />
			</span>
			</td>
		  </tr>
		  
		  
		  <tr style="background:#00253E;" >
			<td  width="50%">
			<span class="listProduit">
			<a href="javascript:document.forms[0].dispatch.value='affichListeProduits'; document.forms[0].submit();" />
			</span>
			</td>
			
			<td  width="50%">
			<span class="journalStock">
			<a href="javascript:document.forms[0].dispatch.value='affichListeProduits'; document.forms[0].submit();" />
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
</body>
</html>