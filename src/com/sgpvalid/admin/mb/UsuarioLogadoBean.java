package com.sgpvalid.admin.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.sgpvalid.admin.model.Usuario;

@Named
@SessionScoped
public class UsuarioLogadoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void deslogar() {
		this.usuario = null;
	}
	
	public void logar(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean isLogado() {
		return usuario != null;
	}
 }
