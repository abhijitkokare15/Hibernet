package com.hibernert.Hibernet_intro;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Anime {
	
	@Id
	private int Anime_id;
	private String Anime_Name;
//	private int  Anime_Year;
	
	
	private Anime_relase Release_date;
	
//	@ManyToOne
//	private Audeince audience;
//	
	
	@ManyToMany
	private List<Audeince> ls = new ArrayList<Audeince>();
	
	
	
	public List<Audeince> getLs() {
		return ls;
	}
	public void setLs(List<Audeince> ls) {
		this.ls = ls;
	}

	public Anime_relase getRelease_date() {
		return Release_date;
	}
	public void setRelease_date(Anime_relase release_date) {
		Release_date = release_date;
	}

     @Override
	public String toString() {
		return "Anime [Anime_id=" + Anime_id + ", Anime_Name=" + Anime_Name + ", Release_date=" + Release_date + "]";
	}
	public int getAnime_id() {
		return Anime_id;
	}
	public void setAnime_id(int anime_id) {
		Anime_id = anime_id;
	}
	public String getAnime_Name() {
		return Anime_Name;
	}
	public void setAnime_Name(String anime_Name) {
		Anime_Name = anime_Name;
	}
	
	
	
	
	
	
	

}
