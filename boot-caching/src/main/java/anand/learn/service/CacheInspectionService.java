package anand.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CacheInspectionService {
    @Autowired
    CacheManager cacheManager;

    public void printCacheContent(String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        if(null != cache) {
            System.out.println("Cache Contents:");
            System.out.println(Objects.requireNonNull(cache.getNativeCache()).toString());
        } else {
            System.out.println("No cache found for "+cacheName);
        }
    }
}
