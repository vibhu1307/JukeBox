package dao;

import model.PlayList;

public interface PlayListDaoI 
{

	//task 3
	public void displayPlayList();		//for displaying the playlist.
	
	public void addSong(PlayList playlist);  //for adding the song in song playlist.
	
	public void addPodcast(PlayList playlist);		//for adding a song in podcast playlist.
	
	public void addBothCombination(PlayList playlist); //for adding both song and podcast.
	
	public void searchPlayList(PlayList playlist); //for searching the playlist.
}
