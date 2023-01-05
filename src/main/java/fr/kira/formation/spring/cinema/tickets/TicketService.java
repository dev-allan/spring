package fr.kira.formation.spring.cinema.tickets;

import fr.kira.formation.spring.cinema.seances.Seance;
import fr.kira.formation.spring.cinema.seances.SeanceService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TicketService {

  private final TicketRepository repository;
  private final SeanceService seanceService;

  public TicketService(TicketRepository repository, SeanceService seanceService) {
    this.repository = repository;
    this.seanceService = seanceService;
  }


  /**
   * Methode permettant la création d'une réservation en vérifiant s'il y a assez de places dans la séance
   * S'il n'y a pas assez de places, renverra une erreur 409 sinon créera le ticket en décrémentant le nombre
   * de places disponibles pour la séance
   * @param ticket
   * @return le ticket
   */
  @Transactional
  public Ticket save(Ticket ticket) {
    var seance = seanceService.findById(ticket.getSeance().getId().intValue());
    if (seance.getNombrePlace() < ticket.getNombrePlace()) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Il n'y a plus de places disponibles pour cette séance");
    }
    seance.setNombrePlace(seance.getNombrePlace() - ticket.getNombrePlace());
    seanceService.save(seance);
    return repository.save(ticket);
  }

  public Ticket findById(Integer integer) {
    return repository.findById(integer).orElseThrow();
  }

  public void deleteById(Integer integer) {
    repository.deleteById(integer);
  }

  public Iterable<Ticket> findAll() {
    return repository.findAll();
  }


}
