-------------BEGIN USERS TABLE--------------
INSERT INTO users(access,created_date,deleted,email,enabled,modified_date,first_name,last_name,password,username) VALUES (1,'2013-08-28 13:51:27.0',1,'saini.jitender@gmail.com',1,'2014-02-13 10:49:35.0','Jitender','Saini','5f4dcc3b5aa765d61d8327deb882cf99','jitendersaini')
INSERT INTO users(access,created_date,deleted,email,enabled,modified_date,first_name,last_name,password,username) VALUES (1,'2013-08-28 13:51:27.0',1,'admin@gmail.com',1,'2014-02-13 10:49:35.0','James','Bond','5f4dcc3b5aa765d61d8327deb882cf99','admin')
-------------END USERS TABLE--------------

-------------BEGIN PROJECTS TABLE--------------
INSERT INTO projects(project_name,created_date,modified_date) VALUES ('New Look','2013-08-28 13:51:27.0','2013-08-28 13:51:27.0')
INSERT INTO projects(project_name,created_date,modified_date) VALUES ('H&M','2013-08-28 13:51:27.0','2013-08-28 13:51:27.0')
INSERT INTO projects(project_name,created_date,modified_date) VALUES ('Coach','2013-08-28 13:51:27.0','2013-08-28 13:51:27.0')
INSERT INTO projects(project_name,created_date,modified_date) VALUES ('Argos','2013-08-28 13:51:27.0','2013-08-28 13:51:27.0')
INSERT INTO projects(project_name,created_date,modified_date) VALUES ('Cardinal','2013-08-28 13:51:27.0','2013-08-28 13:51:27.0')
-------------END PROJECTS TABLE--------------

-------------BEGIN PROJECTS TABLE--------------
INSERT INTO operations(userid,name,created_date,modified_date) VALUES ('j.saini','Jitender Saini','2013-08-28 13:51:27.0','2013-08-28 13:51:27.0')
INSERT INTO operations(userid,name,created_date,modified_date) VALUES ('g.b.arora','Gaurav Arora','2013-08-28 13:51:27.0','2013-08-28 13:51:27.0')
INSERT INTO operations(userid,name,created_date,modified_date) VALUES ('a.b','A B','2013-08-28 13:51:27.0','2013-08-28 13:51:27.0')
INSERT INTO operations(userid,name,created_date,modified_date) VALUES ('b.a','B A','2013-08-28 13:51:27.0','2013-08-28 13:51:27.0')
-------------END PROJECTS TABLE--------------


-------------BEGIN PRIORITES TABLE--------------
INSERT INTO priorities(priority,created_date,modified_date) VALUES ('P1','2013-08-28 13:51:27.0','2013-08-28 13:51:27.0')
INSERT INTO priorities(priority,created_date,modified_date) VALUES ('P2','2013-08-28 13:51:27.0','2013-08-28 13:51:27.0')
INSERT INTO priorities(priority,created_date,modified_date) VALUES ('P3','2013-08-28 13:51:27.0','2013-08-28 13:51:27.0')
INSERT INTO priorities(priority,created_date,modified_date) VALUES ('P4','2013-08-28 13:51:27.0','2013-08-28 13:51:27.0')
-------------END PRIORITES TABLE--------------

-------------BEGIN STATUS TABLE--------------
INSERT INTO status(status,created_date,modified_date) VALUES ('Signed Off','2013-08-28 13:51:27.0','2013-08-28 13:51:27.0')
INSERT INTO status(status,created_date,modified_date) VALUES ('Started','2013-08-28 13:51:27.0','2013-08-28 13:51:27.0')
INSERT INTO status(status,created_date,modified_date) VALUES ('Not Started','2013-08-28 13:51:27.0','2013-08-28 13:51:27.0')
-------------END STATUS TABLE--------------