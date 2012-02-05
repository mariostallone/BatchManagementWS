/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.models;

import org.javalite.activejdbc.Model;

/**
 *
 * @author Mario Stallone
 * CREATE TABLE  `lab_info`.`logins` (
    `ipaddress` VARCHAR( 15 ),
    `username` VARCHAR( 30 ),
    `hostname` VARCHAR( 15 ),
    `groupid` INT( 5 ),
    `login_time` DATETIME,
    `logout_time` DATETIME
    ) ENGINE = MYISAM ;
 */
public class Logins extends Model {}
