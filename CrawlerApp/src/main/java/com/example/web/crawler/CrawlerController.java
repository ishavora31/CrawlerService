package com.example.web.crawler;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CrawlerController {

	@Value("${crawling.url}")
	private String mainCrawlingUrl;
	
	@Autowired
	private CrawlerService crawlerService;

	@RequestMapping(value = "/crawl", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public XmlUrlSet crawl() {
		return crawlerService.crawl(new XmlUrlSet(), mainCrawlingUrl, new ArrayList<String>(), new ArrayList<String>());
	}

}