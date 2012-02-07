package bm.entities;

import bm.models.Logins;
import com.google.gson.Gson;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        Logger logger = LoggerFactory.getLogger(LoginEntity.class.getName());
        groupid=Integer.parseInt(login.get("groupid").toString());
        hostname=login.get("hostname").toString();
        ipaddress=login.get("ipaddress").toString();
        try {
            if(login.get("login_time")!=null) 
            {
                String string = login.get("login_time").toString();
                Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(string);
                login_time=date;
            } 
            if(login.get("logout_time")!=null) 
            {
                String string = login.get("logout_time").toString();
                string = string.substring(0, string.length()-1);
                logger.info(string);
                Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(string);
                logout_time=date;
            }
        }
        catch (ParseException ex) 
        {
            logger.error(ex.getMessage());
        }
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
        if(login_time!=null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss a");
            String date = sdf.format(login_time);
            array[4] = date;
        }
        if(logout_time!=null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss a");
            String date = sdf.format(logout_time);
            array[5] = date;
        }
        return array;
    }
}
