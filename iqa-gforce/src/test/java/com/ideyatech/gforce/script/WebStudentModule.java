package com.ideyatech.gforce.script;

import org.testng.annotations.Test;

import com.ideyatech.core.util.Utility;
import com.ideyatech.gforce.config.TestCaseBase;

public class WebStudentModule extends TestCaseBase {
	
	@Test(priority = 1)
	public void createStudentTest()
	{
		studentPage.click_studentTabLink(driver);
		studentPage.click_addStudent_Button(driver);
		Utility.temporaryWaitSolution();
		studentPage.typeIn_addStudent_firstName(driver, studentData.student_addStudent_firstName);
		studentPage.typeIn_addStudent_middleName(driver, studentData.student_addStudent_middleName);
		studentPage.typeIn_addStudent_lastName(driver, studentData.student_addStudent_lastName);
		studentPage.typeIn_addStudent_emailAddress(driver, studentData.student_addStudent_emailAddress);
		studentPage.click_addStudent_genderMale(driver);
		studentPage.typeIn_addStudent_birthDate(driver, studentData.student_addStudent_birthDate);
		studentPage.selectIn_addStudent_country(driver, studentData.student_addStudent_country);
		studentPage.selectIn_addStudent_address(driver, studentData.student_addStudent_address);;
		studentPage.typeIn_addStudent_contactNumber(driver, studentData.student_addStudent_contactNumber);
		studentPage.typeIn_addStudent_newPassword(driver, studentData.student_addStudent_newPassword);
		studentPage.typeIn_addStudent_confirmPassword(driver, studentData.student_addStudent_confirmPassword);
		studentPage.typeIn_addStudent_emergencyContactName(driver, studentData.student_addStudent_emergencyContactName);
		studentPage.typeIn_addStudent_emergencyContactNumber(driver, studentData.student_addStudent_emergencyContactNumber);
		studentPage.click_addStudent_Save_Button(driver);
		//Utility.checkThisShouldNotBePresent(driver, studentPage.student_addStudent_titleName); 
		Utility.checkThis(driver, studentPage.student_studentSuccessfullySaved_notification);
		
	}
	
	@Test(priority = 2)
	public void searchStudentTest()
	{
		studentPage.click_studentTabLink(driver);
		studentPage.typeIn_searchStudent_firstName(driver, studentData.student_searchStudent_firstName);
		studentPage.typeIn_searchStudent_lastName(driver, studentData.student_searchStudent_lastName);
		studentPage.selectIn_searchStudent_gender(driver, studentData.student_searchStudent_gender);
		studentPage.click_searchButton(driver);
		Utility.temporaryWaitSolution();
		Utility.compareStrings(studentPage.getThis_searchTable_nameandEmailAddress(driver), studentData.student_addStudent_firstName + " " + studentData.student_addStudent_lastName);
		//Utility.compareStrings(studentPage.getThis_searchTable_gender(driver);, expected)
		Utility.compareStrings(studentPage.getThis_searchTable_city(driver), studentData.student_addStudent_address);
		Utility.compareStrings(studentPage.getThis_searchTable_mobileNumber(driver), studentData.student_addStudent_contactNumber);
		
	}
	
	@Test(priority = 3)
	public void viewStudentTest()
	{
		searchStudentTest();
		studentPage.click_studentTabLink(driver);
		studentPage.click_viewStudent(driver);
		Utility.temporaryWaitSolution();
		Utility.compareStrings(studentPage.getThis_viewStudent_studentContactNumber(driver), studentData.student_addStudent_contactNumber );
		Utility.compareStrings(studentPage.getThis_viewStudent_studentEmailAddress(driver), studentData.student_addStudent_emailAddress);
		Utility.compareStrings(studentPage.getThis_viewStudent_studentGender(driver), studentData.student_searchStudent_gender);
		Utility.compareStrings(studentPage.getThis_viewStudent_studentName(driver), studentData.student_addStudent_lastName);	
	}

	@Test(priority = 4)
	public void editStudentTest()
	{
		studentPage.click_studentTabLink(driver);
		studentPage.click_editStudent(driver);
		Utility.temporaryWaitSolution();
		studentPage.typeIn_addStudent_firstName(driver, studentData.student_editStudent_firstName);
		studentPage.typeIn_addStudent_middleName(driver, studentData.student_editStudent_middleName);
		studentPage.typeIn_addStudent_lastName(driver, studentData.student_editStudent_lastName);
		studentPage.typeIn_addStudent_emailAddress(driver, studentData.student_editStudent_emailAddress);
		studentPage.click_addStudent_genderMale(driver);
		studentPage.typeIn_addStudent_birthDate(driver, studentData.student_addStudent_birthDate);
		studentPage.selectIn_addStudent_country(driver, studentData.student_addStudent_country);
		studentPage.selectIn_addStudent_address(driver, studentData.student_addStudent_address);;
		studentPage.typeIn_addStudent_contactNumber(driver, studentData.student_addStudent_contactNumber);
		studentPage.typeIn_addStudent_emergencyContactName(driver, studentData.student_addStudent_emergencyContactName);
		studentPage.typeIn_addStudent_emergencyContactNumber(driver, studentData.student_addStudent_emergencyContactNumber);
		studentPage.click_addStudent_Save_Button(driver);
		Utility.checkThis(driver, studentPage.student_studentSuccessfullySaved_notification);
	
	}
	

	
	@Test(priority = 5)
	public void deleteStudentTest()
	{
		searchStudentTest();
		studentPage.click_studentTabLink(driver);
		studentPage.typeIn_searchStudent_firstName(driver, studentData.student_searchStudent_firstName);
		studentPage.typeIn_searchStudent_lastName(driver, studentData.student_searchStudent_lastName);
		studentPage.selectIn_searchStudent_gender(driver, studentData.student_searchStudent_gender);
		studentPage.click_searchButton(driver);
		
		Utility.temporaryWaitSolution();
		studentPage.click_deleteStudent(driver);	
		Utility.checkThis(driver, studentPage.student_studentSuccessfullySaved_notification);
	}
	
}
	
	
	
	
	

