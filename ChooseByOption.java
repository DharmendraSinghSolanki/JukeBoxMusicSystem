package org.example;
import java.util.Scanner;
import java.util.List;

public class ChooseByOption extends MethodLibrary
{
    JDBCConnection jdbc = new JDBCConnection();
    public void getChoices() throws CredentialsExpection {
        Scanner sc = new Scanner(System.in);
        int i = 1;
        int choice = 0;
        while (i == 1) {
            System.out.println("press 1 to Show all songs");
            System.out.println("press 2 to list by by album");
            System.out.println("press 3 to list by by Artist");
            System.out.println("press 4 to list by by Genre");
            System.out.println("press 5 to create playlist");
            System.out.println("press 6 to to add data into a playlist");
            System.out.println("press 7 to show user details");
            System.out.println("press 8 to show playList details ");
            System.out.println("press 9 to show playlist data");
            System.out.println("enter your user id");
            int a = sc.nextInt();
            System.out.println("Enter your choice to select the given tasks");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("All songs details");
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println("Song Id    Song Name            Genre                Artist               Duration");
                    System.out.println("---------------------------------------------------------------------------------------");
                    List<Songs> songs = getAllSongs(jdbc.con);
                    for (Songs e : songs) {
                        System.out.format("%-10s %-20s %-20s %-20s %-20s %n", e.getSong_id(), e.getAlbum_name(), e.getAlbum_genre(),
                                e.getAlbum_artist(), e.getAlbum_duration());
                    }
                    System.out.println("---------------------------------------------------------------------------------------");
                    break;
                }
                case 2: {
                    System.out.println("Enter album  name");
                    String album = sc.next();
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println("Song Id    Song Name            Genre                Artist               Duration");
                    System.out.println("---------------------------------------------------------------------------------------");
                    try {

                        List<Songs> sortNames = showBasedOnAlbum(album, getAllSongs(jdbc.con));
                        for (Songs e : sortNames) {
                            System.out.format("%-10s %-20s %-20s %-20s %-20s %n", e.getSong_id(), e.getAlbum_name(), e.getAlbum_genre(),
                                    e.getAlbum_artist(), e.getAlbum_duration());
                        }
                        System.out.println("---------------------------------------------------------------------------------------");
                        System.out.println("Enter song id");
                        int id = sc.nextInt();
                        String path = showPathBasedOnId(id, jdbc.con);
                        SimpleAudioPlayer.MusicControls(path);
                    } catch (CredentialsExpection e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 3: {
                    System.out.println("Enter artist  name");
                    String artist = sc.next();
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println("Song Id    Song Name            Genre                Artist               Duration");
                    System.out.println("---------------------------------------------------------------------------------------");
                    try {
                        List<Songs> sortNames = showBasedOnArtist(artist, getAllSongs(jdbc.con));
                        for (Songs e : sortNames) {
                            System.out.format("%-10s %-20s %-20s %-20s %-20s %n", e.getSong_id(), e.getAlbum_name(), e.getAlbum_genre(),
                                    e.getAlbum_artist(), e.getAlbum_duration());
                        }
                        System.out.println("---------------------------------------------------------------------------------------");
                        System.out.println("Enter song id");
                        int id = sc.nextInt();
                        String path = showPathBasedOnId(id, jdbc.con);
                        SimpleAudioPlayer.MusicControls(path);
                    } catch (CredentialsExpection e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 4: {
                    System.out.println("Enter genre  name");
                    String genre = sc.next();
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println("Song Id    Song Name            Genre                Artist               Duration");
                    System.out.println("---------------------------------------------------------------------------------------");
                    try {
                        List<Songs> sortNames = showBasedOnGenre(genre, getAllSongs(jdbc.con));
                        for (Songs e : sortNames) {
                            System.out.format("%-10s %-20s %-20s %-20s %-20s %n", e.getSong_id(), e.getAlbum_name(), e.getAlbum_genre(),
                                    e.getAlbum_artist(), e.getAlbum_duration());
                        }
                        System.out.println("---------------------------------------------------------------------------------------");
                        System.out.println("Enter song Id");
                        int id = sc.nextInt();
                        String path = showPathBasedOnId(id, jdbc.con);
                        SimpleAudioPlayer.MusicControls(path);
                    } catch (CredentialsExpection e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 5: {
                    System.out.println("Enter user id");
                    int user_id = sc.nextInt();

                    if (a == user_id) {
                        System.out.println("Enter Play List id");
                        int id = sc.nextInt();
                        System.out.println("Enter play List name");
                        String n = sc.next();
                        System.out.println("Enter playlist Duration");
                        int time = sc.nextInt();
                        CreatePlayList(id, n, user_id, time, jdbc.con);
                    } else {
                        System.out.println("please enter same user id  each time");
                    }

                    break;
                }
                case 6: {
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println(" PL Id    PlayList Name        User_ID             Duration");
                    System.out.println("---------------------------------------------------------------------------------------");
                    showPlayListDetails(a, jdbc.con);
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println();
                    System.out.println();
                    System.out.println("All songs details");
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println("Song Id    Song Name            Genre                Artist               Duration");
                    System.out.println("---------------------------------------------------------------------------------------");
                    List<Songs> songs = getAllSongs(jdbc.con);
                    for (Songs e : songs) {
                        System.out.format("%-10s %-20s %-20s %-20s %-20s %n", e.getSong_id(), e.getAlbum_name(), e.getAlbum_genre(),
                                e.getAlbum_artist(), e.getAlbum_duration());
                    }
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println("Enter playlist id");
                    int pd = sc.nextInt();
                    System.out.println("Enter song id");
                    int sd = sc.nextInt();
                    addPlayerListData(pd, sd, jdbc.con);
                    break;
                }
                case 7: {
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println("User ID   User Name             Phone No.            Email ID             Password ");
                    System.out.println("---------------------------------------------------------------------------------------");
                    showUserDetails(a, jdbc.con);
                    System.out.println("---------------------------------------------------------------------------------------");
                }
                break;
                case 8: {
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println(" PL Id    PlayList Name        User_ID             Duration");
                    System.out.println("---------------------------------------------------------------------------------------");
                    showPlayListDetails(a, jdbc.con);
                    System.out.println("---------------------------------------------------------------------------------------");
                    break;
                }
                case 9: {

                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println(" PL Id    PlayList Name        User_ID             Duration");
                    System.out.println("---------------------------------------------------------------------------------------");
                    showPlayListDetails(a, jdbc.con);
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println("Enter playlist id");
                    int PL_id = sc.nextInt();
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println("Song Id    Song Name            Genre                Artist               Duration");
                    System.out.println("---------------------------------------------------------------------------------------");
                    showPlayerListData(PL_id, jdbc.con);
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println("Enter song id");
                    int id = sc.nextInt();
                    String path = showPathBasedOnId(id, jdbc.con);
                    SimpleAudioPlayer.MusicControls(path);
                }
                break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
            System.out.println("Enter 1 to continue or zero to exit");
            i = sc.nextInt();
            if (i == 0) {
                break;
            }
        }
    }
}
