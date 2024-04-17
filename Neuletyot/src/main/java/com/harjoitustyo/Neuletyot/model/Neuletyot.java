package com.harjoitustyo.Neuletyot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Neuletyot {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull
    private long neuleId;

    @NotEmpty
    @Size(min=2, max=30)
    private String neuleTitle;
    private String neuleInfo;
    private String neuleLink; 
    private String lanka;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Neuletyot() {
        super();
    }
    
    public Neuletyot(String neuleTitle, String neuleInfo, String neuleLink, String lanka, Category category) {
        super();
        this.neuleTitle = neuleTitle;
        this.neuleInfo = neuleInfo;
        this.neuleLink = neuleLink;
        this.lanka = lanka;
        this.category = category;
    }


    public long getNeuleId() {
        return neuleId;
    }

    public void setNeuleId(long neuleId) {
        this.neuleId = neuleId;
    }

    public String getNeuleTitle() {
        return neuleTitle;
    }

    public void setNeuleTitle(String neuleTitle) {
        this.neuleTitle = neuleTitle;
    }

    public String getNeuleInfo() {
        return neuleInfo;
    }

    public void setNeuleInfo(String neuleInfo) {
        this.neuleInfo = neuleInfo;
    }

    public String getNeuleLink() {
        return neuleLink;
    }

    public void setNeuleLink(String neuleLink) {
        this.neuleLink = neuleLink;
    }

    public String getLanka() {
        return lanka;
    }

    public void setLanka(String lanka) {
        this.lanka = lanka;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        if (this.category != null)
            return "Neuletyot [neuleId=" + neuleId + ", neuleTitle=" + neuleTitle + ", neuleInfo=" + neuleInfo
                + ", neuleLink=" + neuleLink + ", lanka=" + lanka + ", category=" + category + this.getCategory() + "]";
        else
            return "Neuletyot [neuleId=" + neuleId + ", neuleTitle=" + neuleTitle + ", neuleInfo=" + neuleInfo
            + ", neuleLink=" + neuleLink + ", lanka=" + lanka + ", category=" + category + "]";
    }

}
