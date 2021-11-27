package model;

public class Song 
{
	//attributes
	private long songID ;
	private String songName ;
	private String songDuration ;
	private String artistName ;
	private String genreName ;
	private String albumName ;
	private String songPath;
	
	//constructor
	public Song(long songID, String songName, String songDuration, String artistName, String genreName,
			String albumName, String songPath) {
		
		this.songID = songID;
		this.songName = songName;
		this.songDuration = songDuration;
		this.artistName = artistName;
		this.genreName = genreName;
		this.albumName = albumName;
		this.songPath = songPath;
	}

	public Song() {
		super();
	}

	
	//getter and setter
	public long getSongID() {
		return songID;
	}

	public void setSongID(long songID) {
		this.songID = songID;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongDuration() {
		return songDuration;
	}

	public void setSongDuration(String songDuration) {
		this.songDuration = songDuration;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getSongPath() {
		return songPath;
	}

	public void setSongPath(String songPath) {
		this.songPath = songPath;
	}
	
	//to string method
	@Override
	public String toString() {
		return "Song [songID=" + songID + ", songName=" + songName + ", songDuration=" + songDuration + ", artistName="
				+ artistName + ", genreName=" + genreName + ", albumName=" + albumName + ", songPath=" + songPath + "]";
	}
	
	
	
	
	

	
	

	
	

	
	
	
	
}
