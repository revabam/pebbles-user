/*
Insert mock data into the bam_user table
*/
insert into bam_user (id, firstname, lastname, email, role_id, status_id)
values((SELECT bam_user_seq.nextVal FROM dual), 'Wezley', 'Singleton', 'wsingleton@revature.com', 2, 1);
insert into bam_user (id, firstname, lastname)
values((SELECT bam_user_seq.nextVal FROM dual), 'Blake', 'Lavla', 'blakel@revature.com', 2, 1);
insert into bam_user (id, firstname, lastname)
values((SELECT bam_user_seq.nextVal FROM dual), 'Steve', 'Sparky', 'steves@revature.com', 2, 1);
insert into bam_user (id, firstname, lastname)
values((SELECT bam_user_seq.nextVal FROM dual), 'Dillon', 'Qsee', 'dillonq@revature.com', 2, 1);

/*
Create role and status lookup tables
*/
CREATE TABLE role
(id INTEGER NOT NULL,
role VARCHAR(25) UNIQUE,
PRIMARY KEY (id))

insert into role (id, role)
values(1, 'manager');

insert into role (id, role)
values(2, 'trainer');

insert into role (id, role)
values(3, 'associate');


CREATE TABLE status
(id INTEGER NOT NULL,
status VARCHAR(25) UNIQUE,
PRIMARY KEY (id))

insert into status (id, role)
values(1, 'active');

insert into status (id, role)
values(2, 'inactive');
