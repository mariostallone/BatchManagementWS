package bm.service;

import bm.entities.LoginEntity;
import bm.models.Logins;
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
        if(loginEntity!=null)
        {
            try 
            {
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/lab_info", "batchadmin", "25234117");
                Logins login = new Logins();
                login.set("ipaddress",loginEntity.getIpaddress());
                login.set("username",loginEntity.getUsername());
                login.set("hostname",loginEntity.getHostname());
                login.set("groupid",loginEntity.getGroupid());
                login.set("login_time",new Date());
                login.set("logout_time",loginEntity.getLogout_time());
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
    public static String registerLogout(LoginEntity loginEntity)
    {
        if(loginEntity!=null)
        {
            try
            {
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/lab_info", "batchadmin", "25234117");
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
    public static String getReport()
    {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/lab_info", "batchadmin", "25234117");
        Logger logger = LoggerFactory.getLogger(LoginService.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
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