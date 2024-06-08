package skyapi.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VolumePage {
    private Integer id;
    private Integer pageNumber;
    private Image image;
}
