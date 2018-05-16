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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

import ru.emdev.samples.petcatalog.model.Pet;
import ru.emdev.samples.petcatalog.service.base.PetLocalServiceBaseImpl;

/**
 * The implementation of the pet local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ru.emdev.samples.petcatalog.service.PetLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PetLocalServiceBaseImpl
 * @see ru.emdev.samples.petcatalog.service.PetLocalServiceUtil
 */
public class PetLocalServiceImpl extends PetLocalServiceBaseImpl {
	private static final Log log = LogFactoryUtil.getLog(PetLocalServiceImpl.class);
	
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Pet addPet(long companyId, long groupId, long userId,
            String name, String description, double price, 
            Date birthday, ServiceContext serviceContext) throws SystemException, PortalException {
        log.debug("User " + userId + " attemtps to add pet");
        // получаем ID для новой сущности используя counterLocalService
        long petId = counterLocalService.increment(Pet.class.getName());

        // получаем информацию о пользователе
        User user = userLocalService.getUser(userId);

        // создаем сущность со сгенерированным ID
        Pet pet = createPet(petId);

        // зполняем базовые audit-поля
        pet.setCompanyId(companyId);
        pet.setGroupId(groupId);
        pet.setUserId(userId);
        // дополнительно с userId сохраняем userName -
        // в случае если пользователь будет удален у нас хотя бы останется его
        // имя
        pet.setUserName(user.getScreenName());

        // заполняем даты
        Date now = new Date();
        pet.setCreateDate(now);
        pet.setModifiedDate(now);

        // заполняем поля сущности
        pet.setName(name);
        pet.setDescription(description);
        pet.setPrice(price);
        pet.setBirthday(birthday);

        // сохраняем объект
        pet = petPersistence.update(pet);

        if (serviceContext.isAddGroupPermissions() ||
                serviceContext.isAddGuestPermissions()) {

            addPetResources(
                    pet, serviceContext.isAddGroupPermissions(),
                    serviceContext.isAddGuestPermissions());
        }
        else {
            addPetResources(
                    pet, serviceContext.getGroupPermissions(),
                    serviceContext.getGuestPermissions());
        }
        
        log.debug("User " + userId + " added pet " + petId);

        return pet;
    }
    
    @Override
    public int countByGroup(long groupId) throws SystemException {
        return petPersistence.countByGroup(groupId);
    }

    @Override
    public List<Pet> getByGroup(long groupId, int start, int end) throws SystemException {
        return petPersistence.findByGroup(groupId, start, end);
    }
    
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Pet updatePet(long petId, long userId,
            String name, String description, double price, Date birthday,
            ServiceContext serviceContext) throws SystemException, PortalException {
        log.debug("User " + userId + " attemtps to update pet " + petId);

        // получаем изменяемый объект по ID
        Pet pet = petPersistence.findByPrimaryKey(petId);
        User user = userLocalService.getUser(userId);

        // заполняем дату (только modifiedDate)
        Date now = new Date();
        pet.setModifiedDate(now);

        // заполняем поля объекта
        pet.setName(name);
        pet.setDescription(description);
        pet.setPrice(price);
        pet.setBirthday(birthday);

        // обновляем объект
        pet = petPersistence.update(pet);

     // Resources

        if ((serviceContext.getGroupPermissions() != null) ||
                (serviceContext.getGuestPermissions() != null)) {

            updatePetResources(
                    pet, serviceContext.getGroupPermissions(),
                    serviceContext.getGuestPermissions());
        }

        
        log.debug("User " + userId + " updated pet " + petId);
        return pet;
    }
    
    protected void addPetResources(
            Pet pet, boolean addGroupPermissions,
            boolean addGuestPermissions)
        throws PortalException, SystemException {

        resourceLocalService.addResources(
                pet.getCompanyId(), pet.getGroupId(), pet.getUserId(),
                Pet.class.getName(), pet.getPetId(), false,
                addGroupPermissions, addGuestPermissions);
    }

    protected void addPetResources(
            Pet pet, String[] groupPermissions,
            String[] guestPermissions)
        throws PortalException, SystemException {

        resourceLocalService.addModelResources(
                pet.getCompanyId(), pet.getGroupId(), pet.getUserId(),
                Pet.class.getName(), pet.getPetId(), groupPermissions,
                guestPermissions);
    }

    
    protected void addPetResources(
            long petId, boolean addGroupPermissions,
            boolean addGuestPermissions)
        throws PortalException, SystemException {

        Pet pet = petPersistence.findByPrimaryKey(petId);

        addPetResources(pet, addGroupPermissions, addGuestPermissions);
    }

    protected void addPetResources(
            long petId, String[] groupPermissions, String[] guestPermissions)
        throws PortalException, SystemException {

        Pet pet = petPersistence.findByPrimaryKey(petId);

        addPetResources(pet, groupPermissions, guestPermissions);
    }
    
    protected void updatePetResources(
            Pet pet, String[] groupPermissions,
            String[] guestPermissions)
        throws PortalException, SystemException {

        resourceLocalService.updateResources(
                pet.getCompanyId(), pet.getGroupId(),
                Pet.class.getName(), pet.getPetId(), groupPermissions,
                guestPermissions);
    }


}