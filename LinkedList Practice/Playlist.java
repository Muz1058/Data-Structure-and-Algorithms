class Song{
    String artist;
    String title;
    Song next;
    Song prev;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.next = null;
        this.prev = null;
    }

}

class MusicPlayList{
    Song head;
    Song tail;
    Song currentSong;
    int size;


    public void addSong(String title,String artist){

        Song song=new Song(title,artist);

        if(head==null){
            head=tail=song;
            song.next=song.prev=song;
            currentSong=song;

        }
        else {
            tail.next=song;
            song.prev=tail;

            song.next=head;
            head.prev=song;

            tail=song;
        }
        size++;
    }

    public void remove(String title){
        if (head == null) {
            System.out.println("Playlist is empty. Cannot remove.");
            return;
        }

        Song current=head;
        boolean found=true;

        do{
            if(current.title.equalsIgnoreCase(title)){
                found=true;
                break;
            }
            else {
                current=current.next;
            }
        }while (current!=head);

        if (!found) {
            System.out.println("Song not found: " + title);
            return;
        }


        if(head==tail&&head==current){
            current=head=tail=null;
        }
        else if (current==currentSong) {
            if(currentSong.next!=null){
                currentSong=currentSong.next;
            }
            current=null;

        }
        else if(current==head){

            head=head.next;
            tail.next=head;
            head.prev=tail;

        }
        else if(current==tail){
            tail=tail.prev;
            tail.next=head;
            head.prev=tail;
        }
        else {
            current.prev.next=current.next;
            current.next.prev=current.prev;
        }
        size--;
        System.out.println("Removed: " + title);

    }
    public void playNext(){
        if (currentSong == null) {
            System.out.println("No song is currently playing.");
            return;
        }
        currentSong = currentSong.next;
        System.out.println("Now playing: " + currentSong.title + " by " + currentSong.artist);
    }
    public void playPrevious(){
        if (currentSong == null) {
            System.out.println("No song is currently playing.");
            return;
        }
        currentSong = currentSong.prev;
        System.out.println("Now playing: " + currentSong.title + " by " + currentSong.artist);
    }

    public void display(){
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        Song current =head;
        do {
            System.out.println(current.title + " by " + current.artist);
            current = current.next;
        } while (current != head);
    }

}
public class Playlist {
    public static void main(String[] args) {
        MusicPlayList playlist = new MusicPlayList();

        playlist.addSong("Shape of You", "Ed Sheeran");
        playlist.addSong("Blinding Lights", "The Weeknd");
        playlist.addSong("Levitating", "Dua Lipa");
        playlist.display();
        

        playlist.display();
        System.out.println("----");


        playlist.playNext();      
        playlist.playPrevious(); 
        System.out.println("---- Removing a song ----");
        playlist.remove("Shape of You");
        playlist.display();

    }
}