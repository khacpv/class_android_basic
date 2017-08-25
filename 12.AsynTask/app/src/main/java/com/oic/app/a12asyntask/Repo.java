package com.oic.app.a12asyntask;

import com.google.gson.annotations.SerializedName;

/**
 * Created by khacpham on 8/25/17.
 */

public class Repo {

    @SerializedName("id")
    long id;

    @SerializedName("name")
    String name;

    @SerializedName("full_name")
    String fullname;

    @SerializedName("html_url")
    String htmlUrl;

    @SerializedName("description")
    String description;

}
