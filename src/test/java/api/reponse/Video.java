package api.reponse;

import java.util.List;

import lombok.Data;

@Data
public class Video {
    private int id;
    private int width;
    private int height;
    private int duration;
    private String       fullRes;
    private List<String> tags;
    private String       url;
    private String image;
    private String avgColor;
    private List<video_files> video_files;
    private List<VideoPicture> videoPictures;

}
