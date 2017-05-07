package monumemory.entities;

import lombok.Data;

@Data
public class PhotoEntity {

    private Integer id;

    private String name;

    private String path;

    private Integer photoSetId;
}
