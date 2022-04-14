package ee4216.gp14.stickynotesapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOGIN_DATA")
public class LoginData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;

    public LoginData() {
    }

    public LoginData(String user, String pw) {
        this.setUsername(user);
        this.setPassword(pw);
    }

    public LoginData(Long id, String user, String pw) {
        this.setID(id);
        this.setUsername(user);
        this.setPassword(pw);
    }

    //Set Method
    public void setID(Long id) {
        this.id = id;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public void setPassword(String pw) {
        this.password = pw;
    }

    //Get Method
    public Long getID() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {

        return String.format(
               "LoginData[id=%d, username='%s', password='%s']",
               id, username, password);
    }

}
