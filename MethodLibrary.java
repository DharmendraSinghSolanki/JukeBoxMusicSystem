package org.example;



import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MethodLibrary {
    public List<Songs> getAllSongs(Connection con) {
        List<Songs> songsList = new ArrayList<>();
        try {
            String sql = "select * from songsList";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Songs songDetails = new Songs();
                songDetails.setSong_id(resultSet.getInt(1));
                songDetails.setAlbum_name(resultSet.getString(2));
                songDetails.setAlbum_genre(resultSet.getString(3));
                songDetails.setAlbum_artist(resultSet.getString(4));
                songDetails.setAlbum_duration(resultSet.getString(5));
               // songDetails.setAlbum_path(resultSet.getString(6));
                songsList.add(songDetails);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return songsList;
    }

    String showPathBasedOnId(int id, Connection con) {
        String path = null;
        try {
            boolean flag = false;
            String sql = "select * from songsList where song_id =?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                flag = true;
                path = resultSet.getString(6);
            }
            if (flag == false) {
                System.out.println("no data found for " + id);
            }
            return path;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return path;

        }

    }

    public List<Songs> showBasedOnAlbum(String album,List<Songs>songs) throws  CredentialsExpection {
        Comparator<Songs> comparator=(o1, o2)->
        {
            return (o1.getAlbum_name().compareTo(o2.getAlbum_name()));
        };
        Collections.sort(songs,comparator);
        List<Songs>sortOnAlbum  = new ArrayList<>();
        boolean flag = false;
        for(Songs a : songs)
        {
            if(a.getAlbum_name().equalsIgnoreCase(album))
            {
                sortOnAlbum.add(a);
                flag = true;
            }
        }
        if(flag == false)
        {
            throw new CredentialsExpection("Album Name was not found");
        }
        return sortOnAlbum;
    }

    public  List<Songs> showBasedOnArtist(String artist,List<Songs>songs) throws  CredentialsExpection {
        Comparator<Songs> comparator=(o1, o2)->
        {
            return (o1.getAlbum_artist().compareTo(o2.getAlbum_artist()));
        };
        Collections.sort(songs,comparator);
        List<Songs>sortByArtist  = new ArrayList<>();
        boolean flag = false;
        for(Songs a : songs)
        {
            // System.out.println(a.getAlbum_artist()+"  "+artist);
            if(a.getAlbum_artist().equalsIgnoreCase(artist))
            {
                sortByArtist.add(a);
                flag = true;
            }
        }
        if(flag == false)
        {
            throw new CredentialsExpection("Artist Name was not found");
        }
        return sortByArtist;
    }

    public List<Songs> showBasedOnGenre(String genre,List<Songs>songs) throws  CredentialsExpection {
        Comparator<Songs> comparator=(o1, o2)->
        {
            return (o1.getAlbum_genre().compareTo(o2.getAlbum_genre()));
        };
        Collections.sort(songs,comparator);
        List<Songs>sortByGenre  = new ArrayList<>();
        boolean flag = false;

        for (Songs a : songs) {
            if (a.getAlbum_genre().equalsIgnoreCase(genre)) {
                sortByGenre.add(a);
                flag = true;
            }
        }
        if(flag == false)
        {
            throw new CredentialsExpection("Grenre was not found");
        }
        return sortByGenre;
    }
    public void showUserDetails( int id,Connection con)
    {
        try{
            boolean flag = false;
            String sql = "Select * from userdetails where user_Id =?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,id);
            // System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                flag=true;
                System.out.format("%-10s %-20s %-20s %-20s %-20s %n",resultSet.getInt(1),
                        resultSet.getString(2),resultSet.getLong(3),resultSet.getString(4),
                        resultSet.getString(5));
            }
            if(flag ==false)
                System.out.println("no data found for "+id);
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

    }

    void CreatePlayList(int Pl_Id, String PL_Name, int userId,int PL_Time, Connection con) {
        try {

            String sql = "insert into  playList values  (?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, Pl_Id);
            statement.setString(2, PL_Name);
            statement.setInt(3, userId);
            statement.setInt(4, PL_Time);
            statement.executeUpdate();
            System.out.println("Records have been inserted");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void showPlayListDetails( int id,Connection con)
    {
        try{
            boolean flag = false;
            String sql = "Select * from playList where user_id =?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,id);
            // System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                flag=true;
                System.out.format("%-10s %-20s %-20s %-20s %n",resultSet.getInt(1),
                        resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4));
            }
            if(flag ==false)
                System.out.println("no data found for "+id);
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    void addPlayerListData(int PL_id,int song_id,Connection con)
    {
        try {
            String sql = "insert into  playerListDetails values  (?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,PL_id);
            statement.setInt(2,song_id);
            statement.executeUpdate();
            System.out.println("Records have been inserted");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    void showPlayerListData(int id,Connection con)
    {
        try{
            boolean flag = false;
            String sql = "select * from playerListDetails where PL_id =?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                flag=true;
                String sql2  =  "select * from songsList where song_id="+ resultSet.getInt(2);
                Statement statement1 = con.createStatement();
                ResultSet res = statement1.executeQuery(sql2);
                while (res.next()) {
                    flag=true;
                    System.out.format("%-10s %-20s %-20s %-20s %-20s %n",res.getInt(1),res.getString(2)
                            ,res.getString(3),res.getString(4)
                            ,res.getString(5));
                }
            }
            if(flag==false)
                System.out.println("no data found for "+id);
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
