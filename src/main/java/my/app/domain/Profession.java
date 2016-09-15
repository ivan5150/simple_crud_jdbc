package my.app.domain;


public class Profession {
    private long id;
    private String name;

    public Profession(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Profession(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
