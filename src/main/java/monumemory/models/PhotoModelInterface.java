package monumemory.models;

/**
 * @author SingularityA
 */
public interface PhotoModelInterface extends ModelInterface {

    void setId(Integer id);

    String getName();

    void setName(String name);

    String getPath();

    void setPath(String path);

    PhotoSetModelInterface getPhotoSet();

    void setPhotoSet(PhotoSetModelInterface photoSet);
}