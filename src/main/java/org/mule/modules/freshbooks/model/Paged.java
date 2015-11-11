/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

public class Paged<T> implements Iterable<T> {

    int page;
    int perPage;
    int pages;
    int total;
    ArrayList<T> contents;

    public Paged() {
        this.contents = new ArrayList<T>();
    }

    public ArrayList<T> getContents() {
        return contents;
    }

    public void setContents(ArrayList<T> contents) {
        this.contents = contents;
    }

    @XmlAttribute
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @XmlAttribute(name = "per_page")
    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    @XmlAttribute
    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @XmlAttribute
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean add(T e) {
        if (contents == null)
            contents = new ArrayList<T>();
        return contents.add(e);
    }

    public T get(int index) {
        return contents.get(index);
    }

    public boolean isEmpty() {
        return contents == null || contents.isEmpty();
    }

    public Iterator<T> iterator() {
        if (contents == null) {
            List<T> emptyList = Collections.emptyList();
            return emptyList.iterator();
        }
        return contents.iterator();
    }

    public int size() {
        return contents.size();
    }
}
