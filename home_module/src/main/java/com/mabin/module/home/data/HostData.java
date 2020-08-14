package com.mabin.module.home.data;

public class HostData {

    private String book_path;
    private String film_path;
    private String host;
    private String image_path;
    private String vedio_path;
    private String home_image_path;
    private String home_vedio_path;
    private String home_film_path;
    private String type4 ;

    @Override
    public String toString() {
        return "HostData{" +
                "book_path='" + book_path + '\'' +
                ", film_path='" + film_path + '\'' +
                ", host='" + host + '\'' +
                ", image_path='" + image_path + '\'' +
                ", vedio_path='" + vedio_path + '\'' +
                ", home_image_path='" + home_image_path + '\'' +
                ", home_vedio_path='" + home_vedio_path + '\'' +
                ", home_film_path='" + home_film_path + '\'' +
                '}';
    }

    public String getBook_path() {
        return book_path;
    }

    public void setBook_path(String book_path) {
        this.book_path = book_path;
    }

    public String getFilm_path() {
        return film_path;
    }

    public void setFilm_path(String film_path) {
        this.film_path = film_path;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getVedio_path() {
        return vedio_path;
    }

    public void setVedio_path(String vedio_path) {
        this.vedio_path = vedio_path;
    }

    public String getHome_image_path() {
        return home_image_path;
    }

    public void setHome_image_path(String home_image_path) {
        this.home_image_path = home_image_path;
    }

    public String getHome_vedio_path() {
        return home_vedio_path;
    }

    public void setHome_vedio_path(String home_vedio_path) {
        this.home_vedio_path = home_vedio_path;
    }

    public String getHome_film_path() {
        return home_film_path;
    }

    public void setHome_film_path(String home_film_path) {
        this.home_film_path = home_film_path;
    }

    public String getType4() {
        return type4;
    }

    public void setType4(String type4) {
        this.type4 = type4;
    }
}
