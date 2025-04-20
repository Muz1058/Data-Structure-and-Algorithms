class Song {
    String title;
    String artist;
    Song next;
    Song prev;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return title + " by " + artist;
    }
}

class MusicPlaylist {
    private Song currentSong;
    private int size;

    public MusicPlaylist() {
        this.currentSong = null;
        this.size = 0;
    }

    public void addSong(String title, String artist) {
        Song newSong = new Song(title, artist);

        if (currentSong == null) {
            currentSong = newSong;

            newSong.next = newSong;
            newSong.prev = newSong;
        }
        else {

            newSong.next = currentSong.next;
            newSong.prev = currentSong;
            currentSong.next.prev = newSong;
            currentSong.next = newSong;

            currentSong = newSong;
        }
        size++;
        System.out.println("Added: " + title + " by " + artist);
    }

    public Song playNext() {
        if (currentSong == null) {
            System.out.println("Playlist is empty");
            return null;
        }

        currentSong = currentSong.next;
        System.out.println("Now playing: " + currentSong);
        return currentSong;
    }


    public Song playPrevious() {
        if (currentSong == null) {
            System.out.println("Playlist is empty");
            return null;
        }

        currentSong = currentSong.prev;
        System.out.println("Now playing: " + currentSong);
        return currentSong;
    }

    public void removeSong() {
        if (currentSong == null) {
            System.out.println("Playlist is empty");
            return;
        }

        System.out.println("Removing: " + currentSong);

        if (currentSong.next == currentSong) {
            currentSong = null;
        } else {
            Song nextSong = currentSong.next;
            currentSong.prev.next = currentSong.next;
            currentSong.next.prev = currentSong.prev;
            currentSong = nextSong;
        }
        size--;
    }

    // Display the current playlist
    public void displayPlaylist() {
        if (currentSong == null) {
            System.out.println("Playlist is empty");
            return;
        }

        System.out.println("\nCurrent Playlist:");
        System.out.println("=================");

        Song temp = currentSong;
        int count = 0;

        do {
            String currentMarker = (temp == currentSong) ? " ► " : "   ";
            System.out.println(currentMarker + (count + 1) + ". " + temp);
            temp = temp.next;
            count++;
        } while (temp != currentSong);

        System.out.println("=================");
    }


    public int getSize() {
        return size;
    }


    public Song getCurrentSong() {
        return currentSong;
    }
}

public class Playlist {
    public static void main(String[] args) {
        MusicPlaylist playlist = new MusicPlaylist();


        playlist.addSong("Afreen Afreen", "Nusrat Fateh Ali Khan");
        playlist.addSong("Tajdar-e-Haram", "Sabri Brothers");
        playlist.addSong("Dil Dil Pakistan", "Vital Signs");
        playlist.addSong("Sajni", "Strings");



        playlist.displayPlaylist();


        playlist.playNext();
        playlist.playNext();


        playlist.displayPlaylist();

        playlist.removeSong();


        playlist.displayPlaylist();


        playlist.playPrevious();
        playlist.displayPlaylist();
    }
}