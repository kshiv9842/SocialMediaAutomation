package api.reponse;
import java.util.List;

import lombok.Data;

@Data
public class VideoGenerationReponse {
    private int page;
    private int perPage;
    private List<Video> videos;
    private int totalResults;
    private String nextPage;
    private String url;
    }
