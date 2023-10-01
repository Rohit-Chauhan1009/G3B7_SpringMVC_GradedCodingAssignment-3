package com.greatLearing.TicketTrackerApplications.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column(name = "Ticket_Title")
	private String title;

	@Column(name = "Ticket_Description")
	private String description;
	
	@Column(name = "content")
    private String content;

	@CreationTimestamp
	@Column(name = "created_date")
	private LocalDateTime createdDate;


}
