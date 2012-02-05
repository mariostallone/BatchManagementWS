/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.models;

import org.javalite.activejdbc.Model;

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
public class Batch_Info extends Model {}