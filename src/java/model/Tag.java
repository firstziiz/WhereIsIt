/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Huag
 */
public class Tag {
    private int tagId;
    private String tagName;

    public Tag() {
        
    }

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    
    public Tag(int tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;
    }



    @Override
    public boolean equals(Object obj) {
       if(obj != null && obj instanceof Tag){
           Tag tag = (Tag)obj;
           if(tagId == tag.getTagId()){
               return   true;
           }
       }
       return false;
    }

       
       
       
    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return  "tagId=" + tagId + ", tagName=" + tagName;
    }
       
}
