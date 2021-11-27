package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dbconfig.DBConfiguration;
import exception.AlbumEmptyException;
import model.Podcast;
import model.Song;

public class PodcastDaoImp implements PodcastDaoI
{

	@Override
	public List<Podcast> DisplayPodcast(Podcast songp) {
		{
			
			//storing all the data in podcast table
			List<Podcast> podList = new ArrayList<>();
			try
	        {	//calling Get Connection Function
				Connection con=DBConfiguration.getConnection();
				Statement statement = con.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from podcast");

				while (resultSet.next())
				{
					long PodcastId = resultSet.getLong(1);
					String PodcastName = resultSet.getString(2);
					String CelebrityName = resultSet.getString(3);
					String Duration = resultSet.getString(4);
					String ReleaseDate = resultSet.getString(5);
					String PodcastPath = resultSet.getString(6);
					Podcast song2 = new Podcast(PodcastId,PodcastName,CelebrityName,Duration,ReleaseDate,PodcastPath);
					podList.add(song2);
				}
			} catch (SQLException throwables)
	        {
				throwables.printStackTrace();


			}
			return podList;
		}
	}

	@Override
	public List<Podcast> searchwithcelebrityname(List<Podcast> pObj, String celebrityName) {
		// TODO Auto-generated method stub
		return pObj.stream().filter(obj->obj.getCelebrityName().toLowerCase().startsWith(celebrityName.toLowerCase())).collect(Collectors.toList());
	}

	@Override
	public List<Podcast> searchWithreleaseDate(List<Podcast> pObj, String releaseDate) {
		// TODO Auto-generated method stub
		
		try {
            if(pObj.isEmpty())
            {
                throw  new AlbumEmptyException("No such Release Date is present ");
            }
        }
        catch (AlbumEmptyException e)
        {
            System.out.println(e);
        }
		return pObj.stream().filter(obj->obj.getReleaseDate().toLowerCase().startsWith(releaseDate.toLowerCase())).collect(Collectors.toList());

	}

	@Override
	public List<Podcast> searchWithPodcastName(List<Podcast> pObj, String podcastName) {
		// TODO Auto-generated method stub
		return pObj.stream().filter(obj->obj.getPodcastName().toLowerCase().startsWith(podcastName.toLowerCase())).collect(Collectors.toList());

	}
	
}
