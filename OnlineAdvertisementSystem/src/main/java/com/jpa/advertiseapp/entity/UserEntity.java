package com.jpa.advertiseapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity 
{
		
		@Id
		@GeneratedValue
		@Column(name="id")
		private int id;

		@Column(name="name")
		private String name;
		
		@Column(name="address")
		private String address;
		
		@Column(name="contact_no")
		private long contact_no;
		
		@Column(name="email")
		private String email;
		
		
		public UserEntity(int id, String name, String address, long contact_no, String email) {
			super();
			this.id = id;
			this.name = name;
			this.address = address;
			this.contact_no = contact_no;
			this.email = email;
		}
		
		public UserEntity(String name, String address, long contact_no, String email) {
			super();
			this.name = name;
			this.address = address;
			this.contact_no = contact_no;
			this.email = email;
		}

		public UserEntity() {
			super();
		}

		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public long getContact_no() {
			return contact_no;
		}

		public void setContact_no(long contact_no) {
			this.contact_no = contact_no;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", address=" + address + ", contact_no="+contact_no+  "]";
		}
		
	}
