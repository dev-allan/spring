package fr.kira.formation.spring.cinema.salles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SalleRepository extends JpaRepository<Salle, Integer> {

  /**
   * Doit afficher les salles disponibles à une date données (salle où aucune séance n'est programmée)
   * @param date
   * @return
   */
  @Query("SELECT sa FROM Salle sa LEFT JOIN FETCH Seance se ON sa.id = se.salle.id WHERE se.date = :date")
  List<Salle> findByDate(@Param("date") LocalDate date);
}
