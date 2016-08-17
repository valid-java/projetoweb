package com.sgpvalid.admin.listener;

import javax.enterprise.event.Observes;

import com.sgpvalid.admin.model.Usuario;

public class LoginListener {

	public void onLogin(@Observes Usuario usuario) {
		System.out.printf("O usuario [%s] se logou no sistema", usuario.getLogin());
	}
	
	
	
}
