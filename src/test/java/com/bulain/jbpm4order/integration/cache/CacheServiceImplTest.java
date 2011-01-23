package com.bulain.jbpm4order.integration.cache;

import com.bulain.common.cache.CacheService;
import com.bulain.common.page.Page;
import com.bulain.common.test.ServiceTestCase;

public class CacheServiceImplTest extends ServiceTestCase {
	private CacheService cacheService;
	
	public static void main(String[] args){
		junit.textui.TestRunner.run(CacheServiceImplTest.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		cacheService = (CacheService) applicationContext.getBean("cacheService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		//cacheService.shutdown();
	}

	public void testCacheId(){
		Page page = new Page();
		page.setPage(10);
		page.setCount(100);
		
		boolean set = cacheService.set(Page.class, page.getPage(), page);
		assertTrue(set);
		
		Page get = (Page) cacheService.get(Page.class, page.getPage());
		assertNotNull(get);
		assertEquals(page.getLow(), get.getLow());
		assertEquals(page.getHigh(), get.getHigh());
		
		page = new Page();
		page.setPage(5);
		page.setCount(100);
		
		boolean add = cacheService.add(Page.class, page.getPage(), page);
		assertTrue(add);
		
		get = (Page) cacheService.get(Page.class, page.getPage());
		assertNotNull(get);
		assertEquals(page.getLow(), get.getLow());
		assertEquals(page.getHigh(), get.getHigh());
		
		page = new Page();
		page.setPage(5);
		page.setCount(1000);
		
		boolean replace = cacheService.replace(Page.class, page.getPage(), page);
		assertTrue(replace);
		
		get = (Page) cacheService.get(Page.class, page.getPage());
		assertNotNull(get);
		assertEquals(page.getLow(), get.getLow());
		assertEquals(page.getHigh(), get.getHigh());
		
		boolean delete = cacheService.delete(Page.class, page.getPage());
		assertTrue(delete);
	}
	
	public void testCacheKey(){

		Page page = new Page();
		page.setPage(10);
		page.setCount(100);
		
		boolean set = cacheService.set(Page.class, Integer.toString(page.getPage()), page);
		assertTrue(set);
		
		Page get = (Page) cacheService.get(Page.class, Integer.toString(page.getPage()));
		assertNotNull(get);
		assertEquals(page.getLow(), get.getLow());
		assertEquals(page.getHigh(), get.getHigh());
		
		page = new Page();
		page.setPage(5);
		page.setCount(100);
		
		boolean add = cacheService.add(Page.class, Integer.toString(page.getPage()), page);
		assertTrue(add);
		
		get = (Page) cacheService.get(Page.class, Integer.toString(page.getPage()));
		assertNotNull(get);
		assertEquals(page.getLow(), get.getLow());
		assertEquals(page.getHigh(), get.getHigh());
		
		page = new Page();
		page.setPage(5);
		page.setCount(1000);
		
		boolean replace = cacheService.replace(Page.class, Integer.toString(page.getPage()), page);
		assertTrue(replace);
		
		get = (Page) cacheService.get(Page.class, Integer.toString(page.getPage()));
		assertNotNull(get);
		assertEquals(page.getLow(), get.getLow());
		assertEquals(page.getHigh(), get.getHigh());
		
		boolean delete = cacheService.delete(Page.class, Integer.toString(page.getPage()));
		assertTrue(delete);
	
	}
}
