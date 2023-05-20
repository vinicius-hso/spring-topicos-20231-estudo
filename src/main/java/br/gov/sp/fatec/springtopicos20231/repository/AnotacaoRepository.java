package br.gov.sp.fatec.springtopicos20231.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springtopicos20231.dto.AnotacaoUsuarioDTO;
import br.gov.sp.fatec.springtopicos20231.entity.Anotacao;

public interface AnotacaoRepository extends JpaRepository<Anotacao, Long>{
    
    public List<Anotacao> findByTextoContains(String texto);

    @Query("select a from Anotacao a where a.texto like %?1%")
    public List<Anotacao> buscarPorTexto(String texto);

    public List<Anotacao> findByUsuarioNome(String nomeUsuario);

    @Query("select a from Anotacao a join a.usuario u where u.nome = ?1")
    public List<Anotacao> buscarPorNomeUsuario(String nomeUsuario);

    @Query("select new br.gov.sp.fatec.springtopicos20231.dto.AnotacaoUsuarioDTO(u.nome, count(a)) " + 
            "from Anotacao a join a.usuario u group by u.nome")
    public List<AnotacaoUsuarioDTO> quantidadeAnotacoesPorUsuario();

}
