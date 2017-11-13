package com.company;

import com.company.Model.Artist;
import com.company.Model.Datasource;

import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        Datasource datasource=new Datasource();
        if(!datasource.open()){
            System.out.println("Can't Open datasource");return;
        }
        List<Artist>artists=datasource.queryArtists(Datasource.ORDER_BY_ASC);
        if(artists==null) {
            System.out.println("No Artists");
            return;
        }
        for(Artist art:artists){
            System.out.println("ID= "+art.getId()+", Name = "+art.getName());
        }

        datasource.close();
    }
}
