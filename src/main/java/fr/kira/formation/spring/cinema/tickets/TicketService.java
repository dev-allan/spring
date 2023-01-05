package fr.kira.formation.spring.cinema.tickets;

import fr.kira.formation.spring.cinema.seances.SeanceService;
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


    // TODO : Réserver des tickets pour une séance donnée
    // Vérifier le nombre de place disponible dans la seance
    // Vérifier si la séance existe
    // Si dispo, reserver séance sinon renvoyer erreur
    public Ticket save(Ticket entity) {
        var obtenirSeance = seanceService.findById(entity.getSeance().getId().intValue());
        if(obtenirSeance.getNombrePlace() >= entity.getNombrePlace()){
            System.out.println(obtenirSeance.getNombrePlace());
            System.out.println(entity.getNombrePlace());
            return repository.save(entity);
        } else {
            new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return entity;
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
