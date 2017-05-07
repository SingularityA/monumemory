package monumemory.models;

import java.util.List;

/**
 * @author Singularity
 */
public interface PhotoSetModelInterface extends ModelInterface {

    void setId(Integer id);

    String getDescription();

    void setDescription(String description);

    MonumentModelInterface getMonument();

    void setMonument(MonumentModelInterface monument);

    List<PhotoModelInterface> getPhotos();

    void setPhotos(List<PhotoModelInterface> photos);
}
