package org.mule.modules.freshbooks.model;


public class CallbackResponse extends BaseResponse {
    private String callbackId;
    private Callback callback;
    private Callbacks callbacks;
    
    public CallbackResponse(Response response) {
        initBaseResponseFields(response);
        callbackId = response.getCallbackId();
        callback = response.getCallback();
        callbacks = response.getCallbacks();
    }
    
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
