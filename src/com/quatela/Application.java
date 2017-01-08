package com.quatela;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		/*List<Ticket> ticket = new ArrayList<>();
		
		ticket.add(new Ticket().getTicket());
		
		System.out.println(ticket[0]);*/
		
		List<Object> num = new ArrayList<>();
		Ticket ticket;
		
		num = Ticket.getTicketNum();
		
		System.out.println("Ticket Numbers:");
		for(Object i : num) {
			System.out.println((int)i);
		}
		
		System.out.println("\nPick a ticket number to get ticket information: ");
		int ticketNum = input.nextInt();
		
		String descrip = (String)Ticket.getTicketDescription(ticketNum);
		String notes = (String)Ticket.getTicketNotes(ticketNum);
		String solution = (String)Ticket.getTicketSolution(ticketNum);
		Date startDate = (Date)Ticket.getStartDate(ticketNum);
		Date endDate = (Date)Ticket.getEndDate(ticketNum);
		
		System.out.printf("Description: %s\n", descrip);
		System.out.printf("      Notes: %s\n", notes);
		System.out.printf("   Solution: %s\n", solution);
		System.out.printf(" Start Date: %s\n", startDate);
		System.out.printf("   End Date: %s\n", endDate);
		
		System.out.println("Create a new Ticket");
		System.out.print("Enter Description: ");
		String descInsert = input.next();
		System.out.println();
		System.out.print("Enter Status: ");
		String insertStatus = input.nextLine();
		System.out.println();

		String date = "01-08-2017";
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		java.util.Date utilDate = null;
		try {
			utilDate = format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		ticket = new Ticket(descInsert, insertStatus, sqlDate);
		System.out.println("Success!");
		
	}
}
