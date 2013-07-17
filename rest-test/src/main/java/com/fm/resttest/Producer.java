package com.fm.resttest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Producer {
	
	@RequestMapping(value = "/identifiable", method = RequestMethod.GET)
	@ResponseBody
	public Identifiable identifiable(){
		Identifiable ob1 = new Identifiable();
		  ob1.setValue(13);
		  Identifiable ob2 = new Identifiable();
		  ob2.setValue(42);
		  // link as a cycle:
		  ob1.setNext(ob2);
		  ob2.setNext(ob1);
		return ob1;
	}
	
	@RequestMapping(value = "/foo", method = RequestMethod.GET)
	@ResponseBody
	public Foo foo(){
		Foo foo1 = new Foo(1);
		
		Bar bar1 = new Bar(1);
		Bar bar2 = new Bar(2);
		// this is another bar which is supposed to be "equal" to bar1
		// due to the same ID and 
		// Bar class' equals() method will return true.
		Bar anotherBar1 = new Bar(1);
		
		foo1.getBars().add(bar1);
		foo1.getBars().add(bar2);
		// this anotherBar1 object will confuse the serializer.
		foo1.getOtherBars().add(anotherBar1);
		foo1.getOtherBars().add(bar2);
		return foo1;
	}

}
