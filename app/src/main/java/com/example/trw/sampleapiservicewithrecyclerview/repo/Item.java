package com.example.trw.sampleapiservicewithrecyclerview.repo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TRW on 30/8/2560.
 */

public class Item implements Parcelable {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("blog")
    @Expose
    private Blog blog;
    @SerializedName("published")
    @Expose
    private String published;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("selfLink")
    @Expose
    private String selfLink;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("images")
    @Expose
    private List<Image> images;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("replies")
    @Expose
    private Replies replies;
    @SerializedName("labels")
    @Expose
    private List<String> labels = null;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Replies getReplies() {
        return replies;
    }

    public void setReplies(Replies replies) {
        this.replies = replies;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.kind);
        dest.writeString(this.id);
        dest.writeParcelable(this.blog, flags);
        dest.writeString(this.published);
        dest.writeString(this.updated);
        dest.writeString(this.etag);
        dest.writeString(this.url);
        dest.writeString(this.selfLink);
        dest.writeString(this.title);
        dest.writeString(this.content);
        dest.writeList(this.images);
        dest.writeParcelable(this.author, flags);
        dest.writeParcelable(this.replies, flags);
        dest.writeStringList(this.labels);
    }

    public Item() {
    }

    protected Item(Parcel in) {
        this.kind = in.readString();
        this.id = in.readString();
        this.blog = in.readParcelable(Blog.class.getClassLoader());
        this.published = in.readString();
        this.updated = in.readString();
        this.etag = in.readString();
        this.url = in.readString();
        this.selfLink = in.readString();
        this.title = in.readString();
        this.content = in.readString();
        this.images = new ArrayList<Image>();
        in.readList(this.images, Image.class.getClassLoader());
        this.author = in.readParcelable(Author.class.getClassLoader());
        this.replies = in.readParcelable(Replies.class.getClassLoader());
        this.labels = in.createStringArrayList();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
