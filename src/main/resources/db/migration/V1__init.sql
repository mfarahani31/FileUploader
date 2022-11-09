create table informations
(
    code            varchar(255) not null primary key,
    created_at      timestamp    not null,
    updated_at      timestamp    not null,
    codeListCode    varchar(255),
    source          varchar(255),
    displayValue    varchar(255),
    longDescription varchar(255),
    fromDate        varchar(255),
    toDate          varchar(255),
    sortingPriority varchar(255),
    version         int
);
commit;