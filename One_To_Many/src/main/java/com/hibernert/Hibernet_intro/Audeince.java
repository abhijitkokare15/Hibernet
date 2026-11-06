package com.hibernert.Hibernet_intro;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity

public class Audeince {
	@Id
  private  int aude_id;
  private String name;
  private String date;
  @OneToOne
  private Anime anime;
public int getAude_id() {
	return aude_id;
}
public void setAude_id(int aude_id) {
	this.aude_id = aude_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public Anime getAnime() {
	return anime;
}
public void setAnime(Anime anime) {
	this.anime = anime;
}
@Override
public String toString() {
	return "Audeince [aude_id=" + aude_id + ", name=" + name + ", date=" + date + ", anime=" + anime + "]";
}
  
  
  
  
  
  
}
