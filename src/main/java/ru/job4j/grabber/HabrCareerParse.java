package ru.job4j.grabber;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.DateTimeParser;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HabrCareerParse implements Parse {

    private static final String SOURCE_LINK = "https://career.habr.com";
    private static final String PAGE_LINK = String.format("%s/vacancies/java_developer", SOURCE_LINK);
    private final DateTimeParser dateTimeParser;
    public static final int PAGES = 5;

    public HabrCareerParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    public static void main(String[] args) throws IOException {
        for (int j = 1; j <= PAGES; j++) {
            Connection connection = Jsoup.connect(String.format("%s%s", PAGE_LINK, "?page=" + j));
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

    private String retrieveDescription(Element element) throws IOException {
        Element descElement = element.select(".vacancy-card__icon-link").first().child(0);
        String link = String.format("%s%s", SOURCE_LINK, descElement.attr("href"));
        Connection connection = Jsoup.connect(link);
        Document document = connection.get();
        return document.select(".job_show_description__vacancy_description").text();
    }

    @Override
    public List<Post> list(String link) {
        List<Post> rsl = new ArrayList<>();
        try {
            for (int i = 1; i <= PAGES; i++) {
                Connection connection =
                        Jsoup.connect(String.format("%s%s", link, "?page=" + i));
                Document document = connection.get();
                Elements rows = document.select(".vacancy-card__inner");
                rows.forEach(row -> {
                    try {
                        rsl.add(createPost(row));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
                e.printStackTrace();
        }
        return rsl;
    }

    private String retrieveTitle(Element element) {
        return element.select(".vacancy-card__title").first().text();
    }

    private String retrieveLink(Element element) {
        return element.select(".vacancy-card__title")
                .first().child(0).attr("href");
    }

    private LocalDateTime retrieveDate(Element element) {
        Element dateElement = element.select(".vacancy-card__date").first().child(0);
        return dateTimeParser.parse(dateElement.attr("datetime"));
    }

    public Post createPost(Element element) throws IOException {
        return new Post(
                retrieveTitle(element),
                retrieveLink(element),
                retrieveDescription(element),
                retrieveDate(element)
        );
    }
}
