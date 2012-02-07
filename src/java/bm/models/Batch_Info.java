/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.Table;

/**
 *
 * @author Mario Stallone
 * 
    CREATE TABLE `batch_info` 
    (
      `batch_id` int(3),

    `batch_name` varchar(20),

    `batch_owner` varchar(30),

    PRIMARY KEY (`batch_id`)

    ) ENGINE=MyISAM;
 */
@Table(value="batch_info")
@BelongsTo(parent = PC_Allocation.class, foreignKeyName = "batch_id")
public class Batch_Info extends Model {}