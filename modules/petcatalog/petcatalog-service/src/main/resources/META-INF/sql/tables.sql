create table PetsCatalog_Pet (
	uuid_ VARCHAR(75) null,
	petId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	price DOUBLE,
	birthday DATE null
);