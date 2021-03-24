package com.geekbrains.server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class SimpleAuthService implements AuthService {
    public static DB db = new DB();




/*public class SimpleAuthService implements AuthService {
    private class UserData {
        private String login;
        private String password;
        private String nickname;

        public UserData(String login, String password, String nickname) {
            this.login = login;
            this.password = password;
            this.nickname = nickname;
        }
    }

    private List<UserData> users;

    public SimpleAuthService() {
        this.users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            // login1, pass1
            // login2, pass2
            users.add(new UserData("login" + i, "pass" + i, "nick" + i));
        }
    }*/

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {


        String sql = "SELECT login,password,nickname FROM new_table";

        {
            try {
                ResultSet rs = db.runSql(sql);
                while (rs.next()) {
                    if (rs.getString("login").equals(login) && rs.getString("password").equals(password)) {
                        System.out.println(rs.getString("login") + "  " + rs.getString("password") + "  " + rs.getString("nickname"));
                        return rs.getString("nickname");
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


      /*  for (UserData o : users) {
            if (o.login.equals(login) && o.password.equals(password)) {
                return o.nickname;
            }
        }*/
            return null;
        }
    }
}