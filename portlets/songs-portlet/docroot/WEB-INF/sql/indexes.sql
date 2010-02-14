create unique index IX_16DCBDBA on Cabins_Band (groupId);

create index IX_D5362ABD on Cabins_Song (categoryId);
create index IX_7FA4C2DA on Cabins_Song (groupId);
create index IX_274FB2C7 on Cabins_Song (groupId, categoryId);
create unique index IX_54272937 on Cabins_Song (groupId, urlTitle);