package model.entities.usuario;

import model.entities.automovel.Automovel;

import java.util.Set;
import java.util.TreeSet;

public class Usuario {

    private final Set<Automovel> automoveis;
    private final String email;
    private final String username;
    private String nomeCompleto;
    private String password;

    public Usuario(String nomeCompleto, String email, String username, String password) {
        this.automoveis = new TreeSet<>();
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Set<Automovel> getAutomoveis() {
        return automoveis;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
