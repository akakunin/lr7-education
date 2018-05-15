/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ru.emdev.samples.petcatalog.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Pet. This utility wraps
 * {@link ru.emdev.samples.petcatalog.service.impl.PetLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PetLocalService
 * @see ru.emdev.samples.petcatalog.service.base.PetLocalServiceBaseImpl
 * @see ru.emdev.samples.petcatalog.service.impl.PetLocalServiceImpl
 * @generated
 */
@ProviderType
public class PetLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link ru.emdev.samples.petcatalog.service.impl.PetLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static ru.emdev.samples.petcatalog.model.Pet addPet(long companyId,
		long groupId, long userId, java.lang.String name,
		java.lang.String description, double price, java.util.Date birthday,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addPet(companyId, groupId, userId, name, description,
			price, birthday, serviceContext);
	}

	/**
	* Adds the pet to the database. Also notifies the appropriate model listeners.
	*
	* @param pet the pet
	* @return the pet that was added
	*/
	public static ru.emdev.samples.petcatalog.model.Pet addPet(
		ru.emdev.samples.petcatalog.model.Pet pet) {
		return getService().addPet(pet);
	}

	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroup(groupId);
	}

	/**
	* Creates a new pet with the primary key. Does not add the pet to the database.
	*
	* @param petId the primary key for the new pet
	* @return the new pet
	*/
	public static ru.emdev.samples.petcatalog.model.Pet createPet(long petId) {
		return getService().createPet(petId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the pet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param petId the primary key of the pet
	* @return the pet that was removed
	* @throws PortalException if a pet with the primary key could not be found
	*/
	public static ru.emdev.samples.petcatalog.model.Pet deletePet(long petId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePet(petId);
	}

	/**
	* Deletes the pet from the database. Also notifies the appropriate model listeners.
	*
	* @param pet the pet
	* @return the pet that was removed
	*/
	public static ru.emdev.samples.petcatalog.model.Pet deletePet(
		ru.emdev.samples.petcatalog.model.Pet pet) {
		return getService().deletePet(pet);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.emdev.samples.petcatalog.model.impl.PetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.emdev.samples.petcatalog.model.impl.PetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ru.emdev.samples.petcatalog.model.Pet fetchPet(long petId) {
		return getService().fetchPet(petId);
	}

	/**
	* Returns the pet matching the UUID and group.
	*
	* @param uuid the pet's UUID
	* @param groupId the primary key of the group
	* @return the matching pet, or <code>null</code> if a matching pet could not be found
	*/
	public static ru.emdev.samples.petcatalog.model.Pet fetchPetByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchPetByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<ru.emdev.samples.petcatalog.model.Pet> getByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByGroup(groupId, start, end);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the pet with the primary key.
	*
	* @param petId the primary key of the pet
	* @return the pet
	* @throws PortalException if a pet with the primary key could not be found
	*/
	public static ru.emdev.samples.petcatalog.model.Pet getPet(long petId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPet(petId);
	}

	/**
	* Returns the pet matching the UUID and group.
	*
	* @param uuid the pet's UUID
	* @param groupId the primary key of the group
	* @return the matching pet
	* @throws PortalException if a matching pet could not be found
	*/
	public static ru.emdev.samples.petcatalog.model.Pet getPetByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPetByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the pets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.emdev.samples.petcatalog.model.impl.PetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pets
	* @param end the upper bound of the range of pets (not inclusive)
	* @return the range of pets
	*/
	public static java.util.List<ru.emdev.samples.petcatalog.model.Pet> getPets(
		int start, int end) {
		return getService().getPets(start, end);
	}

	/**
	* Returns all the pets matching the UUID and company.
	*
	* @param uuid the UUID of the pets
	* @param companyId the primary key of the company
	* @return the matching pets, or an empty list if no matches were found
	*/
	public static java.util.List<ru.emdev.samples.petcatalog.model.Pet> getPetsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getPetsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of pets matching the UUID and company.
	*
	* @param uuid the UUID of the pets
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of pets
	* @param end the upper bound of the range of pets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching pets, or an empty list if no matches were found
	*/
	public static java.util.List<ru.emdev.samples.petcatalog.model.Pet> getPetsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ru.emdev.samples.petcatalog.model.Pet> orderByComparator) {
		return getService()
				   .getPetsByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of pets.
	*
	* @return the number of pets
	*/
	public static int getPetsCount() {
		return getService().getPetsCount();
	}

	/**
	* Updates the pet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pet the pet
	* @return the pet that was updated
	*/
	public static ru.emdev.samples.petcatalog.model.Pet updatePet(
		ru.emdev.samples.petcatalog.model.Pet pet) {
		return getService().updatePet(pet);
	}

	public static PetLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PetLocalService, PetLocalService> _serviceTracker =
		ServiceTrackerFactory.open(PetLocalService.class);
}