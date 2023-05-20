package br.gov.sp.fatec.springtopicos20231.dto;

public class AnotacaoUsuarioDTO {

    private String usuario;

    private Long quantidadeAnotacao;

    public AnotacaoUsuarioDTO(String usuario, Long quantidadeAnotacao) {
        this.usuario = usuario;
        this.quantidadeAnotacao = quantidadeAnotacao;
    }

    public AnotacaoUsuarioDTO() { 
        //Do nothing 
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Long getQuantidadeAnotacao() {
        return quantidadeAnotacao;
    }

    public void setQuantidadeAnotacao(Long quantidadeAnotacao) {
        this.quantidadeAnotacao = quantidadeAnotacao;
    }
    
}
