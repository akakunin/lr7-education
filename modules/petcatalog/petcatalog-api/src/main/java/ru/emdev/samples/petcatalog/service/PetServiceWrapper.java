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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PetService}.
 *
 * @author Brian Wing Shun Chan
 * @see PetService
 * @generated
 */
@ProviderType
public class PetServiceWrapper implements PetService,
	ServiceWrapper<PetService> {
	public PetServiceWrapper(PetService petService) {
		_petService = petService;
	}

	@Override
	public int countByGroup(long groupId) {
		return _petService.countByGroup(groupId);
	}

	@Override
	public void deletePet(long petId)
		throws com.liferay.portal.kernel.exception.PortalException {
		_petService.deletePet(petId);
	}

	@Override
	public java.util.List<ru.emdev.samples.petcatalog.model.Pet> getByGroup(
		long groupId, int start, int end) {
		return _petService.getByGroup(groupId, start, end);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _petService.getOSGiServiceIdentifier();
	}

	@Override
	public ru.emdev.samples.petcatalog.model.Pet getPet(long petId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _petService.getPet(petId);
	}

	@Override
	public void updatePet(ru.emdev.samples.petcatalog.model.Pet pet)
		throws com.liferay.portal.kernel.exception.PortalException {
		_petService.updatePet(pet);
	}

	@Override
	public PetService getWrappedService() {
		return _petService;
	}

	@Override
	public void setWrappedService(PetService petService) {
		_petService = petService;
	}

	private PetService _petService;
}