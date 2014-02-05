package com.roanis.tdd.samples.userprofiling;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import atg.servlet.ServletUtil;

import com.roanis.tdd.base.userprofiling.BaseProfileTest;

@RunWith(JUnit4.class)
public class ProfileToolsTest extends BaseProfileTest {
    
    String baseUserEmailAddress;
    
    @Override
    public void setUp() throws Exception {    	
    	super.setUp();
    	
    	baseUserEmailAddress = (String) ServletUtil.getCurrentUserProfile().getPropertyValue(getProfileTestHelper().getPropertyManager().getEmailAddressPropertyName());
    }
	
    @Override
    public void tearDown() throws Exception {
    	baseUserEmailAddress = null;
    	super.tearDown();
    }
	
	@Test
	public void userExists(){
		assertNotNull(getProfileTestHelper().getProfileTools().getItemFromEmail(baseUserEmailAddress));
	}
	
	@Test
	public void noSuchUser(){
		assertNull(getProfileTestHelper().getProfileTools().getItemFromEmail("noSuchEmail@nosuchdomain.com"));
	}
		
}
