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
public class Found {
    private int foundId;
    private User user;
    private int postId;
    private Image image;
    private String foundDescription;

    public Found() {
    }
    
    public Found(User user){
        this.user = user;
    }
    
    public Found(int foundId, User user, Image image, String foundDescription) {
        this.foundId = foundId;
        this.user = user;
        this.image = image;
        this.foundDescription = foundDescription;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

   

    
    public int getFoundId() {
        return foundId;
    }

    public void setFoundId(int foundId) {
        this.foundId = foundId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFoundDescription() {
        return foundDescription;
    }

    public void setFoundDescription(String foundDescription) {
        this.foundDescription = foundDescription;
    }

    @Override
    public String toString() {
        return "Found{" + "foundId=" + foundId + ", user=" + user + ", description=" + foundDescription + '}';
    }
    
}
