create index IX_FC930CDD on PetsCatalog_Pet (companyId);
create index IX_BA43269F on PetsCatalog_Pet (groupId);
create index IX_13713A5 on PetsCatalog_Pet (userId);
create index IX_DEDD339F on PetsCatalog_Pet (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_AB0C15E1 on PetsCatalog_Pet (uuid_[$COLUMN_LENGTH:75$], groupId);