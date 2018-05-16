<%@ include file="/init.jsp" %>

<%
Pet pet = (Pet)request.getAttribute("pet");
String redirect = ParamUtil.getString(request, "redirect");
%>
<portlet:actionURL name="updatePet" var="addPetURL"/>

<liferay-ui:header title='<%= pet != null ? pet.getName() : "add-pet" %>' backURL="<%= redirect %>"/>

	
<aui:form method="post" action="<%= addPetURL %>">
	<aui:input type="hidden" name="redirect" value="<%= redirect %>"/>
	<aui:input type="hidden" name="jspPage" value="/edit-pet.jsp"/>

	<c:if test="<%= pet != null %>">
		<aui:input type="hidden" name="petId" value="<%= pet.getPetId() %>"/>
	</c:if>
	
	<aui:model-context bean="<%= pet %>" model="<%= Pet.class %>" />
	
	<aui:input autoFocus="true" name="name" required="true"/>
	<aui:input name="description"/>
	<aui:input name="price" required="true">
		<aui:validator name="min" errorMessage="price-should-be-positive">0</aui:validator>
	</aui:input>
	
	<aui:input name="birthday"/>

	<aui:button-row>
		<aui:button type="submit" value='<%= pet != null ? "update-pet" : "add-pet" %>'/>
		<c:if test="<%= Validator.isNotNull(redirect) %>">
			<aui:button value="cancel" href="<%= redirect %>"/>
		</c:if>
	</aui:button-row>
</aui:form>