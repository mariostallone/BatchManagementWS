/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.models;

import org.javalite.activejdbc.Model;

/**
 *
 * @author Mario Stallone
 * CREATE TABLE  `lab_info`.`pc_allocation` (
    `machine_number` INT( 3 ),
    `employee_number` INT( 7 ),
    `batch_id` INT( 3 )
    ) ENGINE = MYISAM ;
 */
public class PC_Allocation extends Model {}