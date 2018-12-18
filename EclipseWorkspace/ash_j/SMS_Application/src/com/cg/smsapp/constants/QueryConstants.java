package com.cg.smsapp.constants;

public interface QueryConstants {
public static final String insertQuery = "insert into cloud_batch_table values(cloud_sequence.nextval,?,?)";
public static final String updateQuery = "update cloud_batch_table set salary=? where id=?";
public static final String deleteQuery = "delete from cloud_batch_table where id=?"; 
public static final String selectQuery = "select * from cloud_batch_table";
}
