package com.sgpvalid.admin.mb;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ProgressBarView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer progress;
	private Integer val = 0;
	private boolean pass = Boolean.FALSE;
	
	public void atualizaBarra() throws IOException {
	    int contador = 0;
	    List<String> lines = Files.readAllLines(Paths.get("C:\\temp\\bb\\prepostagem\\pos241215.txt"));	
	    Integer t = lines.size() / 100;
	    for (String linha : lines) {
		System.out.println(linha);
		setVal(t);
	    }
	    System.out.println("leitura concluida;");
	  //	    for(int i = 0; i < 3; i++) {
//		setVal(25);
//	    }
	    
	}
	
	public Integer getProgress() {
		if (progress == null) {
			progress = 0;
		} else {
			if (pass) {
				progress += getVal();
			}
			pass = Boolean.TRUE;
		}

		if (progress >= 100) {
			progress = 100;
		}
		return progress;

	}

	
	public Integer getVal() {
	    return val;
	}

	public void setVal(Integer val) {
	    this.val = val;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	public void onComplete() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Progress Completed"));
	}

	public void cancel() {
		progress = 0;
	}
}