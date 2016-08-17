package com.sgpvalid.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {

	public static void msg(String mensagem, FacesMessage.Severity faces) {
		FacesMessage fm = new FacesMessage(faces,  mensagem, mensagem);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, fm);
	}
}
