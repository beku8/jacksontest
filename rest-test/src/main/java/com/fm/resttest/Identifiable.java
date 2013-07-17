package com.fm.resttest;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Identifiable {

	private int value;

    private Identifiable next;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Identifiable getNext() {
		return next;
	}

	public void setNext(Identifiable next) {
		this.next = next;
	}
    
    
    
    
    
}
