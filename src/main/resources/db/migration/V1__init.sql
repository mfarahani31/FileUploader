create table informations
(
    code             varchar(255) not null primary key,
    created_at       timestamp    not null,
    updated_at       timestamp    not null,
    code_list_Code   varchar(255),
    source           varchar(255),
    display_value    varchar(255),
    long_description varchar(255),
    from_date        varchar(255),
    to_date          varchar(255),
    sorting_priority varchar(255),
    version          int
);
commit;