package by.epam.pronovich.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Catalog {

    private Integer id;
    private Integer parentId;
    private String description;
}
