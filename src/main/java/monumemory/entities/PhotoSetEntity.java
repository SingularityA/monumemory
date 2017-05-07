package monumemory.entities;

import lombok.Data;

@Data
public class PhotoSetEntity {

    private Integer id;

    private String description;

    private Integer monumentId;
}
