package monumemory.models;

import monumemory.entities.MonumentEntity;

import java.util.List;

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

    void map(MonumentEntity monumentEntity);
}
