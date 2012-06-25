package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class CallbackResponse extends BaseResponse {
    @XmlElement(name = "callback_id", nillable=true)
    private String callbackId;
    @XmlElement(name = "callback", required = false)
    private Callback callback;
    @XmlElement(name = "categories", required = false)
    private Callbacks callbacks;

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

    public Callbacks getCallbacks() {
        return callbacks;
    }

    public void setCallbacks(Callbacks callbacks) {
        this.callbacks = callbacks;
    }
}
