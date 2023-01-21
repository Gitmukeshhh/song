import java.security.spec.RSAOtherPrimeInfo;
import java.util.AbstractList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album album1=new Album("MOOSA","sidhu Moosewala");
        album1.addSongtoAlbum("295",4.05);
        album1.addSongtoAlbum("LastRide",5.5);
        album1.addSongtoAlbum("So high",3.05);

        Album  album2=new Album("Arijit Song","Arjit Sing");
        album2.addSongtoAlbum("Kesariya",5);
        album2.addSongtoAlbum("Jeena Jeena",4.6);
        album2.addSongtoAlbum("Gerua",6);


        System.out.println(album1.findSong("Gerua"));


        LinkedList<Song> myPlayList=new LinkedList<>();
        album1.addToPlaylistFromAlbum("295",myPlayList);
        album2.addToPlaylistFromAlbum(2,myPlayList);
        album1.addToPlaylistFromAlbum("LastRide",myPlayList);
        album2.addToPlaylistFromAlbum("Jeena Jeena",myPlayList);



        play(myPlayList);


    }
     public  static void play(LinkedList<Song> playList){

       ListIterator<Song> itr= playList.listIterator();
       Scanner scan=new Scanner(System.in);
       boolean isForwared=false;


       if(playList.size()>0){
           System.out.println("Currently plying : ");
           System.out.println(itr.next());
           isForwared=true;

       }else{
           System.out.println("plylist empty");
           return ;
       }

         System.out.println("Enter your choice");
          printMenu();
          boolean quit =false;
          while(quit!=true){

              int choice=scan.nextInt();
              switch (choice){
                  case 1:
                        if(isForwared==false){
                            itr.next();
                            isForwared=true;

                        }
                       if(itr.hasNext()){
                           System.out.println(itr.next());

                       }else{
                           System.out.println("you have reach end of the plylist");
                           isForwared=false;
                       }
                      break;
                  case 2:
                       if(isForwared==true){
                           itr.previous();
                           isForwared=false;
                       }
                       if(itr.hasPrevious()){
                           System.out.println(itr.previous());
                       }else{
                           System.out.println("you are at start of plylist");
                           isForwared=true;
                       }
                      break;
                  case 3:
                      if( isForwared==true){
                          if(itr.hasPrevious()) {
                              System.out.println(itr.previous());
                              isForwared=false;
                          }else{
                              System.out.println("song does not exist");
                          }
                      }else{
                          if(itr.hasNext()) {
                              System.out.println(itr.next());
                              isForwared=true;
                          }else{
                              System.out.println("song does not exist");
                          }
                      }

                      break;
                  case 4:
                      printMenu();
                      break;
                  case 5:
                      break;
                  case 6:
                      printSong(playList);
                      break;

                  case 7:
                        quit=true;
                       break;
              }


          }

     }



     public  static void printSong(LinkedList<Song>playList){

         for(Song song:playList) {
             System.out.println(song);
         }
     }
     public  static  void printMenu(){

         System.out.println("1->play next Song");
         System.out.println("2->play privoues song");
         System.out.println("3->Repeate the current song");
         System.out.println("4->show menu again");
         System.out.println("5->delete current song");
         System.out.println("6->print all song in plylist");
         System.out.println("7->Exit");
    }
}