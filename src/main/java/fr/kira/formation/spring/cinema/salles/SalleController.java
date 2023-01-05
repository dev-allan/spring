package fr.kira.formation.spring.cinema.salles;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kira.formation.spring.cinema.salles.dto.SalleDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("salles")
@CrossOrigin
public class SalleController {

  private final SalleService service;
  private final ObjectMapper mapper;

  public SalleController(SalleService service, ObjectMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @GetMapping
  public Iterable<Salle> findAll() {
    return service.findAll();
  }

  @GetMapping("{id}")
  public Salle findById(Integer id) {
    return service.findById(id);
  }

  @PostMapping
  public Salle save(@RequestBody Salle salle) {
    return service.save(salle);
  }

  @DeleteMapping("{id}")
  public void deleteById(Integer id) {
    service.deleteById(id);
  }

  @GetMapping("byDate")
  public List<SalleDto> findByDate(@RequestParam LocalDate date) {
    return service.findSallesAvailableByDate(date).stream().map(salle -> mapper.convertValue(salle, SalleDto.class)).toList();
  }
}
