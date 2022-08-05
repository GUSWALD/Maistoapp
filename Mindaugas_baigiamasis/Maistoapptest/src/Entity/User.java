package Entity;

import javax.persistence.*;

@Entity
@Table(name = "userdata")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userPass")
    private String userPass;
    @Column(name = "role")
    private String role;

    public static final String ROLE_ADMIN = "admin";
    public static final String ROLE_USER = "user";

    public User(){

    }

    public User(int userId, String userName, String userPass, String role) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.role = role;
    }

    public User(String userName, String userPass, String role) {
        this.userName = userName;
        this.userPass = userPass;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
