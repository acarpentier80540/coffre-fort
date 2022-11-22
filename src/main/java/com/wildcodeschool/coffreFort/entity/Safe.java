
package com.wildcodeschool.coffreFort.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Safe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String webSite;
    private String word;

    public Safe() {  }

    public Safe(String webSite, String word) {
        this.setName(webSite);
        this.setWord(word);
       ;
    }

    public Safe(Long id, String webSite, String word) {
        this.setId(id);
        this.setName(webSite);
        this.setWord(word);
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return webSite;
    }

    public void setName(String webSite) {
        this.webSite = webSite;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

 
}

