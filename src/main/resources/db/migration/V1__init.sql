create sequence hibernate_sequence start with 1 increment by 1;

create table informations
(
    code            varchar(255) not null,
    created_at      timestamp    not null,
    updated_at      timestamp    not null,
    codeListCode    varchar(255),
    source          varchar(255),
    displayValue    varchar(255),
    longDescription varchar(255),
    fromDate        varchar(255),
    toDate          varchar(255),
    sortingPriority varchar(255),
    version         int,
    primary key (code),
);
commit;