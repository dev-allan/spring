package fr.kira.formation.spring.cinema.salles;

import fr.kira.formation.spring.cinema.seances.SeanceService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalleService {

    private final SalleRepository repository;

    private final SeanceService seanceService;

    public SalleService(SalleRepository repository, SeanceService seanceService) {
        this.repository = repository;
        this.seanceService = seanceService;
    }

    public Salle save(Salle entity) {
        return repository.save(entity);
    }

    public Salle findById(Integer integer) {
        return repository.findById(integer).orElseThrow();
    }

    public void deleteById(Integer integer) {
        repository.deleteById(integer);
    }

    public Iterable<Salle> findAll() {
        return repository.findAll();
    }

    /**
     * Méthode permettant d'obtenir un liste de salles disponibles à une date donnée
     * Si aucune séance n'est affecté à une salle à une date donnée, renverra les salles disponibles
     * @param date au format LocalDate
     * @return Une liste de salles disponibles
     */
    public List<Salle> findSallesAvailableByDate(LocalDate date){
        var seances = seanceService.findByDate(date);
        var salles = repository.findAll();
        salles.removeIf(salle -> seances.stream().anyMatch(seance -> seance.getSalle().equals(salle)));
        return salles;
    }
}
