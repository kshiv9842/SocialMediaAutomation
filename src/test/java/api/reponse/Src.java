package api.reponse;

import lombok.Data;

@Data
public class Src {
    private String original;
    private String large2x;
    private String large;
    private String medium;
    private String small;
    private String portrait;
    private String landscape;
    private String tiny;
}
