create
database user_db;

use
user_db;

create table user
(
    user_id       integer     not null primary key auto_increment,
    user_name     varchar(20) not null unique,
    password      varchar(20) not null,
    first_name    varchar(50) not null,
    last_name     varchar(50),
    date_of_birth datetime    not null
);

create table user_contact_number
(
    user_id       integer not null,
    mobile_number integer not null,
    foreign key (user_id) references user (user_id)
);