-------------BEGIN PROJECTS TABLE--------------
INSERT INTO projects(project_name,created_date,modified_date) VALUES ('New Look',NOW(),NOW())
INSERT INTO projects(project_name,created_date,modified_date) VALUES ('H&M',NOW(),NOW())
INSERT INTO projects(project_name,created_date,modified_date) VALUES ('Coach',NOW(),NOW())
INSERT INTO projects(project_name,created_date,modified_date) VALUES ('Argos',NOW(),NOW())
INSERT INTO projects(project_name,created_date,modified_date) VALUES ('Cardinal',NOW(),NOW())
-------------END PROJECTS TABLE--------------

-------------BEGIN PROJECTS TABLE--------------
INSERT INTO operations(name,created_date,modified_date) VALUES ('Anna Skärdin',NOW(),NOW())
INSERT INTO operations(name,created_date,modified_date) VALUES ('Palash',NOW(),NOW())
INSERT INTO operations(name,created_date,modified_date) VALUES ('Taran',NOW(),NOW())
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

-------------BEGIN USERS TABLE--------------
INSERT INTO users(access,created_date,deleted,email,enabled,modified_date,first_name,last_name,password,username,project) VALUES (0,NOW(),1,'saini.jitender@gmail.com',1,'2014-02-13 10:49:35.0','Jitender','Saini','5f4dcc3b5aa765d61d8327deb882cf99','jitendersaini',2)
INSERT INTO users(access,created_date,deleted,email,enabled,modified_date,first_name,last_name,password,username,project) VALUES (1,NOW(),1,'admin@gmail.com',1,'2014-02-13 10:49:35.0','James','Bond','5f4dcc3b5aa765d61d8327deb882cf99','admin',null)
INSERT INTO users(access,created_date,deleted,email,enabled,modified_date,first_name,last_name,password,username,project) VALUES (2,NOW(),1,'viewer@gmail.com',1,'2014-02-13 10:49:35.0','Viewer','User','5f4dcc3b5aa765d61d8327deb882cf99','viewer',1)
-------------END USERS TABLE--------------

-------------BEGIN TABS TABLE--------------
INSERT INTO tabs(tab_title,tab_url,users_access,created_date,modified_date) VALUES ('Work Env','users/workenv/action',0,NOW(),NOW())
INSERT INTO tabs(tab_title,tab_url,users_access,created_date,modified_date) VALUES ('Knowledge Transition','users/kt/action',0,NOW(),NOW())
INSERT INTO tabs(tab_title,tab_url,users_access,created_date,modified_date) VALUES ('Walkthrough','users/walkthrough/action',0,NOW(),NOW())
INSERT INTO tabs(tab_title,tab_url,users_access,created_date,modified_date) VALUES ('Release','users/release/action',0,NOW(),NOW())
INSERT INTO tabs(tab_title,tab_url,users_access,created_date,modified_date) VALUES ('Code Freeze','users/codefreeze/action',0,NOW(),NOW())
INSERT INTO tabs(tab_title,tab_url,users_access,created_date,modified_date) VALUES ('Testing','users/testing/action',0,NOW(),NOW())
INSERT INTO tabs(tab_title,tab_url,users_access,created_date,modified_date) VALUES ('Support Scope','users/supportscope/action',0,NOW(),NOW())
INSERT INTO tabs(tab_title,tab_url,users_access,created_date,modified_date) VALUES ('PGLS','users/pgls/action',0,NOW(),NOW())
INSERT INTO tabs(tab_title,tab_url,users_access,created_date,modified_date) VALUES ('Third Parties','users/thirdparties/action',0,NOW(),NOW())
INSERT INTO tabs(tab_title,tab_url,users_access,created_date,modified_date) VALUES ('Rehearsal','users/rehearsal/action',0,NOW(),NOW())
INSERT INTO tabs(tab_title,tab_url,users_access,created_date,modified_date) VALUES ('Access for AO','users/accessao/action',0,NOW(),NOW())
INSERT INTO tabs(tab_title,tab_url,users_access,created_date,modified_date) VALUES ('Process and Tools','users/processtools/action',0,NOW(),NOW())
INSERT INTO tabs(tab_title,tab_url,users_access,created_date,modified_date) VALUES ('Complete Status','users/completestatus/action',0,NOW(),NOW())

INSERT INTO tabs(tab_title,tab_url,users_access,created_date,modified_date) VALUES ('Create Projects','admin/projects/action',1,NOW(),NOW())
INSERT INTO tabs(tab_title,tab_url,users_access,created_date,modified_date) VALUES ('Create Status','admin/status/action',1,NOW(),NOW())
INSERT INTO tabs(tab_title,tab_url,users_access,created_date,modified_date) VALUES ('Create Operations','admin/operations/action',1,NOW(),NOW())
INSERT INTO tabs(tab_title,tab_url,users_access,created_date,modified_date) VALUES ('Create Users','admin/usrs/action',1,NOW(),NOW())
-------------END TABS TABLE--------------