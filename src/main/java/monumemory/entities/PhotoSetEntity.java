package monumemory.entities;

import lombok.Data;
import monumemory.models.PhotoSetModelInterface;

@Data
public class PhotoSetEntity {

    private Integer id;

    private String description;

    private Integer monumentId;

    public void map(PhotoSetModelInterface photoSetModel) {
        this.setId(photoSetModel.getId());
        this.setDescription(photoSetModel.getDescription());
        this.setMonumentId(photoSetModel.getMonument().getId());
    }
}
