/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.models;

import org.javalite.activejdbc.Model;

/**
 *
 * @author Mario Stallone
    CREATE TABLE  `lab_info`.`trainee_info` (
    `employee_number` INT( 7 ),
    `mail_id` VARCHAR( 30 ),
    `batch_id` INT( 3 ),
    PRIMARY KEY (  `employee_number` ,  `batch_id` )
    ) ENGINE = MYISAM ;
 */
public class Trainee_Info extends Model{
    
}
