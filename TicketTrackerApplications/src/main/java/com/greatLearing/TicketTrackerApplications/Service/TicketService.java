package com.greatLearing.TicketTrackerApplications.Service;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import com.greatLearing.TicketTrackerApplications.model.Ticket;

public interface TicketService {

	Ticket createTicket(Ticket ticket);

	List<Ticket> getAllTicket();

	Ticket getTicketById(Long id);

	Ticket updateTicket(Long id, Ticket ticket);

	void deleteTicket(Long id);

	List<Ticket> searchTickets(String query);

	Optional<Ticket> getTicketByTheId(Long id);
}
