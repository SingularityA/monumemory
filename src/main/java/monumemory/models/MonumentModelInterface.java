package monumemory.models;

import java.util.List;

/**
 * @author SingularityA
 */
public interface MonumentModelInterface extends ModelInterface {

    void setId(Integer id);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    String getHistory();

    void setHistory(String history);

    List<PhotoSetModelInterface> getPhotoSets();

    void setPhotoSets(List<PhotoSetModelInterface> photoSets);
}
