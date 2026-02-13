package dev.jchristian.SistemaAgendamento.repository;

import dev.jchristian.SistemaAgendamento.model.AgendamentoModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long> {

    @Query("""
        SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END
            FROM AgendamentoModel a
            WHERE a.usuario = :usuario
                AND a.status = dev.jchristian.SistemaAgendamento.model.StatusAgendamento.AGENDAMENTO
                AND (a.dataInicio < :fim AND dataFim > :inicio)
                AND (:ignoreId is NULL OR a.id <> : ignoredId)
    """)
    boolean existsConflito(@Param("usuario") String usuario,
                           @Param("inicio")LocalDateTime inicio,
                           @Param("fim") LocalDateTime fim,
                           @Param("ignoreId") Long ignoreId);

}
