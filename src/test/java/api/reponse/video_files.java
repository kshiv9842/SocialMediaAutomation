package api.reponse;

import lombok.Data;

@Data

public class video_files {
    private int id;
    private String quality;
    private String fileType;
    private int width;
    private int height;
    private double fps;
    private String link;
    private int size;
}
