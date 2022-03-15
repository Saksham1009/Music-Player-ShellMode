import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		ArrayList<Album> albums = new ArrayList<Album>();
		
		Album btfu = new Album("BTFU!","Karan Aujla");
		
		btfu.Addsong("Sharab", 3.24);
		btfu.Addsong("Here&There", 3.14);
		btfu.Addsong("Ask About me", 4.20);
		btfu.Addsong("It Ain't Legal", 3.00);
		albums.add(btfu);
		
		Album clb = new Album("Certified Lover Boy","Drake");
		
		clb.Addsong("Fair Trade",4.51);
		clb.Addsong("No Friends in the Industry", 4.41);
		clb.Addsong("Knife Talk", 4.04);
		clb.Addsong("Girls want Girls", 3.43);
		albums.add(clb);
		
		LinkedList<Song> playlist1 = new LinkedList<>();
		albums.get(0).addtoplaylist("Sharab", playlist1);
		albums.get(1).addtoplaylist("Fair Trade",playlist1);
		
		play(playlist1);

	}
	private static void play(LinkedList<Song> playlist) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playlist.listIterator();
		// ArrayList<Song> favourite = new ArrayList<>();
		if(playlist.size()==0) {
			System.out.println("This playlist has no songs!");
		}else {
			System.out.println("Now playing : "+listIterator.next().toString());
			menu();
		}
		
		while(!quit) {
			int action = sc.nextInt();
			sc.nextLine();
			
			switch(action) {
				case 0:
					System.out.println("Playlist complete!");
					quit=true;
					break;
				case 1:
					if(!forward) {
						if(listIterator.hasNext()) listIterator.next();
						forward= true;
					}
					if(listIterator.hasNext()) {
						System.out.println("Now Playing : "+listIterator.next().toString());
					}else {
						System.out.println("No song available! reached the end of the list");
						forward=false;
					}
					break;
				case 2:
					if(forward) {
						if(listIterator.hasPrevious()) {
							listIterator.previous();
						}
						forward = false;
					}
					if(listIterator.hasPrevious()) {
						System.out.println("Now playing : "+listIterator.previous().toString());
					}else {
						System.out.println("We are the first song");
						forward = false;
					}
					break;		
			
				case 3:
					if(forward) {
						if(listIterator.hasPrevious()) {
							System.out.println("Now Playing : "+listIterator.previous().toString());
							forward=false;
						}else {
							System.out.println("We are at the start of the song!");
						}
					}else {
						if(listIterator.hasNext()) {
							System.out.println("Now Playing : "+listIterator.next().toString());
							forward= true;
						}else {
							System.out.println("We have reached at the end of our list!");
						}
					}
					break;
				case 4:
					printlist(playlist);
					break;
				case 5:
					menu();
					break;
				case 6:
					if(playlist.size()>0) {
						listIterator.remove();
						if(listIterator.hasNext()) {
							System.out.println("Now Playing : "+listIterator.next().toString());
							forward = true;
							break;
						}
						else {
							if(listIterator.hasPrevious())
							System.out.println("Now Plying : "+listIterator.previous().toString());
							break;
						}
					}
				
				// case 7:
				// 	System.out.println(listIterator.next());
				// 	listIterator.next();
				// 	listIterator.previous();
				// 	System.out.println(listIterator.previous());
					
				// 	if(listIterator.previous().checkfav()) {
				// 		listIterator.previous().makefav();
				// 		favourite.add(listIterator.previous());
				// 	}
				// 	listIterator.previous();
				// 	break;
//				case 8:
//					for(Song a: favourite){
//						System.out.println(a);
//					}
//					break;
			}		
				
		}
	}
	private static void menu() {
		System.out.println("----------Welcome to music Player!----------");
		System.out.println("--------------Select one option--------------");
		System.out.println("0 - Quit\n"+
					"1 - Play next song\n"+
					"2 - Play previous song\n"+
					"3 - Replay the current song\n"+
					"4 - List of all songs in the album\n"+
					"5 - Print all the available options\n"+
					"6 - Delete the current song\n");
	}
	
	private static void printlist(LinkedList<Song> playlist) {
		Iterator<Song> iterator = playlist.iterator();
		System.out.println("---------------------");
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("---------------------");
	}
}
