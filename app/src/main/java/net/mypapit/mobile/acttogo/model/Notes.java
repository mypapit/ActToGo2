package net.mypapit.mobile.acttogo.model;

/**
 * Created by Admin on 21/2/2018.
 */

public class Notes extends ContentItem {
    private String title, subtitle, url;


    public Notes(String title, String subtitle, String url) {
        this.title = title;
        this.subtitle = subtitle;
        this.url = url;
    }


    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getUrl() {
        return url;
    }

    public String getSubtitleChar() {

        return subtitle.length() < 2 ? subtitle: subtitle.substring(0, 2);
    }
}
