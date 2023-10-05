package com.greatLearing.TicketTrackerApplications.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatLearing.TicketTrackerApplications.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	List<Ticket> findByTitleContainingOrDescriptionContaining(String query, String query2);

}
