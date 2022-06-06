package ru.job4j.grabber;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HabrCareerParse {

    private static final String SOURCE_LINK = "https://career.habr.com";

    private static final String PAGE_LINK = String.format("%s/vacancies/java_developer", SOURCE_LINK);

    public static void main(String[] args) throws IOException {
        List<String> parse = pagesParse(5);
        for (String page : parse) {
            Connection connection = Jsoup.connect(page);
            Document document = connection.get();
            Elements rows = document.select(".vacancy-card__inner");
            rows.forEach(row -> {
                Element titleElement = row.select(".vacancy-card__title").first();
                Element linkElement = titleElement.child(0);
                String vacancyName = titleElement.text();
                String link = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
                Element dateElement = row.select(".vacancy-card__date").first();
                Element date = dateElement.child(0);
                String fullDate = date.attr("datetime");
                System.out.printf("%s %s %s%n", vacancyName, link, fullDate);
            });
        }
    }

    private static List<String> pagesParse(int quantity) {
        StringBuilder stringBuilder = new StringBuilder(PAGE_LINK + "?page=");
        List<String> pages = new ArrayList<>();
        for (int i = 1; i <= quantity; i++) {
            pages.add(stringBuilder.append(i).toString());
        }
        return pages;
    }
}
