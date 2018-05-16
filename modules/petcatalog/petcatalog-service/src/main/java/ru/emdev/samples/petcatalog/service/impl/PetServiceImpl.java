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

package ru.emdev.samples.petcatalog.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.permission.ActionKeys;

import java.util.List;

import ru.emdev.samples.petcatalog.model.Pet;
import ru.emdev.samples.petcatalog.service.base.PetServiceBaseImpl;
import ru.emdev.samples.petcatalog.service.permission.PetPermission;

/**
 * The implementation of the pet remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ru.emdev.samples.petcatalog.service.PetService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PetServiceBaseImpl
 * @see ru.emdev.samples.petcatalog.service.PetServiceUtil
 */
public class PetServiceImpl extends PetServiceBaseImpl {
	@Override
    @AccessControlled(guestAccessEnabled = true)
    public int countByGroup(long groupId) {
        return petPersistence.filterCountByGroup(groupId);
    }
    
    @Override
    @AccessControlled(guestAccessEnabled = true)
    public List<Pet> getByGroup(long groupId, int start, int end) {
        return petPersistence.filterFindByGroup(groupId, start, end);
    }
    
    @Override
    @AccessControlled(guestAccessEnabled = true)
    public Pet getPet(long petId) throws PortalException {
        Pet pet = petPersistence.findByPrimaryKey(petId);
        PetPermission.check(getPermissionChecker(), pet, ActionKeys.VIEW);

        return pet;
    }
    
    @Override
    public void updatePet(Pet pet) throws PortalException {
        PetPermission.check(getPermissionChecker(), pet, ActionKeys.UPDATE);

        petPersistence.update(pet);
    }

    @Override
    public void deletePet(long petId) throws PortalException {
        PetPermission.check(getPermissionChecker(), petId, ActionKeys.DELETE);

        petLocalService.deletePet(petId);
    }
}