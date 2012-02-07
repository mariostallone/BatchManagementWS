package bm.service;

import bm.entities.LoginEntity;
import bm.models.Defaulters;
import bm.models.Logins;
import bm.models.Machine_Info;
import bm.models.PC_Allocation;
import bm.models.Trainee_Info;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author Mario Stallone
 */
public class LoginService {
    public static String registerLogin(LoginEntity loginEntity)
    {
        Logger logger = LoggerFactory.getLogger(LoginService.class);
        if(loginEntity!=null)
        {
            try 
            {
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/lab_info", "batchadmin", "1234");
                Logins login = new Logins();
                login.set("ipaddress",loginEntity.getIpaddress());
                login.set("username",loginEntity.getUsername());
                login.set("hostname",loginEntity.getHostname());
                login.set("groupid",loginEntity.getGroupid());
                login.set("login_time",new Date());
                login.set("logout_time",loginEntity.getLogout_time());
                login.save();
                //Defaulters Check
                Machine_Info machineInfo = Machine_Info.findFirst("hostname = ?", loginEntity.getHostname());
                if(machineInfo!=null)
                {
                    PC_Allocation allocation = PC_Allocation.findFirst("machine_number = ?", machineInfo.get("machine_number"));
                    if(allocation!=null)
                    {
                        Trainee_Info trainee = Trainee_Info.findFirst("employee_number = ?", allocation.get("employee_number"));
                        logger.info(trainee.getString("mail_id"));
                        if(!trainee.getString("mail_id").equalsIgnoreCase(loginEntity.getUsername()))
                        {
                            Defaulters defaulter = new Defaulters();
                            defaulter.set("hostname",loginEntity.getHostname());
                            defaulter.set("ipaddress",loginEntity.getIpaddress());
                            defaulter.set("username",loginEntity.getUsername());
                            defaulter.set("login_time", new Date());
                            defaulter.save();
                        }
                    }
                }
            }
            finally
            {
                Base.close();
            }
            return "success";                
        }
        return "fail";                
    }
    public static String registerLogout(LoginEntity loginEntity)
    {
        if(loginEntity!=null)
        {
            try
            {
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/lab_info", "batchadmin", "1234");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String currentDate = sdf.format(new Date());
                Logins login = Logins.findFirst("ipaddress = ? and DATE(login_time) = ?", loginEntity.getIpaddress(),currentDate);
                login.set("logout_time",new Date());
                login.save();
            }
            finally
            {
                Base.close();
            }
            return "success";                
        }
        return "fail";
    }
    public static String getReport(Date date)
    {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/lab_info", "batchadmin", "1234");
        Logger logger = LoggerFactory.getLogger(LoginService.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(date);
        List<Logins> logins = Logins.where("DATE(login_time) = ?", currentDate);      
        Iterator<Logins> it = logins.iterator();
        List<LoginEntity> loginEntities = new ArrayList<LoginEntity>();
        List<String []> stringArray = new ArrayList<String[]>();
        while(it.hasNext())
        {
            LoginEntity loginEntity = new LoginEntity(it.next());
            loginEntities.add(loginEntity);
            stringArray.add(loginEntity.stringArray());
        }
        logger.info(logins.toArray().toString());
        Base.close();
        HashMap hashMap = new HashMap();
        //hashMap.put("loginData", loginEntities.toArray());
        hashMap.put("loginData", stringArray);
        return new Gson().toJson(hashMap);
    }
}