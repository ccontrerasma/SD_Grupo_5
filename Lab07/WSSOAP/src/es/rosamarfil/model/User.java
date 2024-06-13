package es.rosamarfil.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
 
public class User implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    public static List<User> users = new ArrayList<>(Arrays.asList(
            new User("Rosa", "Marfil"), 
            new User("Pepito", "Grillo"), 
            new User("Manuela", "Río")));
     
    public String name;
 
    public String username;
 
    public User() {
        super();
    }
     
    public User(String name, String username) {
        super();
        this.name = name;
        this.username = username;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
     
     public static List<User> getUsers()
     {
         return users;
     }
 
}
