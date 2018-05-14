<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%
String message = (String)request.getAttribute("message");
%>
<p>
	<b><liferay-ui:message key="echo-web.caption"/></b><br/>
	<% if (message != null && message.length() > 0) { %>
		<liferay-ui:message key="echo-message"/>: <%= message %>
	<% } %>
</p>


<portlet:actionURL name="echo" var="echoURL" />

<aui:form action="<%= echoURL %>" method="post" name="echo">
	<aui:input name="message" type="String"/>
	
	<aui:button-row>
		<aui:button type="submit"/>
	</aui:button-row>
</aui:form>
	