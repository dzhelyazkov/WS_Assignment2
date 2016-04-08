package model;

/**
 * Created by XRC_7331 on 4/8/2016.
 */
public class Account implements Cloneable {
    private Integer id;
    private String name;
    private String password;

    public Account(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Account() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Account clone() {
        return new Account(id, name, password);
    }
}
