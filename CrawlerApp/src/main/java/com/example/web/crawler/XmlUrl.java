package com.example.web.crawler;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(value = XmlAccessType.NONE)
@XmlRootElement(name = "url")
public class XmlUrl {

    @XmlElement
    private String address;


    public XmlUrl() {
    }

    public XmlUrl(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

}