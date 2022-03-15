
import java.util.*;

public class Album {
	
	private String title;
	private String artist;
	private ArrayList<Song> album;
	
	public Album(String title, String artist) {
		this.title=title;
		this.artist=artist;
		this.album = new ArrayList<Song>();
	}
	
	public Song checkifexists(String title) {
		for(Song a: album) {
			if(a.gettitle().equals(title)) return a;
		}
		return null;
	}
	
	public boolean Addsong(String title, double duration) {
		if(checkifexists(title)==null) {
			album.add(new Song(title, duration));
			System.out.println(title + " successfully added to the album!");
			return true;
		}
		System.out.println(title+" already exists in the album!");
		return false;
	}
	
	public boolean addtoplaylist(int trackNumber, LinkedList<Song> playlist) {
		int index = trackNumber-1;
		if(index>0 && index<=album.size()) {
			playlist.add(album.get(index));
			return true;
		}
		System.out.println("This album does not have a track with tracknumber:"+trackNumber);
		return false;
	}
	public boolean addtoplaylist(String title, LinkedList<Song> playlist) {
		if(checkifexists(title)!=null) {
			playlist.add(checkifexists(title));
			System.out.println(title + " succesfully added to the playlist!");
			return true;
		}
		System.out.println("This album does not have a track with title : "+title);
		return false;
		// for(Song a: this.album) {
		// 	if(a.gettitle().equals(title)) {
		// 		playlist.add(a);
		// 		return true;
		// 	}
		// }
		// System.out.println(title+" there is no such song in album");
		// return false;
		
	
	}
	

}
