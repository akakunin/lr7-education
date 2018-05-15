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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Pet service. Represents a row in the &quot;PetsCatalog_Pet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link ru.emdev.samples.petcatalog.model.impl.PetModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ru.emdev.samples.petcatalog.model.impl.PetImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Pet
 * @see ru.emdev.samples.petcatalog.model.impl.PetImpl
 * @see ru.emdev.samples.petcatalog.model.impl.PetModelImpl
 * @generated
 */
@ProviderType
public interface PetModel extends BaseModel<Pet>, GroupedModel, ShardedModel,
	StagedAuditedModel, TrashedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a pet model instance should use the {@link Pet} interface instead.
	 */

	/**
	 * Returns the primary key of this pet.
	 *
	 * @return the primary key of this pet
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this pet.
	 *
	 * @param primaryKey the primary key of this pet
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this pet.
	 *
	 * @return the uuid of this pet
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this pet.
	 *
	 * @param uuid the uuid of this pet
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the pet ID of this pet.
	 *
	 * @return the pet ID of this pet
	 */
	public long getPetId();

	/**
	 * Sets the pet ID of this pet.
	 *
	 * @param petId the pet ID of this pet
	 */
	public void setPetId(long petId);

	/**
	 * Returns the group ID of this pet.
	 *
	 * @return the group ID of this pet
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this pet.
	 *
	 * @param groupId the group ID of this pet
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this pet.
	 *
	 * @return the company ID of this pet
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this pet.
	 *
	 * @param companyId the company ID of this pet
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this pet.
	 *
	 * @return the user ID of this pet
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this pet.
	 *
	 * @param userId the user ID of this pet
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this pet.
	 *
	 * @return the user uuid of this pet
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this pet.
	 *
	 * @param userUuid the user uuid of this pet
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this pet.
	 *
	 * @return the user name of this pet
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this pet.
	 *
	 * @param userName the user name of this pet
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this pet.
	 *
	 * @return the create date of this pet
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this pet.
	 *
	 * @param createDate the create date of this pet
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this pet.
	 *
	 * @return the modified date of this pet
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this pet.
	 *
	 * @param modifiedDate the modified date of this pet
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this pet.
	 *
	 * @return the name of this pet
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this pet.
	 *
	 * @param name the name of this pet
	 */
	public void setName(String name);

	/**
	 * Returns the description of this pet.
	 *
	 * @return the description of this pet
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this pet.
	 *
	 * @param description the description of this pet
	 */
	public void setDescription(String description);

	/**
	 * Returns the price of this pet.
	 *
	 * @return the price of this pet
	 */
	public double getPrice();

	/**
	 * Sets the price of this pet.
	 *
	 * @param price the price of this pet
	 */
	public void setPrice(double price);

	/**
	 * Returns the birthday of this pet.
	 *
	 * @return the birthday of this pet
	 */
	public Date getBirthday();

	/**
	 * Sets the birthday of this pet.
	 *
	 * @param birthday the birthday of this pet
	 */
	public void setBirthday(Date birthday);

	/**
	 * Returns the status of this pet.
	 *
	 * @return the status of this pet
	 */
	@Override
	public int getStatus();

	/**
	 * Returns the trash entry created when this pet was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this pet.
	 *
	 * @return the trash entry created when this pet was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws PortalException;

	/**
	 * Returns the class primary key of the trash entry for this pet.
	 *
	 * @return the class primary key of the trash entry for this pet
	 */
	@Override
	public long getTrashEntryClassPK();

	/**
	 * Returns the trash handler for this pet.
	 *
	 * @return the trash handler for this pet
	 * @deprecated As of 7.0.0, with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler();

	/**
	 * Returns <code>true</code> if this pet is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this pet is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash();

	/**
	 * Returns <code>true</code> if the parent of this pet is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this pet is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer();

	@Override
	public boolean isInTrashExplicitly();

	@Override
	public boolean isInTrashImplicitly();

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Pet pet);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Pet> toCacheModel();

	@Override
	public Pet toEscapedModel();

	@Override
	public Pet toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}