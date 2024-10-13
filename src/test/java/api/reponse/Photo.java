package api.reponse;

import lombok.Data;

@Data
public class Photo {
    private int id;
    private int width;
    private int height;
    private String url;
    private String photographer;
    private String photographerUrl;
    private int photographerId;
    private String avgColor;
    private Src src;
    private boolean liked;
    private String alt;

}
