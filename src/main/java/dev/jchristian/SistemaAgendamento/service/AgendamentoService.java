package dev.jchristian.SistemaAgendamento.service;

import dev.jchristian.SistemaAgendamento.dto.AgendamentoCreateRequest;
import dev.jchristian.SistemaAgendamento.dto.AgendamentoResponse;
import dev.jchristian.SistemaAgendamento.dto.AgendamentoUpdateRequest;
import dev.jchristian.SistemaAgendamento.mapper.AgendamentoMapper;
import dev.jchristian.SistemaAgendamento.model.AgendamentoModel;
import dev.jchristian.SistemaAgendamento.model.StatusAgendamento;
import dev.jchristian.SistemaAgendamento.repository.AgendamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public AgendamentoResponse criar(@Valid AgendamentoCreateRequest req) {

        validarIntervalo(req.dataInicio(), req.dataFim());
        checarConflito(req.usuario(), req.dataInicio(), req.dataFim(), null);

        AgendamentoModel entity = AgendamentoMapper.toEntity(req);
        entity = repository.save(entity);
        return AgendamentoMapper.toResponse(entity);
    }

    @Transactional
    public AgendamentoResponse atualizar(Long id, @Valid AgendamentoUpdateRequest req) {

        AgendamentoModel entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado"));
        AgendamentoMapper.merge(entity, req);
        validarIntervalo(req.dataInicio(), req.dataFim());
        checarConflito(entity.getUsuario(), req.dataInicio(), req.dataFim(), entity.getId());
        entity = repository.save(entity);
        return AgendamentoMapper.toResponse(entity);
    }

    @Transactional
    public AgendamentoResponse cancelar(Long id) {
        AgendamentoModel entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado"));
        entity.setStatus(StatusAgendamento.CANCELADO);
        entity = repository.save(entity);
        return AgendamentoMapper.toResponse(entity);
    }

    @Transactional
    public AgendamentoResponse concluir(Long id) {
        AgendamentoModel entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado"));
        entity.setStatus(StatusAgendamento.CONCLUIDO);
        entity = repository.save(entity);
        return AgendamentoMapper.toResponse(entity);
    }

    @Transactional()
    public AgendamentoResponse buscarPorId(Long id) {
        AgendamentoModel a = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado"));
        return AgendamentoMapper.toResponse(a);
    }

    private void validarIntervalo(LocalDateTime inicio, LocalDateTime fim) {
        if (inicio == null || fim == null || inicio.isBefore(fim)) {
            throw new IllegalArgumentException("Intervalo inálido: dataInicio dev ser anteriro a dataFim");
        }
    }

    private void checarConflito(String usuario, LocalDateTime inicio, LocalDateTime fim, Long id) {
        boolean conflito = repository.existsConflito(usuario, inicio, fim, id);
        if (conflito) {
            throw new IllegalArgumentException("Conflito na agenda: já existe agendamento nesse período");
        }
    }

}
