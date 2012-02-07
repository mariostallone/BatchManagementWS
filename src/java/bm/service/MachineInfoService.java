/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.service;

import bm.entities.MachineInfoEntity;
import bm.models.Logins;
import bm.models.Machine_Info;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;

/**
 *
 * @author Mario Stallone
 */
public class MachineInfoService {
        public static String getMachineInfo()
    {   
        Gson gson = new Gson();
        try 
        {
            Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/lab_info", "batchadmin", "25234117");
            List<Machine_Info> machineInfoList = Machine_Info.findAll();
            List<MachineInfoEntity> machines = new ArrayList<MachineInfoEntity>();
            for(Machine_Info machine: machineInfoList)
            {
                MachineInfoEntity machineEntity = new MachineInfoEntity();
                machineEntity.setHostName(machine.getString("hostname"));
                machineEntity.setMachineNumber((Integer)machine.get("machine_number"));
                LazyList<Logins> loginInfo = Logins.findBySQL("SELECT * FROM logins WHERE hostname = ? and login_time = (select max(login_time)  from logins where hostname = ?)", machine.getString("hostname"),machine.getString("hostname"));
                for(Logins login : loginInfo)
                {
                   machineEntity.setRecentIP(login.getString("ipaddress")); 
                }
                machines.add(machineEntity);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("machineData", machines);
            System.out.println(gson.toJson(hashMap));
            return new Gson().toJson(hashMap);
        }
        finally
        {
            Base.close();
        }
    }
}
