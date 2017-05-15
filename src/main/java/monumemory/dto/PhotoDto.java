package monumemory.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import monumemory.models.PhotoModelInterface;
import monumemory.models.empty.PhotoSetModelEmpty;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PhotoDto {

    @Size(max = 100)
    private String name;

    @Size(max = 250)
    private String path;

    @NotNull
    private MultipartFile file;

    @NotNull
    private Integer photoSetId;

    public void map(PhotoModelInterface photoModel) {
        this.setName(photoModel.getName());
        this.setPath(photoModel.getPath());
        this.setPhotoSetId(photoModel.getPhotoSet().getId());
    }

    public void mapInto(PhotoModelInterface photoModel) {
        photoModel.setName(this.getName());
        photoModel.setPath(this.getPath());
        photoModel.setPhotoSet(new PhotoSetModelEmpty(this.getPhotoSetId()));
    }
}
