package fr.kira.formation.spring.cinema.tickets;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kira.formation.spring.cinema.tickets.dto.TicketDto;
import fr.kira.formation.spring.cinema.tickets.dto.TicketReduitDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tickets")
@CrossOrigin
public class TicketController {

  private final TicketService service;
  private final ObjectMapper mapper;

  public TicketController(TicketService service, ObjectMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @PostMapping
  public TicketDto save(@RequestBody TicketDto ticket) {
    Ticket entityTicket = mapper.convertValue(ticket, Ticket.class);
    return mapper.convertValue(service.save(entityTicket), TicketDto.class);
  }

  @GetMapping("{id}")
  public Ticket findById(@PathVariable Integer integer) {
    return service.findById(integer);
  }

  @DeleteMapping("{id}")
  public void deleteById(@PathVariable Integer integer) {
    service.deleteById(integer);
  }

  @GetMapping
  public Iterable<Ticket> findAll() {
    return service.findAll();
  }

  @GetMapping("/seances/{id}")
  public List<TicketReduitDto> findBySeance(@PathVariable int id) {
    return service.findBySeance(id).stream().map(ticket -> mapper.convertValue(ticket, TicketReduitDto.class)).toList();
  }

}
