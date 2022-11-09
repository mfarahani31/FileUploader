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

    @Column(name = "code_list_Code")
    private String codeListCode;

    @Column(name = "display_value")
    private String displayValue;

    @Column(name = "long_description")
    private String longDescription;

    @Column(name = "from_date")
    private String fromDate;

    @Column(name = "to_date")
    private String toDate;

    @Column(name = "sorting_priority")
    @Nullable
    private String sortingPriority;
}
