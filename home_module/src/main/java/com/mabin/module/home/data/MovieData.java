package com.mabin.module.home.data;

import java.util.List;

public class MovieData {

    private int code;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<ItemsBean> items;

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * id : 883326
             * userid : 0
             * nickname :
             * height : 480
             * width : 640
             * duration : 107
             * follow_count : 1
             * created_at : 1597376053
             * img : type4/pv1/250/d2/d2cd8bc94c20977df143c472fc5976abdebf0263.jpg
             * vod :
             * collection : {"id":1541338,"name":"萝莉白虎","userid":3858723,"nickname":"嗯哼嗯哼","avatar":"https://css.bdcache.com/head.jpg"}
             */

            private int id;
            private int userid;
            private String nickname;
            private int height;
            private int width;
            private int duration;
            private int follow_count;
            private int created_at;
            private String img;
            private String vod;
            private CollectionBean collection;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUserid() {
                return userid;
            }

            public void setUserid(int userid) {
                this.userid = userid;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public int getFollow_count() {
                return follow_count;
            }

            public void setFollow_count(int follow_count) {
                this.follow_count = follow_count;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getVod() {
                return vod;
            }

            public void setVod(String vod) {
                this.vod = vod;
            }

            public CollectionBean getCollection() {
                return collection;
            }

            public void setCollection(CollectionBean collection) {
                this.collection = collection;
            }

            public static class CollectionBean {
                /**
                 * id : 1541338
                 * name : 萝莉白虎
                 * userid : 3858723
                 * nickname : 嗯哼嗯哼
                 * avatar : https://css.bdcache.com/head.jpg
                 */

                private int id;
                private String name;
                private int userid;
                private String nickname;
                private String avatar;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getUserid() {
                    return userid;
                }

                public void setUserid(int userid) {
                    this.userid = userid;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }
            }
        }
    }
}
