package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.PodcastDaoImp;
import model.Podcast;

class PodcastTest 
{
	 private List <Podcast> PodcastList;        
	 private PodcastDaoImp podcastDaoImp;
	 private Podcast podcast;
	 private static boolean True;
	 
	 /**
	     * Run this before each test case
	     */ 
	@BeforeEach												//inserted value(data) in podcastlist
	void setUp() throws Exception {
		podcastDaoImp=new PodcastDaoImp();					//create object for podcastdaoimp
		// storing value using podcast constructor
		podcast=new Podcast(200,"Office Ladies", "Jenna Fisher", "1:30","2019-07-12","E:\\wave12jdbc\\jukebox\\src\\resources\\sample1.wav");    
		PodcastList = List.of(																//storing data in podcastlist
				podcast,
                new Podcast(201,"Need A Friend", "Connan O Brian", "0:50","2018-10-23","E:\\wave12jdbc\\jukebox\\src\\resources\\sample2.wav"),
                new Podcast(202,"What the tee", "RuPual", "1:20","2019-04-28","E:\\wave12jdbc\\jukebox\\src\\resources\\sample3.wav"),
                new Podcast(203,"Homan", "Con", "5:20","2014-02-28","E:\\wave12jdbc\\jukebox\\src\\resources\\sample4.wav"));
              
	}
		
	
	 	/**
			//   * Execute this after every test case
		//   */

	@AfterEach      											//after each execution it is nulling the value of podcastdaoimp
		void tearDown() throws Exception {
			podcastDaoImp=null;
	}

	@Test
	    public void givenListOfSearchWithCelebrityName(){

	        List<Podcast> list = podcastDaoImp.searchwithcelebrityname(PodcastList,"r");  //checking in list is there any celebrity name is start with r.
	      //checking the list size which contain search celebrity list size equals to pass value assertequals
	        assertEquals(1,list.size());											
	    }
	
	@Test
		public void givenListOfSearchWithCelebrityNameNotContain(){

        List<Podcast> list = podcastDaoImp.searchwithcelebrityname(PodcastList,"T");
      //checking the list size which contain search celebrity list size not equals to pass value assertequals
        assertNotEquals(1,list.size());
    }
	
	@Test
   		public void givenListOfSearchWithReleaseDate(){

        List<Podcast> list = podcastDaoImp.searchWithreleaseDate(PodcastList,"2019");
        assertEquals(2,list.size());
    }

	@Test
		public void givenListOfSearchWithReleaseDateNotContain(){

		List<Podcast> list = podcastDaoImp.searchWithreleaseDate(PodcastList,"2012");
		assertNotEquals(1,list.size());
						
	}
	
	  //Search celebrity Test Case
	
		@Test
		public void searchCelebrity() {
			//podcast list contains passing string or not
			assertEquals(True, PodcastList.contains("RuPual"));
			assertEquals(4, PodcastList.size());  //4 denotes the size of podcast list
			assertNotEquals(8, PodcastList.size());
  }

}
