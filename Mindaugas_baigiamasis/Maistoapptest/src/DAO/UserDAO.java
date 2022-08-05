package DAO;

import Utils.BCryptPassword;
import Entity.User;
import Utils.HibernateUtil;
import org.hibernate.Session;

public class UserDAO {
    public UserDAO() {
    }

    public void registration(String regUsername, String regPassword,String userRole) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String password = BCryptPassword.hashPassword(regPassword);
        User user = new User(regUsername, password, userRole);
        session.save(user);
        session.getTransaction().commit();
        System.out.println("Register successful!");
    }

    public boolean login(String logUsername, String logPassword) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User findUserFDB = findUserByUsername(logUsername);
        session.getTransaction().commit();
        if (logUsername.equals(findUserFDB.getUserName())) {
            if (BCryptPassword.checkPassword(logPassword, findUserFDB.getUserPass())) {
                System.out.println("Login successful!");
                return true;
            } else {
                System.out.println("Login unsuccessful! Wrong password!");
                return false;
            }
        } else {
            System.out.println("Login unsuccessful! Wrong username!");
            return false;
        }
    }

    public String getUserRole(String username){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = findUserByUsername(username);
        session.getTransaction().commit();
        return user.getRole();
    }

    public User findUserByUsername(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Object user = session.createQuery("select a from User a where a.userName = '" + username + "'").getSingleResult();
        session.getTransaction().commit();
        return (User) user;
    }
}