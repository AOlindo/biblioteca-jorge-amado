create table usuarios(
	id TEXT PRIMARY KEY UNIQUE NOT NULL,
	login TEXT NOT NULL UNIQUE,
	senha TEXT NOT NULL,
	role TEXT NOT NULL
);