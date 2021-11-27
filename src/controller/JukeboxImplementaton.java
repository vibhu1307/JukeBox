package controller;

import dao.PlayListDaoI;
import dao.PlayListDaoImpI;
import dao.PodcastDaoImp;
import dao.SongDaoImp;
import exception.AlbumEmptyException;
import exception.DateEmptyException;
import model.PlayList;
import model.Podcast;
import model.Song;
import music.MusicPlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;



public class JukeboxImplementaton {

	public static void main(String[] args) throws IOException 
	{
		Scanner sc=new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("________________________ WELCOME TO JUKEBOX _________________________");
		
		Song song1=new Song();								    //model class object creation for what to set the value.
		SongDaoImp songImp1=new SongDaoImp(); 		    		//creating a song dao imp class object.
		List<Song> sObj=songImp1.DisplayData(song1);			    //storing data into sObj.
		
		Podcast podcast1=new Podcast();                         //model class object creation for what to set the value.
		PodcastDaoImp podImp1=new PodcastDaoImp();				//creating a Podcast dao imp class object.
		List<Podcast> pObj=podImp1.DisplayPodcast(podcast1);         //storing data into pObj.
		
		PlayList playList = new PlayList();						//model class object for what to set the value.
		PlayListDaoImpI playListImpl = new PlayListDaoImpI();	//creating a PlayList dao imp class object.
		
		int userchoice = 0;										//taking variable
		int choice = 0;											//taking variable
		String choices ;
		do {													//using do 
		System.out.println();
		System.out.println(" Do You want to search a Song or Podcast ? \n");
		System.out.println("~ For Searching Song Press    -  1 ");
		System.out.println("~ For Searching Podcast Press -  2 ");
		System.out.println("~ For creating playlist press -  3 ");
		System.out.println("~ For search playlist press   -  4 ");
		System.out.println("~ For play music press        -  5 ");
		
		userchoice = sc.nextInt();	
		
		//song (task 1)
		switch(userchoice)
		{
			case 1:
				//displaying the table
		System.out.println("_______________________________________________________________________________________________________________________\n");
		System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n","SongId","SongName","SongDuration","ArtistName","GenreName","AlbumName");
		System.out.println("_______________________________________________________________________________________________________________________");
		sObj.forEach(c->System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s \n",c.getSongID(),c.getSongName(),c.getSongDuration(),c.getArtistName(),c.getGenreName(),c.getAlbumName()));
		System.out.println("_______________________________________________________________________________________________________________________\n");
		
		System.out.println("* List of Options available for user to search a song *- \n ");
		System.out.println("<1>- Search By Genre ");
		System.out.println();
		System.out.println("<2>- Search By Album ");
		System.out.println();
		System.out.println("<3>- Search By Artist ");
		System.out.println();
		System.out.println("  Select any one option!! ");
		choice = sc.nextInt();
		
		
		switch (choice) {
			
			// Based on the choice of user Search operation For Songs  is performed
			case 1: 
		{                           //displaying by Genre name 
		System.out.println();
		System.out.println(" Enter Genre Name based on the Song table shown: ");
		String genreName=sc.next();
		List<Song> genreObj=songImp1.searchwithGenreName(sObj,genreName);					//sobj-contain all songlist data .
			try {
            if (genreObj.isEmpty()) {
                throw new AlbumEmptyException("No Genre Name in the list based on your search");
            }
            else
            {
            	System.out.println("_______________________________________________________________________________________________________________________");
        		System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n","SongId","SongName","SongDuration","ArtistName","GenreName","AlbumName");
        		System.out.println("_______________________________________________________________________________________________________________________");
        		genreObj.forEach(c->System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s \n",c.getSongID(),c.getSongName(),c.getSongDuration(),c.getArtistName(),c.getGenreName(),c.getAlbumName()));
        	   }
            
        } catch (AlbumEmptyException e) {
            System.out.println(e);
        }
			break;
		}
		
			case 2: 
		{						 //displaying by Album name 
		System.out.println();
		System.out.println(" Enter Album Name based on the Song table shown: ");
		String albumName=sc.next();
		List<Song> albumObj=songImp1.searchWithAlbumName(sObj,albumName);
		try {																	//exception
            if (albumObj.isEmpty()) {
                throw new AlbumEmptyException("No Album Name in the list based on your search");
            }
            else
            {
            	System.out.println("_______________________________________________________________________________________________________________________");
        		System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n","SongId","SongName","SongDuration","ArtistName","GenreName","AlbumName");
        		System.out.println("_______________________________________________________________________________________________________________________");
        		albumObj.forEach(c->System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s \n",c.getSongID(),c.getSongName(),c.getSongDuration(),c.getArtistName(),c.getGenreName(),c.getAlbumName()));
            }
            
        } catch (AlbumEmptyException e) {
            System.out.println(e);
        }
			break;
		}
			
			case 3:
		{						//displaying by Artist name 
		System.out.println();
		System.out.println(" Enter Artist Name based on the Song table shown: ");
		String artistName=sc.next();
		List<Song> artistObj=songImp1.searchWithArtistName(sObj,artistName);            //sobj-contain all songlist data .
		System.out.println("_______________________________________________________________________________________________________________________");
		System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n","SongId","SongName","SongDuration","ArtistName","GenreName","AlbumName");
		System.out.println("_______________________________________________________________________________________________________________________");
		artistObj.forEach(c->System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s \n",c.getSongID(),c.getSongName(),c.getSongDuration(),c.getArtistName(),c.getGenreName(),c.getAlbumName()));
		break;
		}
			
			default:
				System.out.println("wrong choice");
		}
                    
				
		
		break;
		
		//podcast (task 2)
			case 2:
									//displaying the podcast
				System.out.println("___________________________________________________________________________________________________");
				System.out.format("%-20s %-25s %-20s %-20s %-20s \n","PodcastId","PodcastName","CelebrityName","SongDuration","ReleaseDate");
				System.out.println("___________________________________________________________________________________________________");
				pObj.forEach(c->System.out.format("%-20s %-25s %-20s %-20s %-20s \n",c.getPodcastId(),c.getPodcastName(),c.getCelebrityName(),c.getDuration(),c.getReleaseDate()));
				System.out.println("___________________________________________________________________________________________________");
				System.out.println();
				System.out.println("List of Options available for user to search a PodCast- \n");
				System.out.println("1 Search By Celebrity Name: ");
				System.out.println();
				System.out.println("2 Search By Release Date in format (YY-MM-DD): ");
				System.out.println();
				System.out.println(" Select any one option!! ");
				int option=sc.nextInt();	
			
			switch(option)
			{
			case 1:{					//displaying by celebrity name
				System.out.println();
				System.out.println(" Enter the Celebrity name: ");
				String celebrityName=sc.next();
				List<Podcast> celebrityObj=podImp1.searchwithcelebrityname(pObj, celebrityName);
				System.out.println("___________________________________________________________________________________________________");
				System.out.format("%-20s %-25s %-20s %-20s %-20s  \n","PodcastId","PodcastName","CelebrityName","SongDuration","ReleaseDate");
				System.out.println("___________________________________________________________________________________________________");
				celebrityObj.forEach(c->System.out.format("%-20s %-25s %-20s %-20s %-20s \n",c.getPodcastId(),c.getPodcastName(),c.getCelebrityName(),c.getDuration(),c.getReleaseDate()));	
				break;
				
			}
			case 2:
			{							//displaying by release date
				System.out.println();
				System.out.println(" Enter the Release Date: ");
				String releaseDate=sc.next();
				List<Podcast> dateObj=podImp1.searchWithreleaseDate(pObj,releaseDate);
				try {
                    if (dateObj.isEmpty()) {
                        throw new DateEmptyException("No Release date in the list based on your search");
                    }
                    
                    else {
                    	System.out.println("___________________________________________________________________________________________________");
        				System.out.format("%-20s %-25s %-20s %-20s %-20s \n","PodcastId","PodcastName","CelebrityName","Duration","ReleaseDate");
        				System.out.println("___________________________________________________________________________________________________");
        				dateObj.forEach(c->System.out.format("%-20s %-25s %-20s %-20s %-20s \n",c.getPodcastId(),c.getPodcastName(),c.getCelebrityName(),c.getDuration(),c.getReleaseDate())); 	
                    }
                } catch (DateEmptyException e)
				{
                    System.out.println(e);
                }
				
			}
				
			}
			break;
			
			//playlist (task 3)
			case 3:
				
			{	//displaying all the songs
				System.out.println("--------------------------------------------- Displaying available songs --------------------------------------------\n");
				
				System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s\n","SongId","SongName","SongDuration","ArtistName","GenreName","AlbumName");
				sObj.forEach(c->System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s \n",c.getSongID(),c.getSongName(),c.getSongDuration(),c.getArtistName(),c.getGenreName(),c.getAlbumName()));
				
				//displaying all the podcasts
				System.out.println("\n-------------------------------------------- Displaying available Podcasts -------------------------------------------\n");
				
				System.out.format("%-20s %-25s %-20s %-20s %-20s \n","PodcastId","PodcastName","CelebrityName","SongDuration","Duration","ReleaseDate");
				pObj.forEach(p->System.out.format("%-20s %-25s %-20s %-20s %-20s \n",p.getPodcastId(),p.getPodcastName(),p.getCelebrityName(),p.getDuration(),p.getReleaseDate()));
							
				
				
				
				System.out.println("\n How do you want to create a playlist ? \n");
				System.out.println("1. Create playlist for Song !!");
				System.out.println("2. Create playlist for Podcast !!");
				System.out.println("3. With Combination of Both !!");
				int option2 = sc.nextInt();
				
				
				switch(option2)
				{
				 		//adding songs playlist
				case 1:
					System.out.println(" Enter the name of playlist ");
					String nameOfPlaylist = br.readLine();
					System.out.println(" Enter the number of songs to be added: ");

					int noOfsongs = sc.nextInt();
				
					for (int i = 0; i < noOfsongs; i++) {
						System.out.println(" Please enter song id: ");
						long songid = sc.nextLong();
						for (Song songs : sObj) {
						if (songid == songs.getSongID()) {
						System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s \n","Song ID", "Song Name", "Duration", "Artist Name", "Genre Name", "Album Name");
						System.out.format("%-20s %-25s %-20s %-20s %-20s %-20s \n",songs.getSongID(),songs.getSongName(),songs.getSongDuration(),songs.getArtistName(),songs.getGenreName(), songs.getAlbumName());
						playList.setPlayListName(nameOfPlaylist);
						playList.setSongName(songs.getSongName());
						playList.setSongID(songid);
						PlayListDaoI playList1 = new PlayListDaoImpI();
						playList1.addSong(playList);
								
							}
						}
					}
					System.out.println("Successfully Added...");
					break;
					
				case 2:
				{
					// for adding podcast playlist
					
					System.out.println(" Enter the name of playlist ");
					String nameOfPlaylist1 = br.readLine();
					System.out.println(" Enter the number of podcast to be added: ");

					int noOfpodcasts = sc.nextInt();

				
					for (int i = 0; i < noOfpodcasts; i++) {
						System.out.println(" Please enter podcast id- ");
						long podcastid = sc.nextLong();
						for (Podcast podcast : pObj) {
						if (podcastid == podcast.getPodcastId() ){
						System.out.format("%-20s %-25s %-20s %-20s %-20s \n","PodcastId","PodcastName","CelebrityName","Duration", "ReleaseDate");
						System.out.format("%-20s %-25s %-20s %-20s %-20s \n",podcast.getPodcastId(),podcast.getPodcastName(),podcast.getCelebrityName(),podcast.getDuration(),podcast.getReleaseDate());
						playList.setPlayListName(nameOfPlaylist1);
						playList.setPodcastName(podcast.getPodcastName());
						playList.setPodcastId(podcastid);
						PlayListDaoI playList1 = new PlayListDaoImpI();
						playList1.addPodcast(playList);
								
							}
						}
					}
					System.out.println("Successfully Added...");
				}
				break;
				
				case 3:
					
						//here adding combination of both songs & podcasts playlist
					
						System.out.println(" Enter the name of playlist  ");
						String nameOfPlaylist2 = br.readLine();
						System.out.println(" enter the number of podcast & songs to be added ");

						int number = sc.nextInt();
						for(int i=0;i<number;i++)
						{
							System.out.println(" Enter the song id- ");
						
						long id=sc.nextLong();
						for(Song songs:sObj)
						{
							if(id==songs.getSongID())
							{
								playList.setPlayListName(nameOfPlaylist2);
								playList.setSongName(songs.getSongName());
								playList.setSongID(id);
							}
						
						}
				
				
						System.out.println(" Enter podcast Id- ");
						long podcastId = sc.nextLong();
						for(Podcast podcast:pObj)
						{
							if(podcastId==podcast.getPodcastId())
							{
						playList.setPodcastName(podcast.getPodcastName());
						playList.setPodcastId(podcastId);
							}
						}
		
						
						PlayListDaoI playList1 = new PlayListDaoImpI();
						playList1.addBothCombination(playList);
					}	
				}
			}
			System.out.println("Successfully Added...");
			break;
			
			
			case 4:
			{		//displaying the playlist
				System.out.println("--------------------------- Displaying the available PlayLists ---------------------------\n");
				playListImpl.displayPlayList();	
				System.out.println(" \n Enter the playlist name that you want to search! ");
				String playlist_name=br.readLine();
				playList.setPlayListName(playlist_name);
				PlayListDaoI playList1 = new PlayListDaoImpI();
				playList1.searchPlayList(playList);
				
				 
				break;
			}
			
			//for display and playing music 
			
			case 5:
			{
				System.out.println("\n-------------------------Displaying the available Playlist-------------------------------\n");
				playListImpl.displayPlayList();
				
				String ans="";
				
				do {
					System.out.println(" \n ~ Enter the song name and podcast name: ");
					String songName=br.readLine();
					String path="";
					List<Song> songPlaylist=songImp1.searchWithSongName(sObj, songName);
					
					List<Podcast> podcastPlaylist=podImp1.searchWithPodcastName(pObj,songName);
					
					if(songPlaylist.isEmpty())
					{
						path=podcastPlaylist.get(0).getPodcastPath();
					}
					else
					{
						path=songPlaylist.get(0).getSongPath();
					}
					
					if(path!=null)
					{
						MusicPlayer mObj=new MusicPlayer();
						mObj.playMusic(path);
					}
				} while(ans.equalsIgnoreCase("y"));
				
				System.out.println();

                break;
			}
				
				default:
					System.out.println("wrong choice");
					break;
			}
		
				System.out.println();
                    System.out.println("Do you want to continue with jukebox: y/n");
                    choices = sc.next();

			} 	while (choices.equals("y"));
		
			
		}
	

}
