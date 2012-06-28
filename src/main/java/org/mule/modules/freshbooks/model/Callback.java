package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://www.freshbooks.com/api/", name = "callback")
@XmlAccessorType(XmlAccessType.FIELD)
public class Callback {
    @XmlElement(name = "callback_id", namespace = "http://www.freshbooks.com/api/", required = false)
    private String id;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = true)
    private String event;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = true)
    private String uri;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String verifier;
    //Boolean but it sends only 0 or 1
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Integer verified;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String updated;
    
    public String getUpdated() {
        return updated;
    }
    
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getVerified() {
        return verified != null && verified == 1;
    }

    public void setVerified(boolean verified) {
        if(verified)
            this.verified = 1;
        else
            this.verified = 0;
    }
    
    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }
}
