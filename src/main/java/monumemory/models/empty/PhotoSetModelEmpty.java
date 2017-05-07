package monumemory.models.empty;

import java.util.List;
import monumemory.entities.PhotoSetEntity;
import monumemory.models.MonumentModelInterface;
import monumemory.models.PhotoModelInterface;
import monumemory.models.PhotoSetModelInterface;
import monumemory.models.exceptions.CallMethodOnEmptyModelException;

public class PhotoSetModelEmpty extends AbstractModelEmpty implements PhotoSetModelInterface {

    public PhotoSetModelEmpty(Integer id) {
        super(id);
    }

    public void setId(Integer id) {
        throw new CallMethodOnEmptyModelException();
    }

    public String getDescription() {
        throw new CallMethodOnEmptyModelException();
    }

    public void setDescription(String description) {
        throw new CallMethodOnEmptyModelException();
    }

    public MonumentModelInterface getMonument() {
        throw new CallMethodOnEmptyModelException();
    }

    public void setMonument(MonumentModelInterface monument) {
        throw new CallMethodOnEmptyModelException();
    }

    public List<PhotoModelInterface> getPhotos() {
        throw new CallMethodOnEmptyModelException();
    }

    public void setPhotos(List<PhotoModelInterface> photos) {
        throw new CallMethodOnEmptyModelException();
    }

    public void map(PhotoSetEntity photoSetEntity) {
        throw new CallMethodOnEmptyModelException();
    }
}
