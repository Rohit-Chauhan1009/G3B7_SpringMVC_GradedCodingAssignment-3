package com.greatLearing.TicketTrackerApplications.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatLearing.TicketTrackerApplications.Service.TicketService;
import com.greatLearing.TicketTrackerApplications.model.Ticket;

@Controller
//@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	TicketService ticketService;

	@GetMapping("/tickets")
	public String listTickets(Model model) {
		List<Ticket> tickets = ticketService.getAllTicket();
		model.addAttribute("tickets", tickets);
		return "tickets";
	}

	@GetMapping("/tickets/new")
	public String createTicketForm(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "create_ticket";
	}

	@PostMapping("/tickets")
	public String createTicket(@ModelAttribute("ticket") Ticket tickets) {
		ticketService.createTicket(tickets);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/{id}")
	public String viewTicket(@PathVariable Long id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "ticket_view";
	}

	@GetMapping("/tickets/edit/{id}")
	public String editTicketForm(@PathVariable Long id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "edit_ticket";
	}

	@PostMapping("/ticket/edit/{id}")
	public String editTicket(@PathVariable Long id, @ModelAttribute Ticket ticket) {
		ticketService.updateTicket(id, ticket);
		return "redirect:/tickets";
	}

	@GetMapping("/ticket/delete/{id}")
	public String deleteTicket(@PathVariable Long id) {
		ticketService.deleteTicket(id);
		return "redirect:/tickets";
	}
	
//	@GetMapping("/tickets/search")
//	public String searchTickets(@RequestParam(name = "query") String query, Model model) {
//	    List<Ticket> searchResults;
//	    try {
//	        Long ticketId = Long.parseLong(query);
//	        // If the query can be parsed into a Long, search by ID
//	        Ticket ticket = ticketService.getTicketById(ticketId);
//	        searchResults = ticket != null ? Collections.singletonList(ticket) : Collections.emptyList();
//	    } catch (NumberFormatException e) {
//	        // If parsing as Long fails, search by title
//	        searchResults = ticketService.searchTickets(query);
//	    }
//	    model.addAttribute("tickets", searchResults);
//	    return "tickets";
//	}
	@GetMapping("/tickets/search")
	public String searchTickets(@RequestParam(name = "query") String query, Model model) {
	    List<Ticket> searchResults;
	    String errorMessage = null;
	    try {
	        Long ticketId = Long.parseLong(query);
	        // If the query can be parsed into a Long, search by ID
	        Optional<Ticket> ticketOptional = ticketService.getTicketByTheId(ticketId);
	        if (ticketOptional.isPresent()) {
	            searchResults = Collections.singletonList(ticketOptional.get());
	        } else {
	            searchResults = Collections.emptyList();
	            errorMessage = "Ticket with ID " + ticketId + " not found.";
	        }
	    } catch (NumberFormatException e) {
	        // If parsing as Long fails, search by title
	        searchResults = ticketService.searchTickets(query);
	        if (searchResults.isEmpty()) {
	            errorMessage = "No tickets found with title: " + query;
	        }
	    }
	    model.addAttribute("tickets", searchResults);
	    model.addAttribute("errorMessage", errorMessage);
	    return "tickets";
	}


}
