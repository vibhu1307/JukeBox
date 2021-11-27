package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import dao.SongDaoImp;
import model.Song;

class SongTest {
	
	 private List <Song> SongList;
	 private SongDaoImp songDaoImp;
	 private Song song;

	@BeforeEach
	void setUp() throws Exception 
	{
		songDaoImp=new SongDaoImp();
		song=new Song(100,"Love me like you do","30:20:30","Taylor Swift","Love Song","Love","E:\\wave12jdbc\\jukebox\\src\\resources\\sample1.wav");
		SongList = List.of(
				song,
                new Song(101,"Do not lie","10:20:10","Akon","Rapper","Fast","E:\\wave12jdbc\\jukebox\\src\\resources\\sample2.wav"),
                new Song(102,"Here i came","00:20:10","Pit Bull","Folk","Fist","E:\\wave12jdbc\\jukebox\\src\\resources\\sample3.wav"),
                new Song(103,"Get Lost","00:20:10","Eminem","Pop","Little","E:\\wave12jdbc\\jukebox\\src\\resources\\sample4.wav"));
              
	}

	@AfterEach
	void tearDown() throws Exception {
		songDaoImp=null;
	}
	
	
	@Test
	 public void givenListOfSearchWithGenreName(){

        List list = songDaoImp.searchwithGenreName(SongList,"pop");
        assertEquals(1,list.size());
    }

	@Test
		public void givenListOfSearchWithGenreNameNotContain(){

		List list = songDaoImp.searchwithGenreName(SongList,"Jazz");
    	assertNotEquals(1,list.size());
	}
	
	//====================================================================
	
	@Test
	 public void givenListOfSearchWithAlbumName(){

       List list = songDaoImp.searchWithAlbumName(SongList,"Love");
       assertEquals(1,list.size());
   }

	@Test
		public void givenListOfSearchWithAlbumNameNotContain(){

		List list = songDaoImp.searchWithAlbumName(SongList,"Memories");
		assertNotEquals(1,list.size());
	}
	
	//====================================================================
	
	@Test
	 public void givenListOfSearchWithArtistName(){

       List list = songDaoImp.searchWithArtistName(SongList,"Akon");
       assertEquals(1,list.size());
   }

	@Test
		public void givenListOfSearchWithArtistNameNotContain(){

		List list = songDaoImp.searchWithArtistName(SongList,"Enrique");
		assertNotEquals(1,list.size());
	}

}
