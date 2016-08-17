package com.sgpvalid.admin.mb;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgpvalid.admin.dao.UsuarioDao;
import com.sgpvalid.admin.model.Usuario;
import com.sgpvalid.util.FacesUtil;

@Named
@RequestScoped
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDao usuarioDao;
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	
	public List<Usuario> getUsuarios() {
		if(usuarios == null || usuarios.isEmpty()) {
			usuarios = usuarioDao.listaTodos();
		}
		return usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void verMsg() {
		FacesUtil.msg("Mensagem atualizada", FacesMessage.SEVERITY_INFO);
	}

	public void adicionaUsuario() {
			usuarioDao.adiciona(usuario);
			FacesUtil.msg("O usuário " + usuario.getNome()  + " foi adicionado com sucesso!", FacesMessage.SEVERITY_INFO);
			usuario = new Usuario();
			usuarios = usuarioDao.listaTodos();
	}
	
	public void remover(Usuario usuario) {
		usuarioDao.remover(usuario);
		FacesUtil.msg("O usuário " + usuario.getNome()  + " foi removido com sucesso!", FacesMessage.SEVERITY_INFO);
		usuarios = usuarioDao.listaTodos();
	}
}
