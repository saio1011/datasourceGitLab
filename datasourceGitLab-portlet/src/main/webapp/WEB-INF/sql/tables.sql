create table datasourceGitLab_Commit (
	commitId VARCHAR(75) not null primary key,
	authorName VARCHAR(75) null,
	authorEmail VARCHAR(75) null,
	titleCommit VARCHAR(75) null,
	createdAt VARCHAR(75) null,
	projectName VARCHAR(75) null
);

create table datasourceGitLab_Contributor (
	contributorId LONG not null primary key,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	commits INTEGER,
	locAdditions INTEGER,
	locDeletions INTEGER,
	projectName VARCHAR(75) null
);