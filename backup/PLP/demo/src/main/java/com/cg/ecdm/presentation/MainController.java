package com.cg.ecdm.presentation;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.ecdm.models.Employee;
import com.cg.ecdm.models.ExpenseDetails;
import com.cg.ecdm.models.Project;

@RestController
@RequestMapping("/ecdm")
public class MainController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value = "/createExpense", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ExpenseDetails> createExpense(@RequestBody ExpenseDetails expense) {
		HttpHeaders requestHeaders = new HttpHeaders();
		System.out.println("expense"+expense);
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	final String uri = "http://ECM/create"; 
	HttpEntity<ExpenseDetails> requestEntity = new HttpEntity<>(expense, requestHeaders);
		ResponseEntity<ExpenseDetails> responseEntity= restTemplate.exchange(
				uri,
                HttpMethod.POST,
                requestEntity,
                ExpenseDetails.class);
	    System.out.println(responseEntity);
	    return responseEntity;
	}
	
	@RequestMapping(value = "/modifyExpense/{expenseCode}", method = RequestMethod.PUT)
	public ResponseEntity<ExpenseDetails> modifyExpense(@PathVariable int expenseCode,
			@RequestBody ExpenseDetails expenseDetails) {
		final String uri = "http://ECM/update/{expenseCode}";
		HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	HttpEntity<ExpenseDetails> requestEntity = new HttpEntity<>(expenseDetails, requestHeaders);
		ResponseEntity<ExpenseDetails> responseEntity= restTemplate.exchange(
				uri,
                HttpMethod.PUT,
                requestEntity,
                ExpenseDetails.class,expenseCode);
		return responseEntity;
	}

	@RequestMapping(value = "/readExpense/{expenseCode}", method = RequestMethod.GET)
	public ExpenseDetails readByExpenseCode(@PathVariable int expenseCode) {
		System.out.println("Getting School details for " + expenseCode);
		HttpHeaders requestHeaders = new HttpHeaders();
	    requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	    HttpEntity<ExpenseDetails> requestEntity = new HttpEntity<>(requestHeaders);
		ExpenseDetails response = restTemplate.exchange("http://ECM/read/{expenseCode}",
				HttpMethod.GET, requestEntity, new ParameterizedTypeReference<ExpenseDetails>() {
				}, expenseCode).getBody();

		System.out.println("Response Received as " + response);

		return response;
	}
	
	@RequestMapping(value = "/readExpense", method = RequestMethod.GET)
	public ResponseEntity<List<ExpenseDetails>> readExpense() {
	HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
    HttpEntity<ExpenseDetails> requestEntity = new HttpEntity<>(requestHeaders);
    final String uri = "http://ECM/readExpense"; 
    System.out.println("ABCDEFGHIJKL");
    ResponseEntity<List<ExpenseDetails>>list = restTemplate.exchange(uri,
            HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<ExpenseDetails>>() {
    });
	return list;
	}
	
	@RequestMapping(value = "/deleteExpense/{expenseCode}", method = RequestMethod.DELETE)
	public String deleteExpense(@PathVariable int expenseCode) {
		HttpHeaders requestHeaders = new HttpHeaders();
	    requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	    HttpEntity<ExpenseDetails> requestEntity = new HttpEntity<>(requestHeaders);
		restTemplate.exchange("http://ECM/delete/{expenseCode}",
				HttpMethod.DELETE, requestEntity, new ParameterizedTypeReference<String>() {
				}, expenseCode).getBody();
		return "Deleted";
	}
	/*@RequestMapping(value = "/deleteExpense/{expenseCode}", method = RequestMethod.DELETE)
	public String deleteExpense(
			@PathVariable int expenseCode) {
		final String uri = "http://localhost:8102/ecm/delete/{expenseCode}";
		RestTemplate restTemplate = new RestTemplate();
	restTemplate.delete(uri,	expenseCode);
		return "Delete Success";*/

	/*@RequestMapping(value = "/createExpense", method = RequestMethod.POST)
	public ExpenseDetails createExpense(
			@RequestBody ExpenseDetails expenseDetails) {
		final String uri = "http://localhost:8102/ecm/create";
		RestTemplate restTemplate = new RestTemplate();
		ExpenseDetails details = restTemplate.postForObject(uri,
				expenseDetails, ExpenseDetails.class);
		return details;
	}*/
	
	
	
	/*@RequestMapping(value = "/readExpense", method = RequestMethod.GET)
	public List<ExpenseDetails> readExpense() {
		final String uri = "http://localhost:8102/ecm/readExpense";
		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<ExpenseDetails> details = restTemplate.getForObject(uri, List.class);
		return details;
	}*/
	
	/*@RequestMapping(value = "/readExpense/{expenseCode}", method = RequestMethod.GET)
	public ExpenseDetails readByExpenseCode(@PathVariable int expenseCode) {
		final String uri = "http://localhost:8102/ecm/read/{expenseCode}";
		RestTemplate restTemplate = new RestTemplate();
		ExpenseDetails details = restTemplate.getForObject(uri, ExpenseDetails.class, expenseCode);
		return details;
	}*/
	
	/*@RequestMapping(value = "/modifyExpense/{expenseCode}", method = RequestMethod.PUT)
	public ExpenseDetails modifyExpense(@PathVariable int expenseCode,
			@RequestBody ExpenseDetails expenseDetails) {
		final String uri = "http://localhost:8102/ecm/update/{expenseCode}";
		RestTemplate restTemplate = new RestTemplate();
		expenseDetails.setExpenseCode(expenseCode);
		restTemplate.put(uri, expenseDetails, expenseCode);
		return expenseDetails;
	}*/
	
	/*@RequestMapping(value = "/deleteExpense/{expenseCode}", method = RequestMethod.DELETE)
	public String deleteExpense(
			@PathVariable int expenseCode) {
		final String uri = "http://localhost:8102/ecm/delete/{expenseCode}";
		RestTemplate restTemplate = new RestTemplate();
	restTemplate.delete(uri,	expenseCode);
		return "Delete Success";
	}*/
	
	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	final String uri = "http://Employee/create"; 
	HttpEntity<Employee> requestEntity = new HttpEntity<>(employee, requestHeaders);
		ResponseEntity<Employee> responseEntity= restTemplate.exchange(
				uri,
                HttpMethod.POST,
                requestEntity,
                Employee.class);
	    return responseEntity;
	}
	
	

	/*@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	public Employee createEmployee1(@RequestBody Employee employee) {
		final String uri = "http://localhost:9000/employee/create";
		RestTemplate restTemplate = new RestTemplate();
		Employee details = restTemplate.postForObject(uri, employee,
				Employee.class);
		return details;
	}*/
	
	@RequestMapping(value = "/readEmployee", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> readEmployee() {
	HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
    HttpEntity<ExpenseDetails> requestEntity = new HttpEntity<>(requestHeaders);
    final String uri = "http://Employee/readall"; 
    ResponseEntity<List<Employee>>list = restTemplate.exchange(uri,
            HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Employee>>() {
    });
	return list;
	}

	/*@RequestMapping(value = "/readEmployee", method = RequestMethod.GET)
	public List<Employee> readEmployee() {
		final String uri = "http://localhost:9000/employee/readall";
		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<Employee> details = restTemplate.getForObject(uri, List.class);
		return details;
	}*/

	@RequestMapping(value = "/modifyEmployee/{employeeId}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> modifyExpense(@PathVariable String employeeId,
			@RequestBody Employee employee) {
		final String uri = "http://Employee/modify/{employeeId}";
		HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	HttpEntity<Employee> requestEntity = new HttpEntity<>(employee, requestHeaders);
		ResponseEntity<Employee> responseEntity= restTemplate.exchange(
				uri,
                HttpMethod.PUT,
                requestEntity,
                Employee.class,employeeId);
		return responseEntity;
	}

	
	/*@RequestMapping(value = "/modifyEmployee/{employeeId}", method = RequestMethod.PUT)
	public Employee updateData(@PathVariable String employeeId,
			@RequestBody Employee employee) {
		final String uri = "http://localhost:9000/employee/modify/{employeeId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(uri, employee, employeeId);
		return employee;

	}*/

	@RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.DELETE)
	public String deleteData(@PathVariable String employeeId) {
		HttpHeaders requestHeaders = new HttpHeaders();
	    requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	    HttpEntity<Employee> requestEntity = new HttpEntity<>(requestHeaders);
		restTemplate.exchange("http://Employee/delete/{employeeId}",
				HttpMethod.DELETE, requestEntity, new ParameterizedTypeReference<String>() {
				}, employeeId).getBody();
		return "Deleted";
	}
	
	
	
	/*@RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.DELETE)
	public String deleteData(@PathVariable String employeeId) {
		final String uri = "http://localhost:9000/employee/delete/{employeeId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, employeeId);
		return " happy??? deleted :-(";

	}*/

	@RequestMapping(value = "/readEmployee/{employeeId}", method = RequestMethod.GET)
	public Employee readByEmployeeId(@PathVariable String employeeId) {
		HttpHeaders requestHeaders = new HttpHeaders();
	    requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	    HttpEntity<Employee> requestEntity = new HttpEntity<>(requestHeaders);
		Employee response = restTemplate.exchange("http://Employee/read/{employeeId}",
				HttpMethod.GET, requestEntity, new ParameterizedTypeReference<Employee>() {
				}, employeeId).getBody();
		return response;
	}
	
	
	/*@RequestMapping(value = "/readEmployee/{employeeId}", method = RequestMethod.GET)
	public Employee readData(@PathVariable String employeeId) {
		final String uri = "http://localhost:9000/employee/read/{employeeId}";
		RestTemplate restTemplate = new RestTemplate();
		Employee employee = restTemplate.getForObject(uri, Employee.class, employeeId);
		return employee;
	}*/
	
	@RequestMapping(value = "/createProject", method = RequestMethod.POST)
	public Project createProject(@RequestBody Project project) {
		final String uri = "http://localhost:8082/project/insert";
		RestTemplate restTemplate = new RestTemplate();
		Project details = restTemplate.postForObject(uri, project,
				Project.class);
		return details;
	}
	
	@RequestMapping(value = "/readAllProject", method = RequestMethod.GET)
	public List<Project> readAllProject() {
		final String uri = "http://localhost:8082/project/getAll";
		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<Project> details = restTemplate.getForObject(uri,List.class);
		return details;
	}
	
	@RequestMapping(value = "/readProjectById/{id}", method = RequestMethod.GET)
	public Project readProjectById(@PathVariable int id) {
		final String uri = "http://localhost:8082/project/get/{id}";
		RestTemplate restTemplate = new RestTemplate();
		Project details = restTemplate.getForObject(uri,Project.class,id);
		return details;
	}
	
	@RequestMapping(value = "/updateProjectById/{id}", method = RequestMethod.PUT)
	public Project updateProjectById(@PathVariable int id,@RequestBody Project project) {
		final String uri = "http://localhost:8082/project/update/{id}";
		project.setProductCode(id);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(uri,Project.class,id);
		return project;
	}
	
	@RequestMapping(value = "/deleteProjectById/{id}", method = RequestMethod.DELETE)
	public String deleteProjectById(@PathVariable int id) {
		final String uri = "http://localhost:8082/project/delete/{id}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(uri,Project.class,id);
		return "Delete Success";
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
}
