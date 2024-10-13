package api.reponse;

import java.util.List;

import lombok.Data;

@Data
public class ImageGenerationResponse {
    private int page;
    private int         perPage;
    private List<Photo> photos;
    private int         totalResults;
    private String nextPage;
}
