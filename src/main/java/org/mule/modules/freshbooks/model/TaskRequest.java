/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class TaskRequest extends BaseRequest {
    
    @XmlElement(name = "task_id")
    private String taskId;
    @XmlElement(name = "task")
    private Task task;

    public String getTaskId() {
        return taskId;
    }
    public Task getTask() {
        return task;
    }
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    public void setTask(Task task) {
        this.task = task;
    }    
}

