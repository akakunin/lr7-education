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
		headerNames="#,name,description,price,birthday,actions"
		delta="<%= delta %>">
		<liferay-ui:search-container-results results="<%= pets %>"/>
		
		<liferay-ui:search-container-row className="ru.emdev.samples.petcatalog.model.Pet"
										modelVar="pet"
										escapedModel="true">
			<portlet:renderURL var="petURL">
				<portlet:param name="jspPage" value="/view-pet.jsp"/>
				<portlet:param name="petId" value="<%= String.valueOf(pet.getPetId()) %>" />
			</portlet:renderURL>
			
			<liferay-ui:search-container-column-text href="<%= petURL %>"
													 name="#"
													 property="petId"/>
			
			<liferay-ui:search-container-column-text href="<%= petURL %>"
													 name="name"
													 property="name"/>
			
			<liferay-ui:search-container-column-text name="description"
													 property="description"/>
			
			<liferay-ui:search-container-column-text name="price"
													 property="price"/>
													 
			<liferay-ui:search-container-column-text name="birthday">
				<%= dateFormatDateTime.format(pet.getBirthday()) %>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="actions">
				<liferay-ui:icon-list>
					<c:if test="<%= PetPermission.contains(permissionChecker, pet, ActionKeys.UPDATE) %>">
						<portlet:renderURL var="editPetURL">
							<portlet:param name="petId" value="<%= String.valueOf(pet.getPetId()) %>" />
							<portlet:param name="jspPage" value="/edit-pet.jsp"/>
							<portlet:param name="redirect" value="<%= currentURL %>"/>
						</portlet:renderURL>
						<liferay-ui:icon image="edit" url="<%= editPetURL %>"/>
					</c:if>
										
					<c:if test="<%= PetPermission.contains(permissionChecker, pet, ActionKeys.DELETE) %>">
						<portlet:actionURL name="deletePet" var="deletePetURL">
							<portlet:param name="petId" value="<%= String.valueOf(pet.getPetId()) %>" />
							<portlet:param name="redirect" value="<%= currentURL %>"/>
						</portlet:actionURL>
						<liferay-ui:icon-delete url="<%= deletePetURL %>"/>
					</c:if>
					
					<c:if test="<%= PetPermission.contains(permissionChecker, pet, ActionKeys.PERMISSIONS) %>">
						<liferay-security:permissionsURL
							modelResource="<%= Pet.class.getName() %>"
							modelResourceDescription="<%= pet.getName() %>"
							resourcePrimKey="<%= String.valueOf(pet.getPetId()) %>"
							var="petPermissionsURL"
							windowState="<%= LiferayWindowState.POP_UP.toString() %>"
						/>
						<liferay-ui:icon image="permissions" url="<%= petPermissionsURL %>" useDialog="<%= true %>"/>
					</c:if>
				</liferay-ui:icon-list>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
	
	<aui:button-row>
		<c:if test="<%= PetCatalogPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), PetCatalogPermission.ACTION_ADD_PET) %>">
			<portlet:renderURL var="addPetURL">
				<portlet:param name="jspPage" value="/edit-pet.jsp"/>
				<portlet:param name="redirect" value="<%= currentURL %>"/>
			</portlet:renderURL>
		
			<aui:button value="add-pet" href="<%= addPetURL %>"/>
		</c:if>
		
		<c:if test="<%= PetCatalogPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), ActionKeys.PERMISSIONS) %>">
		    <liferay-security:permissionsURL
						modelResource="<%= PetCatalogPermission.RESOURCE_NAME %>"
						modelResourceDescription='<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) + " - " + LanguageUtil.get(request, "model.resource.ru.emdev.samples.petcatalog") %>'
						resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
						var="permissionsURL"
						windowState="<%= LiferayWindowState.POP_UP.toString() %>"
					/>
			<aui:button value="edit-permissions" href="<%= permissionsURL %>" useDialog="<%= true %>"/>
		</c:if>
	</aui:button-row>
</c:if>