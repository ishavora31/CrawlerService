package com.example.web.crawler;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CrawlerServicetTest {
	
	@Autowired
	CrawlerService crawlerService;
	
	@Test
	public void requestTest() {
		Document doc = crawlerService.request("https://www.digitas.com", new ArrayList<String>());
		assertNotNull(doc);
	}
	
	
	@Test
	public void crawlTest() {
		XmlUrlSet xmlUrlSet = crawlerService.crawl(new XmlUrlSet(), "https://www.digitas.com", new ArrayList<String>(), new ArrayList<String>());
		assertNotNull(xmlUrlSet);
	}

}
