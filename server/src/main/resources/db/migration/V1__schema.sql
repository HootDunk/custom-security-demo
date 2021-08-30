DROP TABLE if EXISTS member_profile;
CREATE TABLE member_profile(
    id varchar PRIMARY KEY,
    first_name varchar,
    last_name varchar,
    work_email varchar,
    password varchar
);

insert into member_profile
    (id, first_name, last_name, work_email, password)
values
    ('01b7d769-9fa2-43ff-95c7-f3b950a27bf9','Josh', 'Hootman', 'hootmanj@objectcomputing.com', '1234');

insert into member_profile
    (id, first_name, last_name, work_email, password)
values
    ('2559a257-ae84-4076-9ed4-3820c427beeb','Zach', 'Brown', 'brownz@objectcomputing.com', '1234');

insert into member_profile
    (id, first_name, last_name, work_email, password)
values
    ('802cb1f5-a255-4236-8719-773fa53d79d9','Mohit', 'Bhatia', 'bhatiam@objectcomputing.com', '1234');

insert into member_profile
    (id, first_name, last_name, work_email, password)
values
    ('7a6a2d4e-e435-4ec9-94d8-f1ed7c779498','Jesse', 'Hanner', 'hannerj@objectcomputing.com', '1234');

insert into member_profile
    (id, first_name, last_name, work_email, password)
values
    ('22f7a91e-44c2-4a9a-8020-26e8c6ec5ef0','Jon', 'Doe', 'jd@objectcomputing.com', '1234');

drop table if exists roles;
CREATE TABLE roles(
    id varchar primary key,
    role varchar,
    description varchar
);

insert into roles
    (id, role, description)
values
    ('cda41eed-70ea-4d3f-a9d7-cd0c5158eb5f', 'Admin', 'Admins have the highest level of authorization');

insert into roles
    (id, role, description)
values
    ('ba42d181-3c5b-4ee3-938d-be122c314bee', 'PDL', 'PDLs can view and edit PDL data');

insert into roles (id, role, description)
values('e5449026-cd9a-4bed-a648-fe3ad9382831', 'Team Lead', 'Team Leads can make changes to teams and query team skills');

insert into roles
    (id, role, description)
values
    ('06cd3202-a209-4ae1-a49a-10395fbe3548', 'Member', 'Members have the lowest level of access');


drop table if exists member_roles;
CREATE TABLE member_roles(
    role_id varchar references roles(id),
    member_id varchar references member_profile(id),
    primary key(role_id, member_id)
);

insert into member_roles
    (role_id, member_id)
values
    ('06cd3202-a209-4ae1-a49a-10395fbe3548','01b7d769-9fa2-43ff-95c7-f3b950a27bf9');


insert into member_roles
    (role_id, member_id)
values
    ('06cd3202-a209-4ae1-a49a-10395fbe3548','2559a257-ae84-4076-9ed4-3820c427beeb');
insert into member_roles
    (role_id, member_id)
values
    ('e5449026-cd9a-4bed-a648-fe3ad9382831','2559a257-ae84-4076-9ed4-3820c427beeb');


insert into member_roles
    (role_id, member_id)
values('06cd3202-a209-4ae1-a49a-10395fbe3548','802cb1f5-a255-4236-8719-773fa53d79d9');
insert into member_roles
    (role_id, member_id)
values
    ('ba42d181-3c5b-4ee3-938d-be122c314bee','802cb1f5-a255-4236-8719-773fa53d79d9');
insert into member_roles
    (role_id, member_id)
values
    ('e5449026-cd9a-4bed-a648-fe3ad9382831','802cb1f5-a255-4236-8719-773fa53d79d9');


insert into member_roles
    (role_id, member_id)
values
    ('06cd3202-a209-4ae1-a49a-10395fbe3548','7a6a2d4e-e435-4ec9-94d8-f1ed7c779498');
insert into member_roles
    (role_id, member_id)
values
    ('cda41eed-70ea-4d3f-a9d7-cd0c5158eb5f','7a6a2d4e-e435-4ec9-94d8-f1ed7c779498');


insert into member_roles
    (role_id, member_id)
values
    ('cda41eed-70ea-4d3f-a9d7-cd0c5158eb5f','22f7a91e-44c2-4a9a-8020-26e8c6ec5ef0');

drop table if exists permissions;
CREATE TABLE permissions(
    id varchar primary key,
    permission varchar
);

insert into permissions
    (id, permission)
values
    ('0f299d11-df47-406f-a426-8e3160eaeb21', 'CAN_VIEW_ORGANIZATION_MEMBERS');
insert into permissions
    (id, permission)
values
    ('439ad8a8-500f-4f3f-963b-a86437d5820a', 'CAN_CREATE_AND_DELETE_ORGANIZATION_MEMBERS');


insert into permissions
    (id, permission)
values
    ('c7b4d5e0-09ba-479a-8c40-ca9bbd8f217a', 'CAN_EDIT_TEAM_MEMBERSHIP');

insert into permissions
    (id, permission)
values
    ('20bf1ddb-53a0-436e-99dc-802c1199e282', 'CAN_VIEW_PDL_DATA');


drop table if exists role_permissions;
CREATE TABLE role_permissions(
    role_id varchar references roles(id),
    permission_id varchar references permissions(id),
    primary key(role_id, permission_id)
);

insert into role_permissions
    (role_id, permission_id)
values
    ('06cd3202-a209-4ae1-a49a-10395fbe3548', '0f299d11-df47-406f-a426-8e3160eaeb21');

insert into role_permissions
    (role_id, permission_id)
values
    ('cda41eed-70ea-4d3f-a9d7-cd0c5158eb5f', '439ad8a8-500f-4f3f-963b-a86437d5820a');

insert into role_permissions
    (role_id, permission_id)
values
    ('ba42d181-3c5b-4ee3-938d-be122c314bee', '20bf1ddb-53a0-436e-99dc-802c1199e282');

insert into role_permissions
    (role_id, permission_id)
values
    ('e5449026-cd9a-4bed-a648-fe3ad9382831', 'c7b4d5e0-09ba-479a-8c40-ca9bbd8f217a');



insert into role_permissions
    (role_id, permission_id)
values
    ('cda41eed-70ea-4d3f-a9d7-cd0c5158eb5f', '20bf1ddb-53a0-436e-99dc-802c1199e282');
insert into role_permissions
    (role_id, permission_id)
values
    ('cda41eed-70ea-4d3f-a9d7-cd0c5158eb5f', 'c7b4d5e0-09ba-479a-8c40-ca9bbd8f217a');
insert into role_permissions
    (role_id, permission_id)
values
    ('cda41eed-70ea-4d3f-a9d7-cd0c5158eb5f', '0f299d11-df47-406f-a426-8e3160eaeb21');




