package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbconfig.DBConfiguration;
import model.PlayList;

public class PlayListDaoImpI implements PlayListDaoI
{
	
	
	@Override
	public void displayPlayList() {
		// TODO Auto-generated method stub
		try
		{
			
			Connection con = DBConfiguration.getConnection();
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("select * from playlist");
			
			System.out.format("%-20s %-20s %-20s %-20s %-20s\n","Playlist_name","SongName","Song ID","Podcast Name","Podcast ID");
			while (rs.next())
			{
				System.out.format("%-20s %-20s %-20s %-20s %-20s\n",rs.getString(1),rs.getString(2),rs.getLong(3),rs.getString(4),rs.getLong(5));
				
			}
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
	}

	@Override
	public void addSong(PlayList playlist) {
		// TODO Auto-generated method stub
		try 
		{
			//calling getConnection function 
			Connection con = DBConfiguration.getConnection();
			
			//to execute parameterized query
			PreparedStatement pst = con.prepareStatement("insert into PlayList(playListName, songName, songID)values (?,?,?)");
			
			
			pst.setString(1, playlist.getPlayListName());
			pst.setString(2, playlist.getSongName());
			pst.setLong(3, playlist.getSongID());
			//pst.setString(4, playlist.getalbumName());
			
			pst.executeUpdate();
			
		}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
	}
		

	@Override
	public void addPodcast(PlayList playlist) {
		// TODO Auto-generated method stub
		try 
		{
			//calling getConnection function 
			Connection con = DBConfiguration.getConnection();
			
			//to execute parameterized query
			PreparedStatement pst = con.prepareStatement("insert into PlayList(playListName, podcastName, podcastId)values (?,?,?)");
			
			
			pst.setString(1, playlist.getPlayListName());
			pst.setString(2, playlist.getPodcastName());
			pst.setLong(3, playlist.getPodcastId());
			
			
			pst.executeUpdate();
			
		}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
	}

	
	@Override
	public void addBothCombination(PlayList playlist)
	{
		try 
		{
			//calling getConnection function 
			Connection con = DBConfiguration.getConnection();
			
			//to execute parameterized query
			PreparedStatement pst = con.prepareStatement("insert into playList(playListName,songName,songID,podcastName,podcastId)values (?,(select songName from song where songID=?),?,(select podcastName from podcast where podcastId=?),?)");			
			
			pst.setString(1, playlist.getPlayListName());
			pst.setLong(2, playlist.getSongID());
			pst.setLong(3, playlist.getSongID());
			pst.setLong(4, playlist.getPodcastId());
			pst.setLong(5, playlist.getPodcastId());
			
			
			pst.executeUpdate();
			
		}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
		
	}
	

	@Override
	public void searchPlayList(PlayList playlist) {
		// TODO Auto-generated method stub
		try {
		Connection con = DBConfiguration.getConnection();
		
		//to execute parameterized query
		// it will improve the performance because query is compiled only once
		PreparedStatement pst = con.prepareStatement("select * from playlist where playListName = ?");
		
		pst.setString(1, playlist.getPlayListName());
		ResultSet rs = pst.executeQuery();
		System.out.format("%-20s %-20s %-20s %-40s %-20s \n","Playlist_name","SongName","Song ID","PodcastName","Podcast ID");
		while (rs.next())
		{
			System.out.format("%-20s %-20s %-20s %-40s %-20s \n",rs.getString(1),rs.getString(2),rs.getLong(3),rs.getString(4),rs.getLong(5));
			
		}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
		
}

