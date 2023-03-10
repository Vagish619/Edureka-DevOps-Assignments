package com.vagish.app;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class SampleJUnitServiceTest {
	SampleJUnitService sampleJUnitService = new SampleJUnitService();
	
	@Test
	public void getValueFromServiceTest() {
			
			assertEquals("JUnit Passed", 14, this.sampleJUnitService.getValueFromService(5));
		
	}
}
