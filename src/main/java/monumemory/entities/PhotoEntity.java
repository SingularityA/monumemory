package monumemory.entities;

import lombok.Data;

/**
 * @author SingularityA
 */
@Data
public class PhotoEntity {

    private Integer id;

    private String name;

    private String path;

    private Integer photoSetId;
}
