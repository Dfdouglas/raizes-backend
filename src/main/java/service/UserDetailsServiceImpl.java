package com.raizes.backend.service;

import com.raizes.backend.model.Usuario;
import com.raizes.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Serviço usado pelo Spring Security para buscar usuários no banco
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // O Spring chama este método quando alguém tenta autenticar
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // Busca o usuário pelo e-mail no banco
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        // Retorna o usuário no formato que o Spring Security entende
        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getSenha())
                .roles(usuario.getPerfil().name())
                .build();
    }
}