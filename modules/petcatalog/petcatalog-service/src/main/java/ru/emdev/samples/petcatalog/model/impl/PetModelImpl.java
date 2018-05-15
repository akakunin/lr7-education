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

package ru.emdev.samples.petcatalog.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ContainerModel;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import ru.emdev.samples.petcatalog.model.Pet;
import ru.emdev.samples.petcatalog.model.PetModel;
import ru.emdev.samples.petcatalog.model.PetSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Pet service. Represents a row in the &quot;PetsCatalog_Pet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link PetModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PetImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PetImpl
 * @see Pet
 * @see PetModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class PetModelImpl extends BaseModelImpl<Pet> implements PetModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a pet model instance should use the {@link Pet} interface instead.
	 */
	public static final String TABLE_NAME = "PetsCatalog_Pet";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "petId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "price", Types.DOUBLE },
			{ "birthday", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("petId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("price", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("birthday", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table PetsCatalog_Pet (uuid_ VARCHAR(75) null,petId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,description VARCHAR(75) null,price DOUBLE,birthday DATE null)";
	public static final String TABLE_SQL_DROP = "drop table PetsCatalog_Pet";
	public static final String ORDER_BY_JPQL = " ORDER BY pet.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY PetsCatalog_Pet.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(petcatalog.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.ru.emdev.samples.petcatalog.model.Pet"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(petcatalog.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.ru.emdev.samples.petcatalog.model.Pet"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(petcatalog.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.ru.emdev.samples.petcatalog.model.Pet"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long USERID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;
	public static final long NAME_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Pet toModel(PetSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Pet model = new PetImpl();

		model.setUuid(soapModel.getUuid());
		model.setPetId(soapModel.getPetId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setPrice(soapModel.getPrice());
		model.setBirthday(soapModel.getBirthday());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Pet> toModels(PetSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Pet> models = new ArrayList<Pet>(soapModels.length);

		for (PetSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(petcatalog.service.util.ServiceProps.get(
				"lock.expiration.time.ru.emdev.samples.petcatalog.model.Pet"));

	public PetModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _petId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPetId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _petId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getPetId() {
		return _petId;
	}

	@Override
	public void setPetId(long petId) {
		_petId = petId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		_name = name;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public double getPrice() {
		return _price;
	}

	@Override
	public void setPrice(double price) {
		_price = price;
	}

	@JSON
	@Override
	public Date getBirthday() {
		return _birthday;
	}

	@Override
	public void setBirthday(Date birthday) {
		_birthday = birthday;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Pet.class.getName()));
	}

	@Override
	public int getStatus() {
		return 0;
	}

	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws PortalException {
		if (!isInTrash()) {
			return null;
		}

		com.liferay.trash.kernel.model.TrashEntry trashEntry = com.liferay.trash.kernel.service.TrashEntryLocalServiceUtil.fetchEntry(getModelClassName(),
				getTrashEntryClassPK());

		if (trashEntry != null) {
			return trashEntry;
		}

		com.liferay.portal.kernel.trash.TrashHandler trashHandler = getTrashHandler();

		if (!Validator.isNull(trashHandler.getContainerModelClassName(
						getPrimaryKey()))) {
			ContainerModel containerModel = null;

			try {
				containerModel = trashHandler.getParentContainerModel(this);
			}
			catch (NoSuchModelException nsme) {
				return null;
			}

			while (containerModel != null) {
				if (containerModel instanceof TrashedModel) {
					TrashedModel trashedModel = (TrashedModel)containerModel;

					return trashedModel.getTrashEntry();
				}

				trashHandler = com.liferay.portal.kernel.trash.TrashHandlerRegistryUtil.getTrashHandler(trashHandler.getContainerModelClassName(
							containerModel.getContainerModelId()));

				if (trashHandler == null) {
					return null;
				}

				containerModel = trashHandler.getContainerModel(containerModel.getParentContainerModelId());
			}
		}

		return null;
	}

	@Override
	public long getTrashEntryClassPK() {
		return getPrimaryKey();
	}

	/**
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return com.liferay.portal.kernel.trash.TrashHandlerRegistryUtil.getTrashHandler(getModelClassName());
	}

	@Override
	public boolean isInTrash() {
		if (getStatus() == WorkflowConstants.STATUS_IN_TRASH) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInTrashContainer() {
		com.liferay.portal.kernel.trash.TrashHandler trashHandler = getTrashHandler();

		if ((trashHandler == null) ||
				Validator.isNull(trashHandler.getContainerModelClassName(
						getPrimaryKey()))) {
			return false;
		}

		try {
			ContainerModel containerModel = trashHandler.getParentContainerModel(this);

			if (containerModel == null) {
				return false;
			}

			if (containerModel instanceof TrashedModel) {
				return ((TrashedModel)containerModel).isInTrash();
			}
		}
		catch (Exception e) {
		}

		return false;
	}

	@Override
	public boolean isInTrashExplicitly() {
		if (!isInTrash()) {
			return false;
		}

		com.liferay.trash.kernel.model.TrashEntry trashEntry = com.liferay.trash.kernel.service.TrashEntryLocalServiceUtil.fetchEntry(getModelClassName(),
				getTrashEntryClassPK());

		if (trashEntry != null) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isInTrashImplicitly() {
		if (!isInTrash()) {
			return false;
		}

		com.liferay.trash.kernel.model.TrashEntry trashEntry = com.liferay.trash.kernel.service.TrashEntryLocalServiceUtil.fetchEntry(getModelClassName(),
				getTrashEntryClassPK());

		if (trashEntry != null) {
			return false;
		}

		return true;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Pet.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Pet toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Pet)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PetImpl petImpl = new PetImpl();

		petImpl.setUuid(getUuid());
		petImpl.setPetId(getPetId());
		petImpl.setGroupId(getGroupId());
		petImpl.setCompanyId(getCompanyId());
		petImpl.setUserId(getUserId());
		petImpl.setUserName(getUserName());
		petImpl.setCreateDate(getCreateDate());
		petImpl.setModifiedDate(getModifiedDate());
		petImpl.setName(getName());
		petImpl.setDescription(getDescription());
		petImpl.setPrice(getPrice());
		petImpl.setBirthday(getBirthday());

		petImpl.resetOriginalValues();

		return petImpl;
	}

	@Override
	public int compareTo(Pet pet) {
		int value = 0;

		value = getName().compareTo(pet.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Pet)) {
			return false;
		}

		Pet pet = (Pet)obj;

		long primaryKey = pet.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		PetModelImpl petModelImpl = this;

		petModelImpl._originalUuid = petModelImpl._uuid;

		petModelImpl._originalGroupId = petModelImpl._groupId;

		petModelImpl._setOriginalGroupId = false;

		petModelImpl._originalCompanyId = petModelImpl._companyId;

		petModelImpl._setOriginalCompanyId = false;

		petModelImpl._originalUserId = petModelImpl._userId;

		petModelImpl._setOriginalUserId = false;

		petModelImpl._setModifiedDate = false;

		petModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Pet> toCacheModel() {
		PetCacheModel petCacheModel = new PetCacheModel();

		petCacheModel.uuid = getUuid();

		String uuid = petCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			petCacheModel.uuid = null;
		}

		petCacheModel.petId = getPetId();

		petCacheModel.groupId = getGroupId();

		petCacheModel.companyId = getCompanyId();

		petCacheModel.userId = getUserId();

		petCacheModel.userName = getUserName();

		String userName = petCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			petCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			petCacheModel.createDate = createDate.getTime();
		}
		else {
			petCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			petCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			petCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		petCacheModel.name = getName();

		String name = petCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			petCacheModel.name = null;
		}

		petCacheModel.description = getDescription();

		String description = petCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			petCacheModel.description = null;
		}

		petCacheModel.price = getPrice();

		Date birthday = getBirthday();

		if (birthday != null) {
			petCacheModel.birthday = birthday.getTime();
		}
		else {
			petCacheModel.birthday = Long.MIN_VALUE;
		}

		return petCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", petId=");
		sb.append(getPetId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", birthday=");
		sb.append(getBirthday());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("ru.emdev.samples.petcatalog.model.Pet");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>petId</column-name><column-value><![CDATA[");
		sb.append(getPetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>birthday</column-name><column-value><![CDATA[");
		sb.append(getBirthday());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Pet.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Pet.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _petId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _description;
	private double _price;
	private Date _birthday;
	private long _columnBitmask;
	private Pet _escapedModel;
}