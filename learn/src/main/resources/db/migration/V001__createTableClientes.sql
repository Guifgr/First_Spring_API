create table client (
                         id bigint not null auto_increment,
                         name varchar(60) not null,
                         email varchar(200) not null,
                         phone varchar(40) not null,
                         picture varchar(200),

                         primary key (id)
);