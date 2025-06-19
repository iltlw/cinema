package org.g220804.pojo;

public class User
{
    private int userId;
    private String userName;
    private String userPassword;
    private boolean userState = true;
    public User()
    {
    }
    public User(int userId, String userName, String userPassword, boolean userState)
    {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userState = userState;
    }
    public int getUserId()
    {
        return userId;
    }
    public void setUserId(int userId)
    {
        this.userId = userId;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getUserPassword()
    {
        return userPassword;
    }
    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }
    public boolean getUserState()
    {
        return userState;
    }
    public void setUserState(boolean userState)
    {
        this.userState = userState;
    }
}
