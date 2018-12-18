package com.cg.uas.presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.cg.uas.exceptions.UASException;
import com.cg.uas.model.ProgramsOffered;
import com.cg.uas.model.ProgramsScheduled;
import com.cg.uas.service.AdminServiceImpl;
import com.cg.uas.service.IAdminService;

public class AdminConsole {
	private String currentUser;
	IAdminService adminService = new AdminServiceImpl();

	public AdminConsole(String currentUser) {
		super();
		this.currentUser = currentUser;
	}

	Scanner scanner = new Scanner(System.in);

	public void start() throws UASException {
		System.out.println("Welcome " + currentUser);
		boolean n = false;
		while (n != true) {

			System.out
					.println("1] Add Courses 2]Update Courses 3]Remove Courses 4]Schedule a program 5]Logout");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addCourse();
				break;
			case 2:
				updateCourse();
				break;
			case 3:
				removeCourse();
				break;
			case 4:
				scheduleProgram();
				break;
			case 5:
				n = true;
				System.out.println("Exit success");
				break;
			default:
				System.out.println("Invalid input chosen");
				System.exit(0);
				break;
			}
		}
	}

	private void scheduleProgram() throws UASException {
		System.out.println("The available programs are :");
		List<ProgramsOffered> list = adminService.getAllCourses();
		if (list != null) {
			for (ProgramsOffered off : list) {
				System.out.println("Program Name : " + off.getProgramName());
						/*+ "\nDescription : " + off.getDescription()
						+ "\nEligibility : " + off.getApplicantEligibility()
						+ "\nCourse Duration : " + off.getDuration()
						+ "\nCertificate : " + off.getDegreeCertificateOffered());*/
			}
			
			System.out.println("Enter the program name which has to be scheduled ");
			scanner.nextLine();
			String cName=scanner.nextLine();
			ProgramsOffered offered=adminService.getByName(cName);
			if(offered.getProgramName()==null){
				System.out.println("Course name entered does not exist : ");
			}else{
				System.out.println("1]Add schedule 2]Delete schedule");
				int sch=scanner.nextInt();
			if(sch==1){
				System.out.println(offered.getProgramName());
					ScheduleProg(offered.getProgramName());
			}else if(sch==2){
				
				int res=adminService.ScheduleDelete(offered.getProgramName());
				if(res>0)
					System.out.println("Deleted schedule successfully");
				else{
					System.out.println("Not deleted schedule");
				}
			}else{
				System.out.println("Invalid number chosen");
			}
			}
		} else {
			System.out.println("No courses to schedule");
		}
	}





	private void ScheduleProg(String pName) throws UASException {
		try {
		System.out.println("Enter the id for scheduled program"+pName);
	scanner.nextLine();
	String scheduledProgramId=scanner.nextLine();
	System.out.println("Enter location : ");
	String location=scanner.nextLine();
	System.out.println("Enter start date");
	String sstartDate=scanner.nextLine();
	System.out.println("Enter end date");
	String sendDate=scanner.nextLine();
	System.out.println("Enter number of sessions per week");
	int spw=scanner.nextInt();
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

		Date startDate=sdf.parse(sstartDate);
		Date endDate=sdf.parse(sendDate);
		ProgramsScheduled scheduled=new ProgramsScheduled(scheduledProgramId, pName, location, startDate, endDate, spw);
		String PId=adminService.addSchedule(scheduled);
		System.out.println("The data is scheduled with Program id : "+PId);
		
		
	} catch (ParseException e) {
		throw new UASException("date parse exception");
	}
	
	}

	private void removeCourse() throws UASException {
		System.out.println("Enter name of course to be removed");
		scanner.nextLine();
		String cname = scanner.nextLine();
		System.out.println(cname);

		int result = adminService.removeCourse(cname);
		if (result > 0)
			System.out.println("deleted successful" + result);
		else {
			System.out.println("not deleted" + result);
		}
	}

	private void updateCourse() throws UASException {

		System.out.println("Enter Program Name to be updated");
		scanner.nextLine();
		String pname1 = scanner.nextLine();
		System.out.println(pname1);
		System.out.println("enter description");
		String description = scanner.nextLine();
		System.out.println("Enter eligibility");
		String eligibility = scanner.nextLine();
		System.out.println(eligibility);
		ProgramsOffered offered = new ProgramsOffered(pname1, description,
				eligibility);
		int updateRes = adminService.updateCourse(offered);
		System.out.println(updateRes);
		if (updateRes > 0)
			System.out.println("Update successful");
		else {
			System.out.println("Not updated ");
		}

	}

	private void addCourse() throws UASException {

		scanner.nextLine();
		System.out.println("Enter program Name:");
		String pname = scanner.nextLine();
		System.out.println("Description of course");
		String desc = scanner.nextLine();
		System.out.println("eligibility");
		String ae = scanner.nextLine();
		System.out.println("Program duration");
		int d = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Certificate Provided");
		String dc = scanner.nextLine();
		ProgramsOffered offered = new ProgramsOffered(pname, desc, ae, d, dc);
		String pName = adminService.addCouse(offered);
		System.out.println("Course " + pName);
	}

}
