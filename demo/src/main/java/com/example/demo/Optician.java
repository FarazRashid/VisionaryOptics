
package com.example.demo;
import java.util.List;

public class Optician extends User {

	/**
	 * 
	 */
	public List<Appointment> appointment;
	/**
	 * 
	 */
	private Integer opticianId;
	/**
	 * Getter of appointment
	 */
	public List<Appointment> getAppointment() {
	 	 return appointment; 
	}
	/**
	 * Setter of appointment
	 */
	public void setAppointment(List<Appointment> appointment) { 
		 this.appointment = appointment; 
	}
	/**
	 * Getter of opticianId
	 */
	public Integer getOpticianId() {
	 	 return opticianId; 
	}
	/**
	 * Setter of opticianId
	 */
	public void setOpticianId(Integer opticianId) { 
		 this.opticianId = opticianId; 
	}
	/**
	 * 
	 * @param time 
	 * @param date 
	 * @return 
	 */
	public EEList checkAvailability(String time, String date) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param reportType 
	 * @return 
	 */
	public EJavaObject selectReportType(String reportType) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 */
	public void manageListing() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void viewReports() { 
		// TODO Auto-generated method
	 } 

}