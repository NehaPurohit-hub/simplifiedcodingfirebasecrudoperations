package com.example.simplifiedcodingfirebasecrudoperations;

public class artist {
    String  Artistid;
    String Artistname;
    String Artistgenere;

    public artist() {

    }

    public artist(String artistid, String artistname, String artistgenere) {
        Artistid = artistid;
        Artistname = artistname;
        Artistgenere = artistgenere;
    }

    public String getArtistid() {
        return Artistid;
    }

    public String getArtistname() {
        return Artistname;
    }

    public String getArtistgenere() {
        return Artistgenere;
    }
}
