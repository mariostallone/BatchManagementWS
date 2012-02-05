/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.entities;

import java.io.Serializable;

/**
 *
 * @author Mario Stallone
 */
public class BatchInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer batchId;
    private String batchName;
    private String batchOwner;
    public BatchInfoEntity() {
    }

    public BatchInfoEntity(Integer batchId) {
        this.batchId = batchId;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getBatchOwner() {
        return batchOwner;
    }

    public void setBatchOwner(String batchOwner) {
        this.batchOwner = batchOwner;
    } 
}
