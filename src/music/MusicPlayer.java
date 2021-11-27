package music;

	import java.io.File;
	import java.util.Scanner;

	import javax.sound.sampled.AudioInputStream;
	import javax.sound.sampled.AudioSystem;
	import javax.sound.sampled.Clip;

	public class MusicPlayer
	{
		//task 4
		public void playMusic(String musicLocation)
		{     
			
			Scanner sc = new Scanner(System.in);
			try
			{
				File musicPath = new File(musicLocation);
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip=AudioSystem.getClip();
				clip.open(audioInput);
				String response = "";    
				while(!response.equals("Q"))    //while loop for checking 
				{
					System.out.println(" P = play,      R = reset,      S = stop,     Q = quit,    N=nextsong");
					System.out.println(" \n Enter your choice: ");
					response = sc.next();
					response = response.toUpperCase();
						
						switch(response)		//switch case
						{
						case("P"):
							clip.start();
							break;		
							
						case("R"):
							clip.setMicrosecondPosition(0);
							break;
							
						case("S"):
							clip.stop();
							break;		
						
						case("Q"):
							clip.close();
							break;
							
						case("N"):
							clip.stop();
							break;
						
						default:
							System.out.println("Not a valid response");
							
						}
					}
					

					System.out.println("Thank you for using jokebox :)");
					
				}
			
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}

