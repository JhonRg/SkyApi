package skyapi.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Chapter {
    private Integer id;
    private Integer chapterNumber;
    private String title;
    private List<VolumePage> pages;
}
