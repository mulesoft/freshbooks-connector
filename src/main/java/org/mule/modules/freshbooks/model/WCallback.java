/**
 * Mule Freshbooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.freshbooks.model;

public class WCallback {
    private Callback callback;

    /**
     * @return the callback
     */
    public Callback getCallback() {
        return callback;
    }

    /**
     * @param callback the callback to set
     */
    public void setCallback(Callback callback) {
        this.callback = callback;
    }

}
