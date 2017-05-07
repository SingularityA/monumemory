package monumemory.entities;

import lombok.Data;
import monumemory.models.PhotoModelInterface;

@Data
public class PhotoEntity {

    private Integer id;

    private String name;

    private String path;

    private Integer photoSetId;

    public void map(PhotoModelInterface photoModel) {
        this.setId(photoModel.getId());
        this.setName(photoModel.getName());
        this.setPath(photoModel.getPath());
        this.setPhotoSetId(photoModel.getPhotoSet().getId());
    }
}
