package dev.jchristian.SistemaAgendamento.dto;

import dev.jchristian.SistemaAgendamento.model.StatusAgendamento;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record AgendamentoResponse(
        Long id,
        String titulo,
        String descricao,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        StatusAgendamento status,
        String usuario,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm) {
}
