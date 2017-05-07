package monumemory.models.empty;

import java.util.List;
import monumemory.entities.MonumentEntity;
import monumemory.models.MonumentModelInterface;
import monumemory.models.PhotoSetModelInterface;
import monumemory.models.exceptions.CallMethodOnEmptyModelException;
import monumemory.models.exceptions.CallMethodOnEmptyModelsListException;

public class MonumentModelEmpty extends AbstractModelEmpty implements MonumentModelInterface {

    public MonumentModelEmpty(Integer id) {
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

    public String getDescription() {
        throw new CallMethodOnEmptyModelException();
    }

    public void setDescription(String description) {
        throw new CallMethodOnEmptyModelException();
    }

    public String getHistory() {
        throw new CallMethodOnEmptyModelException();
    }

    public void setHistory(String history) {
        throw new CallMethodOnEmptyModelException();
    }

    public List<PhotoSetModelInterface> getPhotoSets() {
        throw new CallMethodOnEmptyModelsListException();
    }

    public void setPhotoSets(List<PhotoSetModelInterface> photoSets) {
        throw new CallMethodOnEmptyModelsListException();
    }

    public void map(MonumentEntity monumentEntity) {
        throw new CallMethodOnEmptyModelsListException();
    }
}
