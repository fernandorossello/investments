package com.fernandor.projects.investments.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Share extends Investment{

    @Column
    private String code;

    @Column
    private String market;

    @Column
    private String description;
}
