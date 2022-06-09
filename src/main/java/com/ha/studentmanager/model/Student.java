package com.ha.studentmanager.model;

import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_student")
public class Student {
	@Id
	// @GeneratedValue (strategy = GenerationType.IDENTITY)
	private String id;
	private String name;
	private Boolean male;
	@Temporal(TemporalType.DATE)
	private Calendar birthday;
	@Column(name = "place_of_birth")
	private String placeOfBirth;
	private String address;
	@Column(name = "dep_name")
	private String depName;

	public Student() {
	}

	public Student(String id, String name, Boolean male, Calendar birthday, String placeOfBirth, String address,
			String depName) {
		super();
		this.id = id;
		this.name = name;
		this.male = male;
		this.birthday = birthday;
		this.placeOfBirth = placeOfBirth;
		this.address = address;
		this.depName = depName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getMale() {
		return male;
	}

	public void setMale(Boolean male) {
		this.male = male;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", male=" + male + ", birthday=" + birthday + ", placeOfBirth="
				+ placeOfBirth + ", address=" + address + ", depName=" + depName + "]";
	}

}
