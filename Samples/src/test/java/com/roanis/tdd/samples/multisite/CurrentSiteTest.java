package com.roanis.tdd.samples.multisite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import atg.multisite.SiteContextManager;

import com.roanis.tdd.base.multisite.BaseSiteTest;
import com.roanis.tdd.base.multisite.SiteTestConstants;

@RunWith(JUnit4.class)
public class CurrentSiteTest extends BaseSiteTest {
	
	@Test
	public void currentSiteExists() {		
		assertNotNull(SiteContextManager.getCurrentSite());
	}
	
	@Test
	public void baseSiteIsCurrent(){		
		assertEquals(SiteTestConstants.BASE_SITE_ID, SiteContextManager.getCurrentSiteId());
	}
	
	@Test
	public void isEnabled(){
		assertTrue((Boolean) SiteContextManager.getCurrentSite().getPropertyValue(SiteTestConstants.ENABLED_PROPERTY_NAME));
	}

}
