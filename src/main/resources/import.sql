-------------BEGIN USERS TABLE--------------
INSERT INTO users(access,created_date,deleted,email,enabled,modified_date,first_name,last_name,password,username) VALUES (0,NOW(),1,'saini.jitender@gmail.com',1,'2014-02-13 10:49:35.0','Jitender','Saini','5f4dcc3b5aa765d61d8327deb882cf99','jitendersaini')
INSERT INTO users(access,created_date,deleted,email,enabled,modified_date,first_name,last_name,password,username) VALUES (1,NOW(),1,'admin@gmail.com',1,'2014-02-13 10:49:35.0','James','Bond','5f4dcc3b5aa765d61d8327deb882cf99','admin')
INSERT INTO users(access,created_date,deleted,email,enabled,modified_date,first_name,last_name,password,username) VALUES (2,NOW(),1,'viewer@gmail.com',1,'2014-02-13 10:49:35.0','Viewer','User','5f4dcc3b5aa765d61d8327deb882cf99','viewer')
-------------END USERS TABLE--------------

-------------BEGIN PROJECTS TABLE--------------
INSERT INTO projects(project_name,created_date,modified_date,created_by,modified_by) VALUES ('New Look',NOW(),NOW(),2,2)
INSERT INTO projects(project_name,created_date,modified_date,created_by,modified_by) VALUES ('H&M',NOW(),NOW(),2,2)
INSERT INTO projects(project_name,created_date,modified_date,created_by,modified_by) VALUES ('Coach',NOW(),NOW(),2,2)
INSERT INTO projects(project_name,created_date,modified_date,created_by,modified_by) VALUES ('Argos',NOW(),NOW(),2,2)
INSERT INTO projects(project_name,created_date,modified_date,created_by,modified_by) VALUES ('Cardinal',NOW(),NOW(),2,2)
-------------END PROJECTS TABLE--------------

-------------BEGIN PROJECTS TABLE--------------
INSERT INTO operations(userid,name,created_date,modified_date) VALUES ('j.saini','Jitender Saini',NOW(),NOW())
INSERT INTO operations(userid,name,created_date,modified_date) VALUES ('g.b.arora','Gaurav Arora',NOW(),NOW())
INSERT INTO operations(userid,name,created_date,modified_date) VALUES ('a.b','A B',NOW(),NOW())
INSERT INTO operations(userid,name,created_date,modified_date) VALUES ('b.a','B A',NOW(),NOW())
-------------END PROJECTS TABLE--------------


-------------BEGIN PRIORITES TABLE--------------
INSERT INTO priorities(priority,created_date,modified_date) VALUES ('P1',NOW(),NOW())
INSERT INTO priorities(priority,created_date,modified_date) VALUES ('P2',NOW(),NOW())
INSERT INTO priorities(priority,created_date,modified_date) VALUES ('P3',NOW(),NOW())
INSERT INTO priorities(priority,created_date,modified_date) VALUES ('P4',NOW(),NOW())
-------------END PRIORITES TABLE--------------

-------------BEGIN STATUS TABLE--------------
INSERT INTO status(status,created_date,modified_date) VALUES ('Signed Off',NOW(),NOW())
INSERT INTO status(status,created_date,modified_date) VALUES ('Started',NOW(),NOW())
INSERT INTO status(status,created_date,modified_date) VALUES ('Not Started',NOW(),NOW())
-------------END STATUS TABLE--------------