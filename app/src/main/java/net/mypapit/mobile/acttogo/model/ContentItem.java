package net.mypapit.mobile.acttogo.model;

/**
 * Created by Admin on 22/2/2018.
 */

public abstract class ContentItem {

    String title, subtitle, url;


    public abstract String getTitle();

    public abstract String getSubtitle();

    public abstract String getUrl();

    public abstract String getSubtitleChar();


}
