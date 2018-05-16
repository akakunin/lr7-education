<%@ include file="/init.jsp" %>

<%
Pet pet = null;
String redirect = ParamUtil.getString(request, "redirect");
%>
<portlet:actionURL name="addPet" var="addPetURL"/>

<liferay-ui:header title='<%= pet != null ? pet.getName() : "add-pet" %>' backURL="<%= redirect %>"/>

	
<aui:form method="post" action="<%= addPetURL %>">
	<aui:input type="hidden" name="redirect" value="<%= redirect %>"/>
	<aui:input type="hidden" name="jspPage" value="/edit-pet.jsp"/>

	
	<aui:model-context bean="<%= pet %>" model="<%= Pet.class %>" />
	
	<aui:input autoFocus="true" name="name" required="true"/>
	<aui:input name="description"/>
	<aui:input name="price" required="true">
		<aui:validator name="min" errorMessage="price-should-be-positive">0</aui:validator>
	</aui:input>
	
	<aui:input name="birthday"/>

	<aui:button-row>
		<aui:button type="submit" value="add-pet" />
		<c:if test="<%= Validator.isNotNull(redirect) %>">
			<aui:button value="cancel" href="<%= redirect %>"/>
		</c:if>
	</aui:button-row>
</aui:form>