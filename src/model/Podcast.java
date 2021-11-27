package model;

public class Podcast 
{
	//attributes
	private long podcastId ;
	private String podcastName ;
	private String celebrityName ;
	private String duration ;
	private String releaseDate ;
	private String podcastPath;
	
	//constructor
	
	public Podcast(long podcastId, String podcastName, String celebrityName, String duration, String releaseDate,
			String podcastPath) {
		super();
		this.podcastId = podcastId;
		this.podcastName = podcastName;
		this.celebrityName = celebrityName;
		this.duration = duration;
		this.releaseDate = releaseDate;
		this.podcastPath = podcastPath;
	}


	public Podcast() {
		super();
	}

	//getter and setter

	public long getPodcastId() {
		return podcastId;
	}


	public void setPodcastId(long podcastId) {
		this.podcastId = podcastId;
	}


	public String getPodcastName() {
		return podcastName;
	}


	public void setPodcastName(String podcastName) {
		this.podcastName = podcastName;
	}


	public String getCelebrityName() {
		return celebrityName;
	}


	public void setCelebrityName(String celebrityName) {
		this.celebrityName = celebrityName;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}


	public String getPodcastPath() {
		return podcastPath;
	}


	public void setPodcastPath(String podcastPath) {
		this.podcastPath = podcastPath;
	}

	//to string method
	@Override
	public String toString() {
		return "Podcast [podcastId=" + podcastId + ", podcastName=" + podcastName + ", celebrityName=" + celebrityName
				+ ", duration=" + duration + ", releaseDate=" + releaseDate + ", podcastPath=" + podcastPath + "]";
	}
	
	

	
	
	}
	
	

