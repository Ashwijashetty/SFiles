package com.cg.ems.client;

import java.util.List;

import com.cg.ems.dao.EmployeeDaoImpl;
import com.cg.ems.entities.EmployeeBean;

public class Client {
public static void main(String[] args) {
	EmployeeBean bean=new EmployeeBean();
/*	bean.setEmpId(103);
    bean.setEmpName("Ashwija");
    bean.setSalary(2000.25);
    bean.setProjName("Cloud");*/
    EmployeeDaoImpl dao=new EmployeeDaoImpl();
    //List<EmployeeBean> list=dao.getallEmp();
    //List<EmployeeBean> list=dao.getallemp1(103);
    /*for(EmployeeBean employeeBean:list){
    	System.out.println(employeeBean.getEmpName()+" "+employeeBean.getProjName()
    			+" "+employeeBean.getEmpId()+" "+employeeBean.getSalary());
    }*/
    dao.InsertEmployee(bean);
    System.out.println("Added successfully");
    //EmployeeBean bean1= dao.getEmployee(102);
    //System.out.println("The employee details are:"+"  "+bean1.getEmpName()+" "+bean.getProjName() );
    dao.merEmployee();
    //dao.delEmployee(102);

}
}
