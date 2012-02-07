/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.entities;

/**
 *
 * @author Mario Stallone
 */
public class MachineInfoEntity 
{
    private Integer machineNumber;
    private String hostName;
    private String recentIP;
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getMachineNumber() {
        return machineNumber;
    }

    public void setMachineNumber(Integer machineNumber) {
        this.machineNumber = machineNumber;
    }

    public String getRecentIP() {
        return recentIP;
    }

    public void setRecentIP(String recentIP) {
        this.recentIP = recentIP;
    }
}
