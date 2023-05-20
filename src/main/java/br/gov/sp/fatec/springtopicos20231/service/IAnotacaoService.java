package br.gov.sp.fatec.springtopicos20231.service;

import java.util.List;

import br.gov.sp.fatec.springtopicos20231.dto.AnotacaoUsuarioDTO;
import br.gov.sp.fatec.springtopicos20231.entity.Anotacao;

public interface IAnotacaoService {
    
    public Anotacao novaAnotacao(Anotacao anotacao);

    public List<Anotacao> buscarTodas();

    public List<AnotacaoUsuarioDTO> quantidadeAnotacoesPorUsuario();
}
