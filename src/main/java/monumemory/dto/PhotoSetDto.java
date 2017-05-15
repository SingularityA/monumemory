package monumemory.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import monumemory.models.PhotoSetModelInterface;
import monumemory.models.empty.ModelsListEmpty;
import monumemory.models.empty.MonumentModelEmpty;

@Data
public class PhotoSetDto {

    @Size(max = 250)
    private String description;

    @NotNull
    private Integer monumentId;

    public void map(PhotoSetModelInterface photoSetModel) {
        this.setDescription(photoSetModel.getDescription());
        this.setMonumentId(photoSetModel.getMonument().getId());
    }

    public void mapInto(PhotoSetModelInterface photoSetModel) {
        photoSetModel.setDescription(this.getDescription());
        photoSetModel.setMonument(new MonumentModelEmpty(this.getMonumentId()));
        photoSetModel.setPhotos(new ModelsListEmpty());
    }
}
