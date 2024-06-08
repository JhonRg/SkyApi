package skyapi.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Volume {
    private Integer id;
    private Chapter chapter;
    private Integer volumeNumber;
}
