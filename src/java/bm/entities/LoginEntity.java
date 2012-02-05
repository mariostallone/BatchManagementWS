package bm.entities;

import bm.models.Logins;
import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mario Stallone
 */
public class LoginEntity 
{
    private String ipaddress;
    private String username;
    private String hostname;
    private Integer groupid;
    private Date login_time;
    private Date logout_time;

    public LoginEntity() {
    }
    
    public LoginEntity(Logins login) 
    {
        groupid=Integer.parseInt(login.get("groupid").toString());
        hostname=login.get("hostname").toString();
        ipaddress=login.get("ipaddress").toString();
        //login_time=new Date(login.get("login_time").toString());
        //logout_time=new Date(login.get("logout_time").toString());
        username=login.get("username").toString();
    }
    
    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    public Date getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(Date logout_time) {
        this.logout_time = logout_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String description()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    
    public String[] stringArray()
    {
        String [] array = new String[5];
        array[0] = username;
        array[1] = hostname;
        array[2] = ipaddress;
        array[3] = groupid.toString();
        //array[4] = login_time.toString();
        //array[5] = logout_time.toString();
        return array;
    }
}
