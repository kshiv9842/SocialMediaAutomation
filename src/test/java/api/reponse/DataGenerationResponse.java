package api.reponse;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DataGenerationResponse {
    private List<Candidate> candidates;
}
