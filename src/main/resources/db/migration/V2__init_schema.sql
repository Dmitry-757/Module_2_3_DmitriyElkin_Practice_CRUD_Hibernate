create table specialty_tbl
(
    id     bigserial not null,
    name   varchar(255),
    status varchar(255),
    primary key (id)
);

create table skills_tbl
(
    id     bigserial not null,
    name   varchar(255),
    status varchar(255),
    primary key (id)
);

create table developers_tbl
(
    id           bigserial not null,
    firstName    varchar(255),
    lastName     varchar(255),
    status       varchar(255),
    specialty_id bigint,
    primary key (id)
);

create table developers_skills
(
    developer_ID bigint not null,
    skill_ID     bigint not null,
    primary key (developer_ID, skill_ID)
);

alter table if exists developers_tbl
    add constraint FK8nq5o6yvnb5t29cgboauasob3 foreign key (specialty_id) references specialty_tbl;
alter table if exists developers_skills
    add constraint UK_bo7u2vlnfl8l2v6hqjicmpnxt unique (skill_ID);
alter table if exists developers_skills
    add constraint FKclctcstlww56phuarm2650xx5 foreign key (skill_ID) references skills_tbl;
alter table if exists developers_skills
    add constraint FKmpbsf24n9kkdb6qndb6sfnsw9 foreign key (developer_ID) references developers_tbl;

