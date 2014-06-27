/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zols.links.domain;

import java.util.List;
import javax.persistence.Id;

/**
 *
 * @author sathish_ku
 */
public class Link {

    @Id
    private String name;

    /**
     * Label of the link.
     */
    private String label;

    /**
     * Description of the link.
     */
    private String description;

    /**
     * Parent name of the link.
     */
    private String parentLinkName;

    /**
     * Target Url.
     */
    private String targetUrl;

    /**
     * Icon Url.
     */
    private String iconUrl;


    
    /**
     * category of the link.
     */
    private String categoryName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentLinkName() {
        return parentLinkName;
    }

    public void setParentLinkName(String parentLinkName) {
        this.parentLinkName = parentLinkName;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    
}