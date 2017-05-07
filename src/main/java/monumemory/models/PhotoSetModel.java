package monumemory.models;

import java.util.List;
import lombok.Data;
import monumemory.entities.PhotoSetEntity;
import monumemory.models.empty.ModelsListEmpty;
import monumemory.models.empty.MonumentModelEmpty;

@Data
public class PhotoSetModel implements PhotoSetModelInterface {

    private Integer id;

    private String description;

    private MonumentModelInterface monument;

    private List<PhotoModelInterface> photos;

    public void map(PhotoSetEntity photoSetEntity) {
        this.setId(photoSetEntity.getId());
        this.setDescription(photoSetEntity.getDescription());
        this.setMonument(new MonumentModelEmpty(photoSetEntity.getMonumentId()));
        this.setPhotos(new ModelsListEmpty());
    }
}
