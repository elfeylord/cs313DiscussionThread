/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum;

import java.util.Date;

/**
 *
 * @author Cole
 */
public class Post {
    private String username;
    private String text;
    private String date;

    public Post()
    {
        username = "N/A";
        text = "N/A";
        date = "N/A";
    }
    public Post(String username, String text, String date)
    {
        this.username = username;
        this.text = text;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
