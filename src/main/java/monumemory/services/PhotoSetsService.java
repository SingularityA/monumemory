package monumemory.services;

import java.util.ArrayList;
import java.util.List;
import monumemory.dao.PhotoSetsDao;
import monumemory.entities.PhotoSetEntity;
import monumemory.models.MonumentModelInterface;
import monumemory.models.PhotoSetModel;
import monumemory.models.PhotoSetModelInterface;
import monumemory.services.exceptions.DeleteUnidentifiedModelException;
import monumemory.services.exceptions.InsertIdentifiedModelException;
import monumemory.services.exceptions.UpdateUnidentifiedModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoSetsService {

    @Autowired
    private PhotoSetsDao photoSetsDao;

    public List<PhotoSetModelInterface> findAll() {
        return this.map(this.photoSetsDao.findAll());
    }

    public PhotoSetModelInterface find(Integer id) {
        final PhotoSetEntity photoSetEntity = this.photoSetsDao.find(id);
        if (photoSetEntity == null) {
            return null;
        }
        return this.map(photoSetEntity);
    }

    public List<PhotoSetModelInterface> findByMonument(MonumentModelInterface monumentModel) {
        return this.map(this.photoSetsDao.findByMonumentId(monumentModel.getId()));
    }

    public void insert(PhotoSetModelInterface photoSetModel) {
        if (photoSetModel.getId() != null) {
            throw new InsertIdentifiedModelException();
        }
        this.photoSetsDao.insert(this.map(photoSetModel));
    }

    public void update(PhotoSetModelInterface photoSetModel) {
        if (photoSetModel.getId() == null) {
            throw new UpdateUnidentifiedModelException();
        }
        this.photoSetsDao.update(this.map(photoSetModel));
    }

    public void delete(PhotoSetModelInterface photoSetModel) {
        if (photoSetModel.getId() == null) {
            throw new DeleteUnidentifiedModelException();
        }
        this.photoSetsDao.delete(this.map(photoSetModel));
    }

    private PhotoSetModelInterface map(PhotoSetEntity photoSetEntity) {
        final PhotoSetModelInterface photoSetModel = new PhotoSetModel();
        photoSetModel.map(photoSetEntity);
        return photoSetModel;
    }

    private PhotoSetEntity map(PhotoSetModelInterface photoSetModel) {
        final PhotoSetEntity photoSetEntity = new PhotoSetEntity();
        photoSetEntity.map(photoSetModel);
        return photoSetEntity;
    }

    private List<PhotoSetModelInterface> map(List<PhotoSetEntity> photoSetEntities) {
        final List<PhotoSetModelInterface> photoSetModels = new ArrayList<>(photoSetEntities.size());
        for (PhotoSetEntity photoSetEntity: photoSetEntities) {
            photoSetModels.add(this.map(photoSetEntity));
        }
        return photoSetModels;
    }
}
