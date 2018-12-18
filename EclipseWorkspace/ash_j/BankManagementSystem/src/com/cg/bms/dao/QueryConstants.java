package com.cg.bms.dao;

public class QueryConstants {
public static final String insertAccount="insert into account_master values(account_seq.nextval,?,?,?,?)";
public static final String selecMaxId="select max(account_no) from account_master";
}
