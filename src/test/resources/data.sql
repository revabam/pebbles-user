merge into role (id, role)
values(1, 'manager');

merge into role (id, role)
values(2, 'trainer');

merge into role (id, role)
values(3, 'associate');

merge into status (id, status)
values(1, 'active');

merge into status (id, status)
values(2, 'inactive');

merge into bam_user (id, firstname, lastname, email, role_id, status_id)
values(1, 'Wezley', 'Singleton', 'wsingleton@revature.com', 2, 1);
merge into bam_user (id, firstname, lastname, email, role_id, status_id)
values(2, 'Blake', 'Kruppa', 'bkruppa@revature.com', 2, 1);
merge into bam_user (id, firstname, lastname, email, role_id, status_id)
values(3, 'Steve', 'Kelsey', 'skelsey@revature.com', 2, 1);
merge into bam_user (id, firstname, lastname, email, role_id, status_id)
values(4, 'Dylan', 'Mcbee', 'dmcbee@revature.com', 2, 1);