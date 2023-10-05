package com.greatLearing.TicketTrackerApplications.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearing.TicketTrackerApplications.Repository.TicketRepository;
import com.greatLearing.TicketTrackerApplications.model.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public Ticket createTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> getAllTicket() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket getTicketById(Long id) {
		return ticketRepository.findById(id).get();
	}

	@Override
	public Ticket updateTicket(Long id, Ticket ticket) {
		if (ticketRepository.existsById(id)) {
			ticket.setId(id);
			return ticketRepository.save(ticket);
		} else {
			return null;
		}
	}

	@Override
	public void deleteTicket(Long id) {
		// TODO Auto-generated method stub
		ticketRepository.deleteById(id);
	}

	@Override
	public List<Ticket> searchTickets(String query) {
	    return ticketRepository.findByTitleContainingOrDescriptionContaining(query, query);
	}

	
	@Override
	public Optional<Ticket> getTicketByTheId(Long id) {
	    return ticketRepository.findById(id);
	}

}
