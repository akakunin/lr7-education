<%@ include file="/init.jsp" %>

<%
List<Pet> pets = (List<Pet>)request.getAttribute("pets");
Integer petsCount = (Integer)request.getAttribute("petsCount");

PortletURL iteratorURL = renderResponse.createRenderURL();

int delta = 10;
%>

<c:if test="<%= pets != null %>">
	<liferay-ui:search-container
	    iteratorURL="<%= iteratorURL %>"
		emptyResultsMessage="no-pets-found"
		headerNames="#,name,description,price,birthday"
		delta="<%= delta %>">
		<liferay-ui:search-container-results results="<%= pets %>"/>
		
		<liferay-ui:search-container-row className="ru.emdev.samples.petcatalog.model.Pet"
										modelVar="pet"
										escapedModel="true">
			<liferay-ui:search-container-column-text name="#"
													 property="petId"/>
			
			<liferay-ui:search-container-column-text name="name"
													 property="name"/>
			
			<liferay-ui:search-container-column-text name="description"
													 property="description"/>
			
			<liferay-ui:search-container-column-text name="price"
													 property="price"/>
													 
			<liferay-ui:search-container-column-text name="birthday">
				<%= dateFormatDateTime.format(pet.getBirthday()) %>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
	
	<aui:button-row>
			<portlet:renderURL var="addPetURL">
				<portlet:param name="jspPage" value="/edit-pet.jsp"/>
				<portlet:param name="redirect" value="<%= currentURL %>"/>
			</portlet:renderURL>
		
			<aui:button value="add-pet" href="<%= addPetURL %>"/>
	</aui:button-row>
</c:if>