
create table specialty_tbl (
    id bigserial not null,
    name varchar(255),
    status varchar(255),
    primary key (id)
                           );

create table skills_tbl (
    id bigserial not null,
    name varchar(255),
    status varchar(255),
    primary key (id)
                        );

create table developers_tbl (
    id bigserial not null,
    firstName varchar(255),
    lastName varchar(255),
    status varchar(255),
    specialtyId bigint,
    primary key (id)
                            );

create table developers_tbl_skills_tbl (
    Developer_id bigint not null,
    skills_id bigint not null,
    primary key (Developer_id, skills_id)
                                       );

alter table if exists developers_tbl_skills_tbl
    add constraint UK_l7ngqbssgq02s2p3cxgmk8jb3 unique (skills_id);

alter table if exists developers_tbl
    add constraint FKjw6pfgemsw6plo0vgn0h9ne5i foreign key (specialtyId) references specialty_tbl;

alter table if exists developers_tbl_skills_tbl
    add constraint FKbwr6gb8qn36v8cfjuki147yph foreign key (skills_id) references skills_tbl;

alter table if exists developers_tbl_skills_tbl
    add constraint FKgtd8wwm44cgx18u797wiao4n1 foreign key (Developer_id) references developers_tbl;
