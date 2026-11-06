package com.hibernert.Hibernet_intro;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Anime {
	
	@Id
	private int Anime_id;
	
	private String Anime_Name;
	private int  Anime_Year;
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
	public int getAnime_Year() {
		return Anime_Year;
	}
	public void setAnime_Year(int anime_Year) {
		Anime_Year = anime_Year;
	}
	@Override
	public String toString() {
		return "Anime [Anime_id=" + Anime_id + ", Anime_Name=" + Anime_Name + ", Anime_Year=" + Anime_Year + "]";
	}
	
	
	
	
	
	

}
