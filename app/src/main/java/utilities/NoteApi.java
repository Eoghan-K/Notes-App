package utilities;

import android.app.Application;

public class NoteApi extends Application {
    private String username;
    private String userId;
    private static NoteApi instance;

    public static NoteApi getInstance() {
        if (instance == null) {
            instance = new NoteApi();
        }
        return instance;
    }

    public NoteApi() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
