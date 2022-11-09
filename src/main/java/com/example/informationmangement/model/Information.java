package com.example.informationmangement.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "informations")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Information extends BaseEntity implements Serializable {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "source")
    private String source;

    @Column(name = "codeListCode")
    private String codeListCode;

    @Column(name = "displayValue")
    private String displayValue;

    @Column(name = "longDescription")
    private String longDescription;

    @Column(name = "fromDate")
    private Date fromDate;

    @Column(name = "toDate")
    private Date toDate;

    @Column(name = "sortingPriority")
    private int sortingPriority;
}
