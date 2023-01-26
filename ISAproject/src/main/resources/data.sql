insert into authority(id,name) values (1,'ROLE_ADMIN');
insert into authority(id,name) values (2,'ROLE_REGISTERED_USER');
insert into authority(id,name) values (3,'ROLE_STUFF');

insert into user (id,role, username, password, first_name, last_name, email, mobile,enabled,last_password_reset_date) values (1,'Admin','truman@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Truman', 'Willis', 'truman@gmail.com', '305-555-0163',true,'1983-07-12 21:30:55.888');

insert into user (id,role, username, password, first_name, last_name, email, mobile,enabled,last_password_reset_date,adress, jmbg, sex,city,state, organization_information, profession) values (2,'RegisteredUser','isaisic587+1@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Raymond', 'Weaving', 'isaisic587+1@gmail.com', '305-555-0720',true,'1983-07-12 21:30:55.888', 'Ustanicka 6', '1528846975821', 'Male','Boston', ' Massachusetts', 'IMDB','Engineer');

insert into user (id,role, username, password, first_name, last_name, email, mobile,enabled,last_password_reset_date, adress, jmbg, sex,city,state, organization_information, profession)
values (9,'RegisteredUser','isaisic587+4@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Alen', 'Weaving', 'isaisic587+4@gmail.com', '305-555-0720',true,'1983-07-12 21:30:55.888', 'Futoska 3', '1528846975827', 'Male','Novi Sad', ' Srbija', 'Mocart','Engineer');

insert into user (id,role, username, password, first_name, last_name, email, mobile,enabled,last_password_reset_date,adress, jmbg, sex,city,state, organization_information, profession)
values (7,'RegisteredUser','isaisic587+2@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Aleksa', 'Aleksic', 'isaisic587+2@gmail.com', '306-555-333',true,'1983-07-12 21:30:55.888', 'Brace Popovic 6', '1528846975831', 'Male','Novi Sad', ' Srbija', 'FTN','Engineer');

insert into user (id,role, username, password, first_name, last_name, email, mobile,enabled,last_password_reset_date, adress, jmbg, sex,city,state, organization_information, profession)
values (8,'RegisteredUser','isaisic587+3@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Nikola', 'Nikolic', 'isaisic587+3@gmail.com', '307-558-0250',true,'1983-07-12 21:30:55.888', 'Drajzerova 8', '1528846975721', 'Male','Belgrade', ' Srbija', 'FON','Professor');

insert into user (id,role, username, password, first_name, last_name, email, mobile,adress,city,state,jmbg,sex,enabled,last_password_reset_date)
values (14,'RegisteredUser','arada@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Andjela', 'Radulovic', 'arada@gmail.com', '306-980-413','Bulevar Evrope 2','Vrsac','Serbia','0987895456221','Female',true,'1983-07-12 21:30:55.888');


--Dodajem 4 Usera koji ce predstvaljati administratore centra i osoblje
insert into user (id,role, username, password, first_name, last_name, email,  mobile,enabled,last_password_reset_date)
values (5,'Stuff','aleksa@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Aleksa', 'Aleksic', 'aleksa@gmail.com', '306-555-333',true,'1983-07-12 21:30:55.888');

insert into user (id,role, username, password, first_name, last_name, email, mobile,enabled,last_password_reset_date)
values (6,'Stuff','nikola@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Nikola', 'Nikolic', 'nikola@gmail.com', '307-558-0250',true,'1983-07-12 21:30:55.888');

insert into user (id,role, username, password, first_name, last_name, email,  mobile,enabled,last_password_reset_date)
values (10,'Stuff','milos@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Milos', 'Milic', 'milos@gmail.com', '306-555-333',true,'2014-07-14 22:34:57.888');

insert into user (id,role, username, password, first_name, last_name, email, mobile,enabled,last_password_reset_date)
values (11,'Stuff','pera@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Pera', 'Peric', 'pera@gmail.com', '320-589-0251',true,'2020-04-03 11:37:23.888');



insert into user_authority (user_id,authority_id) values (1,1);
insert into user_authority (user_id,authority_id) values (2,2);
insert into user_authority (user_id,authority_id) values (7,2);
insert into user_authority (user_id,authority_id) values (8,2);
insert into user_authority (user_id,authority_id) values (9,2);
insert into user_authority (user_id,authority_id) values (14,2);
insert into user_authority (user_id,authority_id) values (5,3);


