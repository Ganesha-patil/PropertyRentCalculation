package org.techhub.model;

import lombok.Getter;

import lombok.Setter;

@Setter
@Getter

public class PropertyModel {
    private int pid;
    private String propname;
    private String address;

 
    private LocationModel location;
    private PropCategoryModel category;
    
    
}

