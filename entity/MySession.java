package entity;

import jakarta.servlet.http.HttpSession;

public class MySession {
    private static MySession instance;
    private HttpSession session;
    private User user;
    private boolean isLoggedIn;

    private MySession(HttpSession session) {
        this.session = session;
        this.user = (User) session.getAttribute("username");
        this.isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
    }

    public static MySession getInstance(HttpSession session) {
        if (instance == null) {
            instance = new MySession(session);
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void logout() {
        session.invalidate();
        instance = null;
    }
}