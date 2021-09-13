package com.usmp.persistencia.jpa.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //indicamos que es entidad
@Table(name = "TCurso") //Para darlde nombre de tabla en base de datos
public class CursoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private String nomCur, cic;
	private int numCre;
	private static final long serialVersionUID =1L;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomCur() {
		return nomCur;
	}
	public void setNomCur(String nomCur) {
		this.nomCur = nomCur;
	}
	public String getCic() {
		return cic;
	}
	public void setCic(String cic) {
		this.cic = cic;
	}
	public int getNumCre() {
		return numCre;
	}
	public void setNumCre(int numCre) {
		this.numCre = numCre;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "CursoEntity [id=" + id + ", nomCur=" + nomCur + ", cic=" + cic + ", numCre=" + numCre + "]";
	}
	
	
	
	
}
