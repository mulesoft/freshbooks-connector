package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlElement;

public class CallbackRequest extends BaseRequest {
    
    @XmlElement(name = "callback_id")
    private String callbackId;
    @XmlElement(name = "callback")
    private Callback callback;

    public String getCallbackId() {
        return callbackId;
    }

    public void setCallbackId(String callbackId) {
        this.callbackId = callbackId;
    }

    public Callback getCallback() {
        return callback;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }
}
