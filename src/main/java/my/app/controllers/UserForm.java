package my.app.controllers;


public class UserForm  {

    private String id;
    private String name;

    public UserForm(){}


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


