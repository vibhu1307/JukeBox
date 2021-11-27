package dao;

import java.util.List;

import model.Podcast;


public interface PodcastDaoI 
{
	//task 2
	public List <Podcast> DisplayPodcast(Podcast songp);     	//displaying podcast
	
	public List<Podcast> searchwithcelebrityname(List<Podcast> pObj, String celebrityName);     //searching with celebrity name
	
	public List<Podcast> searchWithreleaseDate(List<Podcast> pObj, String releaseDate); 		//searching With release Date
	
	public List<Podcast> searchWithPodcastName(List<Podcast> pObj, String podcastName);			//searching with podcast name
}
