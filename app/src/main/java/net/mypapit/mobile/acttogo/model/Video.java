package net.mypapit.mobile.acttogo.model;

/**
 * Created by Admin on 22/2/2018.
 */

public class Video extends ContentItem  {

    private String title, subtitle, url;


    public Video(String title, String subtitle, String url) {
        this.title = title;
        this.subtitle = subtitle;
        this.url = url;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSubtitle() {
        return subtitle;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getSubtitleChar() {
        return subtitle.length() < 2 ? subtitle: subtitle.substring(0, 2);

    }
}
