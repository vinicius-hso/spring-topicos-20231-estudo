package br.gov.sp.fatec.springtopicos20231.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springtopicos20231.entity.Autorizacao;
import br.gov.sp.fatec.springtopicos20231.entity.Usuario;
import br.gov.sp.fatec.springtopicos20231.repository.UsuarioRepository;

@Service
public class SegurancaService implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.findByNome(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
        return User.builder().username(username).password(usuario.getSenha())
            .authorities(usuario.getAutorizacoes().stream()
            .map(Autorizacao::getNome).collect(Collectors.toList())
            .toArray(new String[usuario.getAutorizacoes().size()]))
        .build();
    }
    
}
