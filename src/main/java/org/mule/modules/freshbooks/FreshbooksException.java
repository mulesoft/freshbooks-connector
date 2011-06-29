package org.mule.modules.freshbooks;

public class FreshbooksException extends Exception {
    public FreshbooksException(String message) {
        super(message);
    }
    public FreshbooksException(Throwable t) {
        super(t);
    }
}
