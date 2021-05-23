package com.example.web.crawler;

import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CrawlerService {
	
	@Value("${crawling.url}")
	private String mainCrawlingUrl;
	
	@Value("${crawl.count}")
	private int numberOfUrlToCrawl;
	
	public XmlUrlSet crawl(XmlUrlSet xmlUrlSet, String crawlingUrl, ArrayList<String> visitedUrl,
			ArrayList<String> visitedImages) {
		if(CrawlerApplication.counter <= numberOfUrlToCrawl) {

		Document doc = request(crawlingUrl, visitedUrl);
		xmlUrlSet.addUrl(new XmlUrl(crawlingUrl));
		visitedUrl.add(crawlingUrl);

		if (doc != null) {
			CrawlerApplication.counter++;
			for (Element element : doc.getElementsByTag("img")) {
				String newImage = element.absUrl("src");
				if (!visitedImages.contains(newImage)) {
					crawl(xmlUrlSet, newImage, visitedUrl, visitedImages);
				}
			}
			for (Element element : doc.select("a[href]")) {
				String newLink = element.absUrl("href");
				if (!visitedUrl.contains(newLink) && newLink.contains(mainCrawlingUrl)) {
					crawl(xmlUrlSet, newLink, visitedUrl, visitedImages);
				}
			}
		}
		}
		return xmlUrlSet;
	}

	public Document request(String url, ArrayList<String> v) {
		try {
			Connection con = Jsoup.connect(url);
			Document doc = con.get();
			if (con.response().statusCode() == HttpStatus.OK.value()) {
				System.out.println("Link:" + url);
			}
			return doc;
		} catch (Exception e) {
			return null;
		}
	}
}
