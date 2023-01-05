package fr.kira.formation.spring.cinema.tickets;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tickets")
@CrossOrigin
public class TicketController {

        private final TicketService service;

        public TicketController(TicketService service) {
            this.service = service;
        }

        @PostMapping
        public Ticket save(@RequestBody Ticket entity) {
            return service.save(entity);
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

}
