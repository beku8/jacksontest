package com.fm.resttest;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FooBarTest {
	
	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Producer producer = new Producer();
		Foo foo = producer.foo();
		String json = mapper.writeValueAsString(foo);
		System.out.println(json);
		Foo foo2 = mapper.readValue(json, Foo.class);
		
		assertNotNull(foo2);
		assertEquals(foo.getId(), foo2.getId());
	}

}
