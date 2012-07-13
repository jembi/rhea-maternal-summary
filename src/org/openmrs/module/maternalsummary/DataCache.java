package org.openmrs.module.maternalsummary;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class DataCache {
	
	private static final String CACHE = "Maternal Summary Data Cache";
	private static CacheManager CACHE_MANAGER;
	
	static synchronized void launch() {
		CACHE_MANAGER = CacheManager.create();
		if (CACHE_MANAGER.cacheExists(CACHE))
			CACHE_MANAGER.removeCache(CACHE);
		CACHE_MANAGER.addCache(CACHE);
	}

	static synchronized void shutdown() {
		CACHE_MANAGER.shutdown();
	}
	
	public static synchronized Object get(Object key) {
		Element e = getCache().get(key);
		return e!=null ? e.getObjectValue() : null;
	}
	
	public static synchronized void put(Object key, Object value) {
		getCache().put(new Element(key, value));
	}
	
	private static Cache getCache() {
		if (CACHE_MANAGER==null)
			launch();
		return CACHE_MANAGER.getCache(CACHE);
	}
}
