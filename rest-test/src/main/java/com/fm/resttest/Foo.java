package com.fm.resttest;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope=Foo.class)
public class Foo {
	
	private Integer id;
	private List<Bar> bars = new ArrayList<Bar>();
	private List<Bar> otherBars = new ArrayList<Bar>();
	
	public Foo(){
	}
	
	public Foo(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Bar> getBars() {
		return bars;
	}
	public void setBars(List<Bar> bars) {
		this.bars = bars;
	}
	public List<Bar> getOtherBars() {
		return otherBars;
	}
	public void setOtherBars(List<Bar> otherBars) {
		this.otherBars = otherBars;
	}
	
	
	
	

}
