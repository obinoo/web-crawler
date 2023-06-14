package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class crawler {
    public static void main(String[] args) {

        final String url = "https://www.imdb.com/chart/top";

        try {
            final Document doc = Jsoup.connect(url).get();
            Elements el = doc.select("tbody.lister-list");

            for (Element e : el.select("tr")) {

                String title = e.select("td.posterColumn img").attr("alt");
                System.out.println(title);

                String rate = e.select("td.ratingColumn.imdbRating").text();
                System.out.println(rate);
            }

        } catch (IOException e){
                 e.printStackTrace();
        }

    }
}
