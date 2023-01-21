import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSong() {
        return songs;
    }

    public void setSong(List<Song> song) {
        this.songs = song;
    }



    public boolean findSong(String title){
        for(Song s:songs){
            if(s.getTitle().equals(title)){
                return true;
             }
        }
         return false;
    }



    public void addSongtoAlbum(String title,double duration){
        Song s = new Song(title,duration);
        if(findSong(s.getTitle())==true){
            System.out.println("Song already present in album");
        }else{
            songs.add(s);
            System.out.println("new song add");
        }
    }

         // POLYMORPHISIM

         public void addToPlaylistFromAlbum(String title, LinkedList<Song>playList){
                           if(findSong(title)==true){
                               for(Song song:songs){
                                   if(song.getTitle().equals(title)){
                                     playList.add(song);
                                       System.out.println("Song add to your plylist");
                                     break;
                                   }
                               }

                           }else{
                               System.out.println("Song not prsent in album");
                           }
    }
       public void addToPlaylistFromAlbum(int trackNo,LinkedList<Song>playList){

        int index=trackNo-1;
        if(index>=0 && index<songs.size()){
            playList.add(songs.get(index));
            System.out.println("Song add to your plylist");


        }else{
            System.out.println("Invalid track No");
        }
       }
}
