package com.sgpvalid.admin.listener;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import com.sgpvalid.admin.mb.UsuarioLogadoBean;

public class Autorizador implements PhaseListener {


	private static final long serialVersionUID = 1L;
	
	@Inject
	UsuarioLogadoBean usuarioLogado;
	private FacesContext fc;
	public static ExternalContext ec;
	
	@Override
	public void afterPhase(PhaseEvent event) {

		fc = event.getFacesContext();
	    ec = fc.getExternalContext();
		
		if(!fc.getViewRoot().getViewId().contains("login.xhtml")) {
			if(!usuarioLogado.isLogado()) {
				try {
					ec.redirect(ec.getRequestContextPath());
				} catch (IOException e) {
				}
			} 
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
