package monumemory.models;

import lombok.Data;
import monumemory.entities.PhotoEntity;
import monumemory.models.empty.PhotoSetModelEmpty;

@Data
public class PhotoModel implements PhotoModelInterface {

    private Integer id;

    private String name;

    private String path;

    private PhotoSetModelInterface photoSet;

    public void map(PhotoEntity photoEntity) {
        this.setId(photoEntity.getId());
        this.setName(photoEntity.getName());
        this.setPath(photoEntity.getPath());
        this.setPhotoSet(new PhotoSetModelEmpty(photoEntity.getPhotoSetId()));
    }
}
