/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.service;

import bm.entities.PCAllocationEntity;
import bm.models.Batch_Info;
import bm.models.Machine_Info;
import bm.models.PC_Allocation;
import bm.models.Trainee_Info;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;

/**
 *
 * @author Mario Stallone
 */
public class PCAllocationService {
    public static String getPCAllocation(int batchID)
    {   
        Gson gson = new Gson();
        try 
        {
            Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/lab_info", "batchadmin", "25234117");
            List<PC_Allocation> pcAllocationList = PC_Allocation.where("batch_id = ?", batchID);
            Batch_Info batchInfo = Batch_Info.findFirst("batch_id = ?", batchID);
            List<PCAllocationEntity> allocations = new ArrayList<PCAllocationEntity>();
            for(PC_Allocation allocationModel: pcAllocationList)
            {
                PCAllocationEntity allocation = new PCAllocationEntity();
                allocation.setBatchID(batchInfo.getString("batch_name"));
                allocation.setEmployeeNumber(allocationModel.getString("employee_number"));
                Machine_Info machine = Machine_Info.findFirst("machine_number =?", allocationModel.get("machine_number"));
                allocation.setHostName(machine.getString("hostname"));
                allocation.setMachineNumber((Integer)allocationModel.get("machine_number"));
                Trainee_Info trainee = Trainee_Info.findFirst("employee_number = ?", allocation.getEmployeeNumber());
                allocation.setMailID(trainee.getString("mail_id"));
                System.out.println(gson.toJson(allocation));
                allocations.add(allocation);     
            }
            HashMap hashMap = new HashMap();
            hashMap.put("allocationData", allocations);
            System.out.println(gson.toJson(hashMap));
            return new Gson().toJson(hashMap);
        }
        finally
        {
            Base.close();
        }
    }
}
