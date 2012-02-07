/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.entities;

/**
 *
 * @author Mario Stallone
 */
public class PCAllocationEntity 
{
    private Integer machineNumber;
    private String employeeNumber;
    private String mailID;
    private String hostName;
    private String batchID;
    public String getBatchID() {
        return batchID;
    }
    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }
    public String getEmployeeNumber() {
        return employeeNumber;
    }
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
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
    public String getMailID() {
        return mailID;
    }
    public void setMailID(String mailID) {
        this.mailID = mailID;
    }
}
