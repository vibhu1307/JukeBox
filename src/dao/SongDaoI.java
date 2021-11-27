package dao;

import java.util.List;

import model.Song;

public interface SongDaoI 

{
	//task 1
	public List <Song> DisplayData(Song song1);    //for displaying the song from table.
	
	public List<Song> searchwithGenreName(List<Song> sObj, String genereName);    //for searching song with genre name
	
	public List<Song> searchWithAlbumName(List<Song> sObj, String albumName);		//for searching song with album name
	
	public List<Song> searchWithArtistName(List<Song> sObj, String artistName);		//for searching song with artist name
	
	public List<Song> searchWithSongName(List<Song> sObj, String songName);			//for searching for song name.
	
}