insert into complaint (id,  title, content) values (1,  'Constantine''s Sword', 'Escuela de seducción');
insert into complaint (id, title, content) values (2,  'Adventures of Milo and Otis, The (Koneko monogatari)', 'Brother of Sleep (Schlafes Bruder)');
insert into complaint (id,  title, content) values (3,  'Loaded', 'Our Paradise (Notre paradis)');
insert into complaint (id,  title, content) values (4,'Robe, The', 'Men in Black II (a.k.a. MIIB) (a.k.a. MIB 2)');


insert into blood_center (id, center_name, address, city,  average_grade_centre, description, blooda,bloodb,bloodab,bloodo,start_work,end_work)
values (1, 'Mellie', '3041 Dottie Junction', 'Wan’an', 8, 'unavailable',1222,2,14,433,'2023-02-17 07:00:00','2023-02-17 12:00:00');
insert into blood_center (id, center_name, address, city,  average_grade_centre, description,blooda,bloodb,bloodab,bloodo,start_work,end_work)
values (2, 'Nert', '2 Westridge Pass', 'Novi Sad', 4, 'Cacatua tenuirostris',1222,2,14,433,'2023-02-17 08:00:00','2023-02-17 12:00:00');
insert into blood_center (id, center_name, address, city,  average_grade_centre, description,blooda,bloodb,bloodab,bloodo,start_work,end_work)
values (3, 'Leanna', '57 Havey Center', 'Pará de Minas', 7, 'Alouatta seniculus',1876,245,14,3,'2023-02-10 07:00:00','2023-02-10 11:15:00');
insert into blood_center (id, center_name, address, city,  average_grade_centre, description, blooda,bloodb,bloodab,bloodo,start_work,end_work)
values (4, 'Mother&Child Institut', 'Kramerova 122', 'Novi Sad', 10, 'unavailable',76,2,14,433,'2023-02-20 08:00:00','2023-02-20 17:00:00');
insert into blood_center (id, center_name, address, city,  average_grade_centre, description,blooda,bloodb,bloodab,bloodo,start_work,end_work)
values (5, 'Leona', '5th Avenue', 'New York', 9, 'Cacatua tenuirostris',22,52,18,4,'2023-02-20 07:00:00','2023-02-20 12:00:00');
insert into blood_center (id, center_name, address, city,  average_grade_centre, description,blooda,bloodb,bloodab,bloodo,start_work,end_work)
values (6, 'Novak', '23 Street', 'Monaco', 10, 'Alouatta seniculus',176,25,4,3,'2023-02-17 07:00:00','2023-02-17 11:30:00');

insert into blood_center (id, center_name, address, city,  average_grade_centre, description,blooda,bloodb,bloodab,bloodo,start_work,end_work)
values (7, 'Wake and Wonder', '6th Street', 'Chicago', 7, 'Alouatta seniculus',543,65,111,341,'2023-02-17 09:00:00','2023-02-17 11:45:00');
insert into blood_center (id, center_name, address, city,  average_grade_centre, description, blooda,bloodb,bloodab,bloodo,start_work,end_work)
values (8, 'Rey Az Mir Health', '104 Elm St', 'Boston', 10, 'unavailable',7611,209,1451,98,'2023-03-10 10:00:00','2023-03-10 12:00:00');
insert into blood_center (id, center_name, address, city,  average_grade_centre, description,blooda,bloodb,bloodab,bloodo,start_work,end_work)
values (9, '24hr Homecare', 'De Wittenkade', 'Amsterdam', 9, 'Cacatua tenuirostris',225,452,189,433,'2023-02-17 08:00:00','2023-02-17 10:30:00');
insert into blood_center (id, center_name, address, city,  average_grade_centre, description,blooda,bloodb,bloodab,bloodo,start_work,end_work)
values (10, 'Mend Life Medical', '49276 Bernard Wall', 'Sofia', 10, 'Alouatta seniculus',753,235,444,323,'2023-02-17 07:00:00','2023-02-17 12:00:00');



