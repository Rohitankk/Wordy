package Server_Java;

public class User {
    private int userID;
    private String username;
    private String password;
    private String status;

    public User(int userID, String username, String password, String status){
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
