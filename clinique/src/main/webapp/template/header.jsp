<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>

<tr bgcolor="#00253E"   align="center" style=" height : 69px;">
	<td  align="center" height="80" > 
		<table width="100%">
			<tr>
				<td width="33%">
				   <img  height="75" align="bottom" style="margin-left:0; margin-bottom: 2; margin-top: 3;"   width="200" src="<%=request.getContextPath()%>/<bean:message key="image.header1" />"  />
				</td>
				
			    <td width="33%" align="center">
			       <img align="bottom"  src="<%=request.getContextPath()%>/<bean:message key="image.header2" />"  />
			    </td>
			    
			    <td width="34%" align="right">
			      <img height="75" width="120" align="right"  src="<%=request.getContextPath()%>/<bean:message key="image.header3" />"  />
			    </td>
			</tr>
		</table>
	</td> 
</tr>
