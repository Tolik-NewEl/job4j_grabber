create table if not exists post(
	id serial primary key,
	name varchar(100),
	link varchar(100) unique,
	description varchar(100),
	created timestamp
);