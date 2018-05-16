<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
Pet pet = (Pet)request.getAttribute("pet");

pet = pet.toEscapedModel();
%>
<c:if test="<%= pet != null %>">
	<liferay-ui:header title="<%= pet.getName() %>"/>
	
	<aui:fieldset>
		<aui:field-wrapper first="true" label="name">
			<%= pet.getName() %>
		</aui:field-wrapper>

		<aui:field-wrapper label="description">
			<%= pet.getDescription() %>
		</aui:field-wrapper>

		<aui:field-wrapper label="price">
			<%= pet.getPrice() %>
		</aui:field-wrapper>

		<aui:field-wrapper label="birthday">
			<%= dateFormatDateTime.format(pet.getBirthday()) %>
		</aui:field-wrapper>
	</aui:fieldset>
</c:if>