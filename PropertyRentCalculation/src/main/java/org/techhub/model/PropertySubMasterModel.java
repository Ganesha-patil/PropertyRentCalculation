package org.techhub.model;

import lombok.*;

@Setter
@Getter
public class PropertySubMasterModel {

	private int aid; // this is for sub property
    private int pid; // main property
    private int area;
    private int ratepersqfeet;
}
