package monumemory.models.empty;

import monumemory.entities.PhotoEntity;
import monumemory.models.PhotoModelInterface;
import monumemory.models.PhotoSetModelInterface;
import monumemory.models.exceptions.CallMethodOnEmptyModelException;

public class PhotoModelEmpty extends AbstractModelEmpty implements PhotoModelInterface {

    public PhotoModelEmpty(Integer id) {
        super(id);
    }

    public void setId(Integer id) {
        throw new CallMethodOnEmptyModelException();
    }

    public String getName() {
        throw new CallMethodOnEmptyModelException();
    }

    public void setName(String name) {
        throw new CallMethodOnEmptyModelException();
    }

    public String getPath() {
        throw new CallMethodOnEmptyModelException();
    }

    public void setPath(String path) {
        throw new CallMethodOnEmptyModelException();
    }

    public PhotoSetModelInterface getPhotoSet() {
        throw new CallMethodOnEmptyModelException();
    }

    public void setPhotoSet(PhotoSetModelInterface photoSet) {
        throw new CallMethodOnEmptyModelException();
    }

    public void map(PhotoEntity photoEntity) {
        throw new CallMethodOnEmptyModelException();
    }
}
