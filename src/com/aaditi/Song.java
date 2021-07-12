package com.aaditi;

public class Song {
	String title; 
	double duration;
	
	public Song(String title , double duration) {
		this.title=title;
		this.duration=duration;
	}
	
	public Song() {
		this.title="";
		this.duration=0.0;
	}

	public String getTitle() {
		return title;
	}

	

	public double getDuration() {
		return duration;
	}

	

	@Override
	public String toString() {
		return "Song {title=" + title + ", duration=" + duration + "}";
	}
}
