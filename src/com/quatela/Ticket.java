package com.quatela;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ticket {

	private String ticketDesc;
	private int ticketNum;
	private String ticketNotes;
	private String ticketSolution;
	private String ticketStatus;
	private Date startDate;
	private Date endDate;
	
	//constructors
	public Ticket(String desc, String notes, String solution, String status,
			Date start) {
		setTicketDesc(desc);
		setTicketNotes(notes);
		setTicketSolution(solution);
		setTicketStatus(status);
		setStartDate(start);
	}
	
	public Ticket() {
		
	}
	
	public Ticket(String desc, String status, java.sql.Date start) {
		Database.insertStatement(desc, status, start);
	}

	//setters
	public void setStartDate(Date start) {
		// TODO Auto-generated method stub
		this.startDate = start;
	}

	public void setTicketStatus(String status) {
		// TODO Auto-generated method stub
		this.ticketStatus = status;
	}

	public void setTicketSolution(String solution) {
		// TODO Auto-generated method stub
		this.ticketSolution = solution;
	}

	public void setTicketNotes(String notes) {
		// TODO Auto-generated method stub
		this.ticketNotes = notes;
	}

	public void setTicketDesc(String desc) {
		// TODO Auto-generated method stub
		this.ticketDesc = desc;
	}

	//getters
	public static List<Object> getTicketNum() {
		return Database.selectStatement("ticket_number", "tbticket", 1);
	}
	
	public static Object getTicketDescription(int num) {
		return Database.selectStatement("ticket_description", "tbticket", 2, "ticket_number", (Object)num);
	}
	
	public static Object getTicketNotes(int num) {
		return Database.selectStatement("ticket_notes", "tbticket", 2, "ticket_number", (Object)num);
	}
	
	public static Object getTicketSolution(int num) {
		return Database.selectStatement("ticket_solution", "tbticket", 2, "ticket_number", (Object)num);
	}
	
	public static Object getTicketStatus(int num) {
		return Database.selectStatement("ticket_status", "tbticket", 2, "ticket_number", (Object)num);
	}
	
	public static Object getStartDate(int num) {
		return Database.selectStatement("ticket_date_start", "tbticket", 2, "ticket_number", (Object)num);
	}
	
	public static Object getEndDate(int num) {
		return Database.selectStatement("ticket_date_end", "tbticket", 2, "ticket_number", (Object)num);
	}
	
	
}
