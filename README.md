# Web Crawler Project
This is a sample Spring Boot (version 2.5.0) application that can be used as a base for creating Web Crawler Service. This Service is simple application that is used for crawling of particular website and provides XML Structured Sitemap which includes all the Links of the same domain excluding the external links like Google or Twitter and all the static images.
## How to Run
This application is packaged as a war which has embedded Tomcat. You can run this service using “java –jar” command. Below are the steps to run this service on the local machine.
*	Clone this repository
*	Make sure you are using JDK 1.8 and Maven 4.x
*	You can start the application by below command:
```shell
java –jar target/CrawlerApp-0.0.1-SNAPSHOT.war
```

After running the application you will be able to see below log:
```shell
2021-05-23 16:03:51.131  INFO 15368 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-05-23 16:03:51.140  INFO 15368 --- [           main] c.e.web.crawler.CrawlerApplication       : Started CrawlerApplication in 1.834 seconds (JVM running for 2.223)
```

## Configuration
You can change the Crawling Link and to how much links we want to crawl from the `application.properties` file

## REST API for Crawling
Endpoint: http://localhost:8080/crawl 

Response: HTTP 200

Response-type: application/XML
```shell
<ns2:urlset xmlns:ns2="http://www.sitemaps.org/schemas/sitemap/0.9">
<url>
<address>https://www.digitas.com</address>
</url>
</ns2:urlset>
```
