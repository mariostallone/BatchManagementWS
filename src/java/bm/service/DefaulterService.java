/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.service;

import bm.entities.DefaulterEntity;
import bm.models.Defaulters;
import com.google.gson.Gson;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Mario Stallone
 */
public class DefaulterService {
    public static String getDefaulters()
    {
        Logger logger = LoggerFactory.getLogger(LoginService.class);
        try
        {
            Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/lab_info", "batchadmin", "1234");
            LazyList<Defaulters> defaulterInfo = Defaulters.findAll();
            List<DefaulterEntity> defaulters = new ArrayList<DefaulterEntity>();
            for(Defaulters defaulterModel : defaulterInfo)
            {
                DefaulterEntity defaulter = new DefaulterEntity();
                defaulter.setHostName(defaulterModel.getString("hostname"));
                defaulter.setIpaddress(defaulterModel.getString("ipaddress"));
                String string = defaulterModel.get("login_time").toString();
                Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(string);
                defaulter.setLogin_time(date);
                defaulter.setUserName(defaulterModel.getString("username"));
                defaulters.add(defaulter);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("defaulterData", defaulters);
            return new Gson().toJson(hashMap);
        }
        catch (ParseException ex)
        {
            java.util.logging.Logger.getLogger(DefaulterService.class.getName()).log(Level.SEVERE, null, ex);
            return "failure";
        }
        finally
        {
            Base.close();
        }
    }
}
