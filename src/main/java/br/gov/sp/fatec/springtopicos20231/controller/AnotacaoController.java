package br.gov.sp.fatec.springtopicos20231.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springtopicos20231.dto.AnotacaoUsuarioDTO;
import br.gov.sp.fatec.springtopicos20231.entity.Anotacao;
import br.gov.sp.fatec.springtopicos20231.service.IAnotacaoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/anotacao")
public class AnotacaoController {

    @Autowired
    private IAnotacaoService service;

    @GetMapping
    public List<Anotacao> buscarTodas() {
        return service.buscarTodas();
    }

    @GetMapping(value = "/quantidadePorUsuario")
    public List<AnotacaoUsuarioDTO> quantidadePorUsuario() {
        return service.quantidadeAnotacoesPorUsuario();
    }

    @PostMapping
    public Anotacao novaAnotacao(@RequestBody Anotacao anotacao) {
        return service.novaAnotacao(anotacao);
    }
    
}
