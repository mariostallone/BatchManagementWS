/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

/**
 *
 * @author Mario Stallone
 * CREATE TABLE  `lab_info`.`pc_allocation` (
    `machine_number` INT( 3 ),
    `employee_number` INT( 7 ),
    `batch_id` INT( 3 )
    ) ENGINE = MYISAM ;
 */
@Table(value="pc_allocation")
public class PC_Allocation extends Model {}