package fr.kira.formation.spring.cinema.tickets;

import fr.kira.formation.spring.cinema.seances.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

  List<Ticket> findBySeance(Seance seance);
}
