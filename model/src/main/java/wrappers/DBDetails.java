package wrappers;


public class DBDetails {

    private String db;
    private String url;
    private String user;
    private String password;

    public DBDetails() {
    }

    public DBDetails(String db, String url, String user, String password) {
        this.db = db;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getDb() {
        return db;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
