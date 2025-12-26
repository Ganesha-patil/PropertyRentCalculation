package org.techhub.model;

import lombok.Setter;
import lombok.Getter;

@Setter
@Getter

public class LocationModel
{
	private int locid;
	private String locname;
	
	private CityModel city;
}