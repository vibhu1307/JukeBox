package model;

public class PlayList 
{
	//Attribures
	private String playListName;
	private String songName;
	private String podcastName;
	private long songID;
	private long podcastId;
	
	//Constructor
	public PlayList(String playListName, String songName, String podcastName, long songID, long podcastId) {
		super();
		this.playListName = playListName;
		this.songName = songName;
		this.podcastName = podcastName;
		this.songID = songID;
		this.podcastId = podcastId;
	}

	public PlayList() {
		super();
	}

	//getter and setter
	public String getPlayListName() {
		return playListName;
	}

	public void setPlayListName(String playListName) {
		this.playListName = playListName;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getPodcastName() {
		return podcastName;
	}

	public void setPodcastName(String podcastName) {
		this.podcastName = podcastName;
	}

	public long getSongID() {
		return songID;
	}

	public void setSongID(long songID) {
		this.songID = songID;
	}

	public long getPodcastId() {
		return podcastId;
	}

	public void setPodcastId(long podcastId) {
		this.podcastId = podcastId;
	}

	//to string method
	@Override
	public String toString() {
		return "PlayList [playListName=" + playListName + ", songName=" + songName + ", podcastName=" + podcastName
				+ ", songID=" + songID + ", podcastId=" + podcastId + "]";
	}
	
	
	
	
	
	
}
