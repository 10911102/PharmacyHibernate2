package com.medical.pojo;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int	id;
	@OneToMany (mappedBy = "id")
	private List<Medicine> medicines;
	@OneToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}
	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	@Override
	public String toString() {
		return "Prescription [id=" + id + ", medicine=" + medicines + ", Doctor_id="
				+ doctor + "]";
	}

}
