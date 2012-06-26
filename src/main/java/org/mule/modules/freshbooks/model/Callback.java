package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://www.freshbooks.com/api/", name = "callback")
@XmlAccessorType(XmlAccessType.FIELD)
public class Callback {
    @XmlElement(name = "callback_id", namespace = "http://www.freshbooks.com/api/", required = false)
    protected String id;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = true)
    protected String event;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = true)
    protected String uri;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    protected String verifier;
    //TODO Boolean? it sends only 0 or 1
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    protected Integer verified;
    
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

    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }
    
    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }
}
