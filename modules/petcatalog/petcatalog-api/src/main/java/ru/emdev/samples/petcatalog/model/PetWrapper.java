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

package ru.emdev.samples.petcatalog.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Pet}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Pet
 * @generated
 */
@ProviderType
public class PetWrapper implements Pet, ModelWrapper<Pet> {
	public PetWrapper(Pet pet) {
		_pet = pet;
	}

	@Override
	public Class<?> getModelClass() {
		return Pet.class;
	}

	@Override
	public String getModelClassName() {
		return Pet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("petId", getPetId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("price", getPrice());
		attributes.put("birthday", getBirthday());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long petId = (Long)attributes.get("petId");

		if (petId != null) {
			setPetId(petId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Date birthday = (Date)attributes.get("birthday");

		if (birthday != null) {
			setBirthday(birthday);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new PetWrapper((Pet)_pet.clone());
	}

	@Override
	public int compareTo(Pet pet) {
		return _pet.compareTo(pet);
	}

	/**
	* Returns the birthday of this pet.
	*
	* @return the birthday of this pet
	*/
	@Override
	public Date getBirthday() {
		return _pet.getBirthday();
	}

	/**
	* Returns the company ID of this pet.
	*
	* @return the company ID of this pet
	*/
	@Override
	public long getCompanyId() {
		return _pet.getCompanyId();
	}

	/**
	* Returns the create date of this pet.
	*
	* @return the create date of this pet
	*/
	@Override
	public Date getCreateDate() {
		return _pet.getCreateDate();
	}

	/**
	* Returns the description of this pet.
	*
	* @return the description of this pet
	*/
	@Override
	public java.lang.String getDescription() {
		return _pet.getDescription();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _pet.getExpandoBridge();
	}

	/**
	* Returns the group ID of this pet.
	*
	* @return the group ID of this pet
	*/
	@Override
	public long getGroupId() {
		return _pet.getGroupId();
	}

	/**
	* Returns the modified date of this pet.
	*
	* @return the modified date of this pet
	*/
	@Override
	public Date getModifiedDate() {
		return _pet.getModifiedDate();
	}

	/**
	* Returns the name of this pet.
	*
	* @return the name of this pet
	*/
	@Override
	public java.lang.String getName() {
		return _pet.getName();
	}

	/**
	* Returns the pet ID of this pet.
	*
	* @return the pet ID of this pet
	*/
	@Override
	public long getPetId() {
		return _pet.getPetId();
	}

	/**
	* Returns the price of this pet.
	*
	* @return the price of this pet
	*/
	@Override
	public double getPrice() {
		return _pet.getPrice();
	}

	/**
	* Returns the primary key of this pet.
	*
	* @return the primary key of this pet
	*/
	@Override
	public long getPrimaryKey() {
		return _pet.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _pet.getPrimaryKeyObj();
	}

	/**
	* Returns the status of this pet.
	*
	* @return the status of this pet
	*/
	@Override
	public int getStatus() {
		return _pet.getStatus();
	}

	/**
	* Returns the trash entry created when this pet was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this pet.
	*
	* @return the trash entry created when this pet was moved to the Recycle Bin
	*/
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pet.getTrashEntry();
	}

	/**
	* Returns the class primary key of the trash entry for this pet.
	*
	* @return the class primary key of the trash entry for this pet
	*/
	@Override
	public long getTrashEntryClassPK() {
		return _pet.getTrashEntryClassPK();
	}

	/**
	* Returns the trash handler for this pet.
	*
	* @return the trash handler for this pet
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return _pet.getTrashHandler();
	}

	/**
	* Returns the user ID of this pet.
	*
	* @return the user ID of this pet
	*/
	@Override
	public long getUserId() {
		return _pet.getUserId();
	}

	/**
	* Returns the user name of this pet.
	*
	* @return the user name of this pet
	*/
	@Override
	public java.lang.String getUserName() {
		return _pet.getUserName();
	}

	/**
	* Returns the user uuid of this pet.
	*
	* @return the user uuid of this pet
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _pet.getUserUuid();
	}

	/**
	* Returns the uuid of this pet.
	*
	* @return the uuid of this pet
	*/
	@Override
	public java.lang.String getUuid() {
		return _pet.getUuid();
	}

	@Override
	public int hashCode() {
		return _pet.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _pet.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _pet.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this pet is in the Recycle Bin.
	*
	* @return <code>true</code> if this pet is in the Recycle Bin; <code>false</code> otherwise
	*/
	@Override
	public boolean isInTrash() {
		return _pet.isInTrash();
	}

	/**
	* Returns <code>true</code> if the parent of this pet is in the Recycle Bin.
	*
	* @return <code>true</code> if the parent of this pet is in the Recycle Bin; <code>false</code> otherwise
	*/
	@Override
	public boolean isInTrashContainer() {
		return _pet.isInTrashContainer();
	}

	@Override
	public boolean isInTrashExplicitly() {
		return _pet.isInTrashExplicitly();
	}

	@Override
	public boolean isInTrashImplicitly() {
		return _pet.isInTrashImplicitly();
	}

	@Override
	public boolean isNew() {
		return _pet.isNew();
	}

	@Override
	public void persist() {
		_pet.persist();
	}

	/**
	* Sets the birthday of this pet.
	*
	* @param birthday the birthday of this pet
	*/
	@Override
	public void setBirthday(Date birthday) {
		_pet.setBirthday(birthday);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_pet.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this pet.
	*
	* @param companyId the company ID of this pet
	*/
	@Override
	public void setCompanyId(long companyId) {
		_pet.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this pet.
	*
	* @param createDate the create date of this pet
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_pet.setCreateDate(createDate);
	}

	/**
	* Sets the description of this pet.
	*
	* @param description the description of this pet
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_pet.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_pet.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_pet.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_pet.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this pet.
	*
	* @param groupId the group ID of this pet
	*/
	@Override
	public void setGroupId(long groupId) {
		_pet.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this pet.
	*
	* @param modifiedDate the modified date of this pet
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_pet.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this pet.
	*
	* @param name the name of this pet
	*/
	@Override
	public void setName(java.lang.String name) {
		_pet.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_pet.setNew(n);
	}

	/**
	* Sets the pet ID of this pet.
	*
	* @param petId the pet ID of this pet
	*/
	@Override
	public void setPetId(long petId) {
		_pet.setPetId(petId);
	}

	/**
	* Sets the price of this pet.
	*
	* @param price the price of this pet
	*/
	@Override
	public void setPrice(double price) {
		_pet.setPrice(price);
	}

	/**
	* Sets the primary key of this pet.
	*
	* @param primaryKey the primary key of this pet
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_pet.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_pet.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this pet.
	*
	* @param userId the user ID of this pet
	*/
	@Override
	public void setUserId(long userId) {
		_pet.setUserId(userId);
	}

	/**
	* Sets the user name of this pet.
	*
	* @param userName the user name of this pet
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_pet.setUserName(userName);
	}

	/**
	* Sets the user uuid of this pet.
	*
	* @param userUuid the user uuid of this pet
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_pet.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this pet.
	*
	* @param uuid the uuid of this pet
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_pet.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Pet> toCacheModel() {
		return _pet.toCacheModel();
	}

	@Override
	public Pet toEscapedModel() {
		return new PetWrapper(_pet.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _pet.toString();
	}

	@Override
	public Pet toUnescapedModel() {
		return new PetWrapper(_pet.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _pet.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PetWrapper)) {
			return false;
		}

		PetWrapper petWrapper = (PetWrapper)obj;

		if (Objects.equals(_pet, petWrapper._pet)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _pet.getStagedModelType();
	}

	@Override
	public Pet getWrappedModel() {
		return _pet;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _pet.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _pet.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_pet.resetOriginalValues();
	}

	private final Pet _pet;
}