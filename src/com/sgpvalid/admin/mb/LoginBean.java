package com.sgpvalid.admin.mb;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgpvalid.admin.dao.UsuarioDao;
import com.sgpvalid.admin.listener.Autorizador;
import com.sgpvalid.admin.model.Login;
import com.sgpvalid.admin.model.Usuario;
import com.sgpvalid.util.FacesUtil;

@Named
@RequestScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	private Login login = new Login();

	@Inject
	private UsuarioDao usuarioDao;
	@Inject
	Event<Usuario> eventLogin;
	@Inject
	private UsuarioLogadoBean usuarioLogado;

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String efetuaLogin() {
		usuario = usuarioDao.existe(this.usuario);

		if (usuario != null)
			System.out.println("O login era valido? " + usuario.getLogin());

		if (usuario != null) {
			eventLogin.fire(usuario);
			usuarioLogado.logar(usuario);

			return "/limited/inicio?faces-redirect=true";
		} else

			FacesUtil.msg("User or password invalid.", FacesMessage.SEVERITY_ERROR);
		usuarioLogado.deslogar();
		usuario = new Usuario();
		return "";
	}

	public void logout() {
		usuarioLogado.deslogar();
		usuario = new Usuario();
		try {
			Autorizador.ec.redirect(Autorizador.ec.getRequestContextPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
