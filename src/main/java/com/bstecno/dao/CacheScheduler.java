package com.bstecno.dao;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;


@Service
public class CacheScheduler {
    @Autowired
    BookDao bookDao;
    @Autowired
    CacheManager cacheManager;

    @PostConstruct
    public void init() {
        update();scheduleUpdateAsync
        ();
    }

    private void scheduleUpdateAsync() {
		// TODO Auto-generated method stub
		
	}

	public void update() {
        for (Book book : bookDao.findAll()) {
            cacheManager.getCache("books").put(book.getIsbn(), book);
        }
    }
}