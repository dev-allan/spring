package fr.kira.formation.spring.cinema.salles;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalleService {

    private final SalleRepository repository;

    public SalleService(SalleRepository repository) {
        this.repository = repository;
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

    public List<Salle> findByDate(LocalDate date){
        System.out.println(date);
        return this.repository.findByDate(date);
    }

}
