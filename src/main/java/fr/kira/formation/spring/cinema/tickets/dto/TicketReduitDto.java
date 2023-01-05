package fr.kira.formation.spring.cinema.tickets.dto;

import lombok.Data;

@Data
public class TicketReduitDto {
  private Integer id;
  private String nomClient;
  private int nombrePlace;
}
