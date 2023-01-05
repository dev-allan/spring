package fr.kira.formation.spring.cinema.tickets.dto;

import fr.kira.formation.spring.cinema.seances.Seance;
import lombok.Data;

@Data
public class TicketDto {
  private Long id;
  private String nomClient;
  private int nombrePlace;
  private Seance seance;
}
