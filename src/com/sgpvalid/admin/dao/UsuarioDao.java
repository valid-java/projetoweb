package com.sgpvalid.admin.dao;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.List;

import javax.ejb.Stateless;

import com.sgpvalid.admin.model.Usuario;

@Stateless
public class UsuarioDao extends Repository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Usuario existe(Usuario usuario) {
		try {
			Usuario usuarioEncontrado = getPurePojo(Usuario.class, "select u from Usuario u where u.login =?1 and u.senha =?2", usuario.getLogin(), getMD5(usuario.getSenha()));
			return usuarioEncontrado;
	
		} catch (Exception e) {
			return null;
		}
	}

	public List<Usuario> listaTodos() {
//		return manager.createQuery("from Usuario", Usuario.class).getResultList();
		return getPureList(Usuario.class, "select u from Usuario u");
	}

	public Usuario adiciona(Usuario usuario) {
		usuario.setSenha(getMD5(usuario.getSenha()));
		return addEntity(Usuario.class, usuario);
	}
	
	private String getMD5(String password) {
		String digest = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] hash = md.digest(password.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder(2 * hash.length);
			for (byte b : hash) {
				sb.append(String.format("%02x", b & 0xff));
			}
			digest = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return digest;
	}

	public void remover(Usuario usuario) {
			removeEntity(usuario);
	}
}
