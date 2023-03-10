package fr.kira.formation.spring.cinema.seances;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SeanceService {

    private final SeanceRepository repository;


    public SeanceService(SeanceRepository repository) {
        this.repository = repository;
    }

    public List<Seance> findAll() {
        return repository.findAll();
    }

    public Seance save(Seance entity) {
        return repository.save(entity);
    }

    public Seance findById(Integer integer) {
        return repository.findById(integer).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(Integer integer) {
        repository.deleteById(integer);
    }

    public List<Seance> findByDate(LocalDate date){
        return this.repository.findByDate(date);
    }
}
