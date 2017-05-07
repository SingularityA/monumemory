package monumemory.models;

import monumemory.entities.PhotoEntity;

public interface PhotoModelInterface extends ModelInterface {

    void setId(Integer id);

    String getName();

    void setName(String name);

    String getPath();

    void setPath(String path);

    PhotoSetModelInterface getPhotoSet();

    void setPhotoSet(PhotoSetModelInterface photoSet);

    void map(PhotoEntity photoEntity);
}
