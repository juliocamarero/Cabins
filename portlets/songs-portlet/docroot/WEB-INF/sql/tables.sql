
create table Cabins_Band (
	bandId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	regionId LONG,
	countryId LONG,
	ownedCategoryId LONG,
	coverCategoryId LONG
);

create table Cabins_Song (
	songId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	threadId LONG,
	categoryId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	urlTitle VARCHAR(75) null
);