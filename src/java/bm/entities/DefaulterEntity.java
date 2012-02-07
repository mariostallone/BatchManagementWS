/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.entities;

import java.util.Date;

/**
 *
 * @author Mario Stallone
 */
public class DefaulterEntity 
{
    private String userName;
    private Date login_time;
    private String hostName;
    private String ipaddress;
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
