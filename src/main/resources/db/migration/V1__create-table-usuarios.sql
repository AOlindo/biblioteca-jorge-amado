create table usuarios(
	id bigint not null auto_increment,
	login TEXT NOT NULL UNIQUE,
	senha TEXT NOT NULL,
	role TEXT NOT NULL
 primary key(id)
);