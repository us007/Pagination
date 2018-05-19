package com.example.utsav.pagination;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductList {

    /**
     * message :
     * status : true
     * statusCode : 100
     * data : [{"designBy":null,"designerId":0,"id":334,"isFavorite":false,"name":"Floral Spring","tags":["SOLD OUT"],"thumbImageUrl":"http://web1.anasource.com/no5//ResizeImage.aspx?imgPath=img/cms/WechatIMG3.jpg"},{"designBy":null,"designerId":0,"id":333,"isFavorite":false,"name":"Purple Vintage Garden","tags":["SOLD OUT"],"thumbImageUrl":"http://web1.anasource.com/no5//ResizeImage.aspx?imgPath=img/cms/WechatIMG2.jpg"},{"designBy":null,"designerId":0,"id":332,"isFavorite":false,"name":"Happy Rainbow","tags":["Japan No.1, Hamaura san👍🏽"],"thumbImageUrl":"http://web1.anasource.com/no5//ResizeImage.aspx?imgPath=img/cms/WechatIMG1.jpg"},{"designBy":null,"designerId":0,"id":323,"isFavorite":false,"name":"Japan Exclusive Navy Copper","tags":["LIMITED"],"thumbImageUrl":"http://web1.anasource.com/no5//ResizeImage.aspx?imgPath=img/cms/IMG_6043.JPG"},{"designBy":"Anna Wintour Collection","designerId":0,"id":324,"isFavorite":false,"name":"Japan Exclusive Feather Summer ","tags":["LIMITED"],"thumbImageUrl":"http://web1.anasource.com/no5//ResizeImage.aspx?imgPath=img/cms/IMG_6044.JPG"}]
     * nextPage : -1
     */

    @SerializedName("message")
    private String message;
    @SerializedName("status")
    private boolean status;
    @SerializedName("statusCode")
    private int statusCode;
    @SerializedName("nextPage")
    private int nextPage;
    @SerializedName("data")
    private List<Data> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public static class Data {
        /**
         * designBy : null
         * designerId : 0
         * id : 334
         * isFavorite : false
         * name : Floral Spring
         * tags : ["SOLD OUT"]
         * thumbImageUrl : http://web1.anasource.com/no5//ResizeImage.aspx?imgPath=img/cms/WechatIMG3.jpg
         */

        @SerializedName("designBy")
        private Object designBy;
        @SerializedName("designerId")
        private int designerId;
        @SerializedName("id")
        private int id;
        @SerializedName("isFavorite")
        private boolean isFavorite;
        @SerializedName("name")
        private String name;
        @SerializedName("thumbImageUrl")
        private String thumbImageUrl;
        @SerializedName("tags")
        private List<String> tags;

        public Object getDesignBy() {
            return designBy;
        }

        public void setDesignBy(Object designBy) {
            this.designBy = designBy;
        }

        public int getDesignerId() {
            return designerId;
        }

        public void setDesignerId(int designerId) {
            this.designerId = designerId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isIsFavorite() {
            return isFavorite;
        }

        public void setIsFavorite(boolean isFavorite) {
            this.isFavorite = isFavorite;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getThumbImageUrl() {
            return thumbImageUrl;
        }

        public void setThumbImageUrl(String thumbImageUrl) {
            this.thumbImageUrl = thumbImageUrl;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }
    }
}
