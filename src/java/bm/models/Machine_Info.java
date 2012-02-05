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
 * CREATE TABLE  `lab_info`.`machine_info` (
    `machine_number` INT( 3 ),
    `hostname` VARCHAR( 15 ),
    PRIMARY KEY (  `machine_number` ,  `hostname` )
    ) ENGINE = MYISAM ;
 */
@Table(value="machine_info")
public class Machine_Info extends Model {}
