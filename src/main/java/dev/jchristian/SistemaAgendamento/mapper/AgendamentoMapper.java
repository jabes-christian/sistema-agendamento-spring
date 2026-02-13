package dev.jchristian.SistemaAgendamento.mapper;

import dev.jchristian.SistemaAgendamento.dto.AgendamentoCreateRequest;
import dev.jchristian.SistemaAgendamento.dto.AgendamentoResponse;
import dev.jchristian.SistemaAgendamento.dto.AgendamentoUpdateRequest;
import dev.jchristian.SistemaAgendamento.model.AgendamentoModel;
import dev.jchristian.SistemaAgendamento.model.StatusAgendamento;

import java.time.LocalDateTime;

public class AgendamentoMapper {

    public static AgendamentoModel toEntity (AgendamentoCreateRequest req) {
        return AgendamentoModel.builder()
                .titulo(req.titulo())
                .descricao(req.descricao())
                .dataInicio(req.dataInicio())
                .dataFim(req.dataFim())
                .usuario(req.usuario())
                .status(StatusAgendamento.AGENDADO)
                .criadoEm(LocalDateTime.now())
                .atualizadoEm(LocalDateTime.now())
                .build();
    }

    public static void merge(AgendamentoModel entity, AgendamentoUpdateRequest req) {
        if (req.titulo() != null) {
            entity.setTitulo(req.titulo());
        }
        if (req.descricao() != null) {
            entity.setDescricao(req.descricao());
        }
        if (req.dataInicio() != null) {
            entity.setDataInicio(req.dataInicio());
        }
        if (req.dataFim() != null) {
            entity.setDataFim(req.dataFim());
        }
    }

    public static AgendamentoResponse toResponse (AgendamentoModel a) {
        return new AgendamentoResponse(
                a.getId(),
                a.getTitulo(),
                a.getDescricao(),
                a.getDataInicio(),
                a.getDataFim(),
                a.getStatus(),
                a.getUsuario(),
                a.getCriadoEm(),
                a.getAtualizadoEm()
        );
    }
}
