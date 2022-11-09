insert into authority(id,name) values (1,'ROLE_ADMIN');
insert into authority(id,name) values (2,'ROLE_REGUSER');

insert into user (id,role, username, password, first_name, last_name, email, mobile,enabled,last_password_reset_date) values (1,'Admin','truman', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Truman', 'Willis', 'isamarkomarkovic99@gmail.com', '305-555-0163',true,'1983-07-12 21:30:55.888');
insert into user (id,role, username, password, first_name, last_name, email, mobile,enabled,last_password_reset_date) values (2,'RegisteredUser','raymond', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Raymond', 'Weaving', 'isamarkomarkovic99@gmail.com', '305-555-0720',true,'1983-07-12 21:30:55.888');

insert into user (id,role, username, password, first_name, last_name, email, mobile,enabled,last_password_reset_date)
values (7,'RegisteredUser','ulogovani_korisnik', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Aleksa', 'Aleksic', 'aleksic@gmail.com', '306-555-333',true,'1983-07-12 21:30:55.888');

insert into user (id,role, username, password, first_name, last_name, email, mobile,enabled,last_password_reset_date)
values (8,'RegisteredUser','ulogovani_korisnik2', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Nikola', 'Nikolic', 'nikolic@gmail.com', '307-558-0250',true,'1983-07-12 21:30:55.888');

insert into user_authority (user_id,authority_id) values (1,1);
insert into user_authority (user_id,authority_id) values (2,2);

insert into complaint (id,  title, content) values (1,  'Constantine''s Sword', 'Escuela de seducción');
insert into complaint (id, title, content) values (2,  'Adventures of Milo and Otis, The (Koneko monogatari)', 'Brother of Sleep (Schlafes Bruder)');
insert into complaint (id,  title, content) values (3,  'Loaded', 'Our Paradise (Notre paradis)');
insert into complaint (id,  title, content) values (4,'Robe, The', 'Men in Black II (a.k.a. MIIB) (a.k.a. MIB 2)');


insert into blood_center (id, center_name, address, city,  average_grade_centre, description, blooda,bloodb,bloodab,bloodo) values (1, 'Mellie', '3041 Dottie Junction', 'Wan’an', 8, 'unavailable',1222,2,14,433);
insert into blood_center (id, center_name, address, city,  average_grade_centre, description,blooda,bloodb,bloodab,bloodo) values (2, 'Nert', '2 Westridge Pass', 'Okotoks', 4, 'Cacatua tenuirostris',1222,2,14,433);
insert into blood_center (id, center_name, address, city,  average_grade_centre, description,blooda,bloodb,bloodab,bloodo) values (3, 'Leanna', '57 Havey Center', 'Pará de Minas', 7, 'Alouatta seniculus',1876,245,14,3);


insert into registered_user (id, points, category, benefits) values (1, 7,'Redovan', 'Redovan');
insert into registered_user (id, points, category, benefits) values (2, 3,'Redovan', 'Redovan');

insert into registered_user (id, points, category, benefits) values (7, 3,'Redovan', 'Redovan');
insert into registered_user (id, points, category, benefits) values (8, 33,'Redovan', 'Redovan');


insert into donation_terms (id, date, duration, is_free, reservation_start, reservation_end, profile_center_id)
values (1, '2016-02-20 06:30:00', 61, true, '2021-11-10 07:00:00','2021-11-12 13:00:00', 2);

insert into donation_terms (id, date, duration, is_free, reservation_start, reservation_end, profile_center_id)
values (2, '2018-02-20 06:30:00', 61, false, '2021-11-10 08:00:00','2021-11-12 14:00:00', 2);

insert into donation_terms (id, date, duration, is_free, reservation_start, reservation_end, profile_center_id)
values (3, '2016-02-20 06:30:00', 61, true, '2021-11-10 09:00:00','2021-11-12 15:00:00', 2);








