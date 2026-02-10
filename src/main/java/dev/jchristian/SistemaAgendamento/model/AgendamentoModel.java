package dev.jchristian.SistemaAgendamento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_agendamento")
public class AgendamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "data-inicio", nullable = false)
    private String dataInicio;

    @Column(name = "data-fim", nullable = false)
    private String dataFim;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 120)
    private StatusAgendamento status;

    @Column(nullable = false, length = 80)
    private String usuario;

    @Column(name = "criado_em", nullable = false)
    private String criadoEm;

    @Column(name = "atualizado_em", nullable = false)
    private String atualizadoEm;
}
