package my.app.controllers.controllers;

import my.app.controllers.domain.User;

/**
 * Created by iyarosh on 17.08.2016.
 */
public class UserForm  {

    private String id;
    private String name;


    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "id=" + id +
                ", name='" + name + '\''
                + '}';
    }
}


