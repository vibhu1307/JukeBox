package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.sql.*;



import dbconfig.DBConfiguration;
import exception.AlbumEmptyException;
import model.Song;

public class SongDaoImp implements SongDaoI
{

		@Override
		public List<Song> DisplayData(Song song1) {
		    {
				
				//displaying the song
				List<Song> songList = new ArrayList<>();
				try
		        {	//calling Get Connection Function
					Connection con=DBConfiguration.getConnection();
					Statement statement = con.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from Song");

					while (resultSet.next())
					{
						long SongId = resultSet.getLong(1);
						String SongName = resultSet.getString(2);
						String SongDuration = resultSet.getString(3);
						String ArtistName = resultSet.getString(4);
						String GenereName = resultSet.getString(5);
						String AlbumName = resultSet.getString(6);
						String SongPath= resultSet.getString(7);
						Song song = new Song(SongId,SongName,SongDuration,ArtistName,GenereName,AlbumName,SongPath);
						songList.add(song);
					}
				} catch (SQLException throwables)
		        {
					throwables.printStackTrace();


				}
				return songList;
			}
				    
		}
			//searching with starting letter of genre name.
		@Override
		public List<Song> searchwithGenreName(List<Song> sObj, String genreName) {
			// TODO Auto-generated method stub
			return sObj.stream().filter(obj->obj.getGenreName().toLowerCase().startsWith(genreName.toLowerCase())).collect(Collectors.toList());
		}
			
			//searching with starting letter of album name and throwing exception also.
		@Override
		public List<Song> searchWithAlbumName(List<Song> sObj, String albumName) {
			// TODO Auto-generated method stub
			  try {
		            if(sObj.isEmpty())
		            {
		                throw  new AlbumEmptyException("No such Album is present ");
		            }
		        }
		        catch (AlbumEmptyException e)
		        {
		            System.out.println(e);
		        }
			return sObj.stream().filter(obj->obj.getAlbumName().toLowerCase().startsWith(albumName.toLowerCase())).collect(Collectors.toList());
			
		}
		
			//searching with starting letter of artist name
		@Override
		public List<Song> searchWithArtistName(List<Song> sObj, String artistName) {
			// TODO Auto-generated method stub
			return sObj.stream().filter(obj->obj.getArtistName().toLowerCase().startsWith(artistName.toLowerCase())).collect(Collectors.toList());
		}
		
			//searching with song name
		@Override
		public List<Song> searchWithSongName(List<Song> sObj, String songName) {
			// TODO Auto-generated method stub
			return sObj.stream().filter(obj->obj.getSongName().toLowerCase().startsWith(songName.toLowerCase())).collect(Collectors.toList());
			
		}
		
}
