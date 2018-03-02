package net.mypapit.mobile.acttogo.model;

/**
 * Created by Admin on 20/2/2018.
 */

public class MenuModel {
    private  int mImageResource;
    private String title;
    private String subtitle;

    public MenuModel (int imageid, String title, String subtitle)
    {
        this.mImageResource = imageid;
        this.title = title;
        this.subtitle = subtitle;


    }


    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
