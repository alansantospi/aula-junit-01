package com.ada.aulajunit.service;

import com.ada.aulajunit.exceptions.UsuarioNaoEncontradoException;
import com.ada.aulajunit.modelo.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {


    private List<Usuario> usuarios;


    public UsuarioService() {
        this.popularUsuarios();
    }

    public void popularUsuarios(){
        for (int i=0; i < 5; i++){
            usuarios.add(new Usuario("user"+i, "user"+i, "pwd"+i));
        }
    }

    public Usuario fazerLogin(String login, String senha) throws UsuarioNaoEncontradoException {
        for (Usuario u : usuarios ) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)){
                return u;
            }
        }
        throw new UsuarioNaoEncontradoException();
    }

}
