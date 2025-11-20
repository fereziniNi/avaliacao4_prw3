package br.edu.ifsp.provaPRW3.api_2025_bes.entity;

import br.edu.ifsp.provaPRW3.api_2025_bes.models.DadosAtualizadaoConsertoDTO;
import br.edu.ifsp.provaPRW3.api_2025_bes.models.DadosConserto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.swing.text.StyledEditorKit;
import java.util.UUID;

@Table(name = "conserto")
@Entity(name = "Conserto")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true, updatable = false)
    private final String uuid = UUID.randomUUID().toString();

    private String dt_inicio;
    private String dt_fim;

    @Embedded
    private Veiculo veiculo;

    @Embedded
    private Mecanico mecanico;

    private Boolean ativo;


    public Conserto(DadosConserto dados) {
        this.dt_inicio = dados.dt_inicio();
        this.dt_fim = dados.dt_fim();
        this.veiculo = new Veiculo(dados.veiculoDTO());
        this.mecanico = new Mecanico(dados.mecanicoResp());
        this.ativo = true;
    }

    public Boolean isAtivo(){
        return ativo;
    }

    public void excluir(){
        this.ativo = false;
    }

    public void atualizarInfo(DadosAtualizadaoConsertoDTO dados){
        if (dados.dt_fim() != null){
            this.dt_fim = dados.dt_fim();
        }
        if(dados.mecanicoDTO() != null){
            this.mecanico.atualizarInfo(dados.mecanicoDTO());
        }
    }
}
