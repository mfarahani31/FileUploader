package com.example.informationmangement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

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
    private String fromDate;

    @Column(name = "toDate")
    private String toDate;

    @Column(name = "sortingPriority")
    @Nullable
    private String sortingPriority;
}
