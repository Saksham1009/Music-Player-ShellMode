
public class Song {
	
	String title;
	double duration;
	private boolean fav;
	
	public Song(String title, double duration) {
		this.title=title;
		this.duration=duration;
		this.fav=false;
	}
	
	public String gettitle() {
		return title;
	}
	public double getduration() {
		return duration;
	}
	
	public String toString() {
		return "Song{"+
				"title='"+ title + '\''+
				", duration=" + duration + '}';
	}
	public boolean checkfav() {
		return fav;
	}
	public void makefav() {
		fav=true;
		System.out.println("This song is a favourite now!");
	}

}
