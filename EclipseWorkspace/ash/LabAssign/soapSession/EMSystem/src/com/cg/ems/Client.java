package com.cg.ems;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {
public static void main(String[] args) throws Exception {
	URL url=new URL("http://127.0.0.1:7076/esi?wsdl");
	QName qName=new QName("http://ems.cg.com/","EmployeeServiceImplService");//qualified name
	Service service=Service.create(url,qName);
	IEmployeeService employeeService=service.getPort(IEmployeeService.class);
String eName=employeeService.getDesignation("ABC");
System.out.println("The designation is :"+eName);

}
}