insert into registered_user (id, points, category, benefits) values (2, 0,'Redovan', 'Redovan');
insert into registered_user (id, points, category, benefits) values (7, 0,'Redovan', 'Redovan');
insert into registered_user (id, points, category, benefits) values (8, 1,'Redovan', 'Redovan');
insert into registered_user (id, points, category, benefits) values (9, 3,'Redovan', 'Redovan');
insert into registered_user (id, points, category, benefits) values (14, 0,'Pretplacen', 'Gift programi');



--Administratori centra i medicinsko osoblje
insert into stuff (id, blood_center_id, is_first_login) values (5, 1, false);
insert into stuff (id, blood_center_id, is_first_login) values (6, 2, false);
insert into stuff (id, blood_center_id, is_first_login) values (10, 1, false);
insert into stuff (id, blood_center_id, is_first_login) values (11, 2, false);

insert into calendar (id) values (1);
insert into calendar (id) values (2);
insert into calendar (id) values (3);

insert into survey (id, p1, p2, p3, p4, p5, p6, p7 ,registered_user_id)
values (1, 'DA','DA','DA','DA', 'DA','NE', 'NE',7);

insert into survey (id, p1, p2, p3, p4, p5, p6, p7 ,registered_user_id)
values (2, 'DA','DA','DA','DA', 'DA','NE', 'NE',8);

insert into survey (id, p1, p2, p3, p4, p5, p6, p7 ,registered_user_id)
values (3, 'DA','DA','DA','DA', 'DA','NE', 'NE',2);

insert into survey (id, p1, p2, p3, p4, p5, p6, p7 ,registered_user_id)
values (4, 'DA','DA','DA','DA', 'DA','NE', 'NE',2);

insert into survey (id, p1, p2, p3, p4, p5, p6, p7 ,registered_user_id)
values (5, 'DA','DA','DA','DA', 'DA','NE', 'NE',8);

insert into survey (id, p1, p2, p3, p4, p5, p6, p7 ,registered_user_id)
values (6, 'DA','DA','DA','DA', 'DA','NE', 'NE',8);

insert into survey (id, p1, p2, p3, p4, p5, p6, p7 ,registered_user_id)
values (7, 'DA','DA','DA','DA', 'DA','NE', 'NE',9);

insert into survey (id, p1, p2, p3, p4, p5, p6, p7 ,registered_user_id)
values (8, 'DA','DA','DA','DA', 'DA','NE', 'NE',9);

insert into survey (id, p1, p2, p3, p4, p5, p6, p7 ,registered_user_id)
values (9, 'DA','DA','DA','DA', 'DA','NE', 'NE',9);

insert into survey (id, p1, p2, p3, p4, p5, p6, p7 ,registered_user_id)
values (18, 'DA','DA','DA','DA', 'DA','NE', 'NE',14);



insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id)
values (1, '2022-12-1 8:30:00', 60, true, false ,'2023-02-10 07:00:00','2023-02-10 08:00:00', 1,3);

insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id, registered_user_id, survey_id)
values (2, '2018-02-20 07:00:00', 45, true, true, '2023-01-18 07:00:00','2023-01-18 07:45:00', 2,1,7,1);

insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id,registered_user_id,survey_id)
values (3, '2016-02-21 09:00:00', 15, true, true, '2022-02-17 07:00:00','2022-02-17 07:15:00', 3,3,8,2);

insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id,registered_user_id,survey_id)
values (99, '2020-02-01 09:00:00', 15, true, true, '2020-02-17 07:00:00','2020-02-17 07:15:00', 3,3,8,6);

insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id,registered_user_id,survey_id)
values (4, '2022-12-1 8:33:00', 25, false, false, '2023-02-03 07:00:00','2023-02-03 07:25:00', 1,1,2,3);


insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id)
values (5, '2022-12-1 8:34:00', 30, true, false, '2023-02-14 07:00:00','2023-02-14 07:30:00', 3,3);

insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id)
values (6, '2022-12-1 8:35:00', 45, true, false, '2023-02-22 07:00:00','2023-02-22 07:45:00', 1,3);

insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id)
values (7, '2022-12-1 8:36:00', 15, true, false, '2023-02-11 8:30:00','2023-02-11 8:45:00', 1,2);

insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id)
values (8, '2022-12-1 9:36:00', 15, true, false, '2023-02-10 11:30:00','2023-02-10 11:45:00', 1,2);

insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id,registered_user_id, survey_id)
values (9, '2022-12-1 9:36:00', 15, false, false, '2023-01-29 07:00:00','2023-01-29 07:15:00', 1,2,2,4);

insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id, registered_user_id, survey_id)
values (10, '2023-01-01 09:00:00', 45, false, true, '2023-01-04 12:00:00','2023-01-04 12:45:00', 3,3,9,7);

insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id, registered_user_id, survey_id)
values (11, '2023-01-01 09:10:00', 20, false, true, '2023-01-05 12:00:00','2023-01-05 12:20:00', 3,3,9,8);

insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id, registered_user_id, survey_id)
values (12, '2023-01-01 09:11:00', 35, false, true, '2023-01-06 12:00:00','2023-01-06 12:35:00', 3,3,9,9);


--Termini vezani za registronvane korisnikee -- vezane za studenta 3
--insert into donation_terms (id, date, duration, is_free, is_registered_user_come, reservation_start, reservation_end, profile_center_id, registered_user_id)
--values (23, '2019-11-22 11:00:00', 60, true, true, '2022-12-12 10:30:00','2022-12-12 11:30:00', 3, 14);

--insert into donation_terms (id, date, duration, is_free, is_registered_user_come, reservation_start, reservation_end, profile_center_id, registered_user_id)
--values (22, '2017-02-21 10:00:00', 45, true, false, '2021-11-11 09:30:00','2021-11-11 10:15:00', 3, 8);

--insert into donation_terms (id, date, duration, is_free, is_registered_user_come, reservation_start, reservation_end, profile_center_id, registered_user_id)
--values (21, '2017-02-21 10:00:00', 45, true, false, '2021-11-11 09:30:00','2021-11-11 10:15:00', 3, 14);


--insert into donation_terms (id, date, duration, is_free, is_registered_user_come, reservation_start, reservation_end, profile_center_id, registered_user_id,calendar_id)
--values (8, '2019-11-22 11:00:00', 60, false, true, '2022-12-12 10:30:00','2022-12-12 11:30:00', 3, 14,3);


--insert into donation_terms (id, date, duration, is_free, is_registered_user_come, reservation_start, reservation_end, profile_center_id, registered_user_id,calendar_id)
--values (9, '2017-02-21 10:00:00', 45, false, false, '2021-11-11 09:30:00','2021-11-11 10:15:00', 3, 14,1);

--insert into donation_terms (id, date, duration, is_free, is_registered_user_come, reservation_start, reservation_end, profile_center_id, registered_user_id,calendar_id)
--values (10, '2017-02-21 10:00:00', 45, false, false, '2021-11-11 09:30:00','2021-11-11 10:15:00', 3, 8,2);

insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id, registered_user_id, survey_id)
values (32, '2023-01-02 07:00:00', 45, false, true, '2023-01-17 07:00:00','2023-01-17 07:35:00', 3,3,8,5);
insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id)
values (27, '2018-02-16 10:00:00', 45, true, false, '2023-02-17 07:00:00','2023-02-17 07:20:00', 10,1);
insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id)
values (40, '2018-02-14 09:30:00', 45, true, false, '2023-02-18 07:30:00','2023-02-18 08:00:00', 9,1);
insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id)
values (41, '2018-02-14 09:30:00', 50, true, false, '2023-02-17 07:00:00','2023-02-17 08:00:00', 10,2);
insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id)
values (42, '2018-02-14 09:30:00', 60, true, false, '2023-02-17 07:00:00','2023-02-17 09:40:00', 9,1);
insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id)
values (43, '2018-02-14 09:30:00', 20, true, false, '2023-02-17 07:00:00','2023-02-17 07:20:00', 10,3);
insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id)
values (44, '2018-02-14 09:30:00', 90, true, false, '2023-02-17 07:00:00','2023-02-17 08:30:00', 10,1);
insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id)
values (45, '2018-02-14 09:30:00', 20, true, false, '2023-02-17 07:00:00','2023-02-17 07:20:00', 10,3);
insert into donation_terms (id, date, duration, free_term, is_registered_user_come, reservation_start, reservation_end, profile_center_id,calendar_id)
values (46, '2018-02-14 09:30:00', 30, true, false, '2023-02-17 07:00:00','2023-02-17 07:30:00', 10,1);
