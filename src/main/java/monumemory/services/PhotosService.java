package monumemory.services;

import java.util.ArrayList;
import java.util.List;
import monumemory.dao.PhotosDao;
import monumemory.entities.PhotoEntity;
import monumemory.models.PhotoModel;
import monumemory.models.PhotoModelInterface;
import monumemory.models.PhotoSetModelInterface;
import monumemory.services.exceptions.DeleteUnidentifiedModelException;
import monumemory.services.exceptions.InsertIdentifiedModelException;
import monumemory.services.exceptions.UpdateUnidentifiedModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotosService {

    @Autowired
    private PhotosDao photosDao;

    public List<PhotoModelInterface> findAll() {
        return this.map(this.photosDao.findAll());
    }

    public PhotoModelInterface find(Integer id) {
        final PhotoEntity photoEntity = this.photosDao.find(id);
        if (photoEntity == null) {
            return null;
        }
        return this.map(photoEntity);
    }

    public List<PhotoModelInterface> findByPhotoSet(PhotoSetModelInterface photoSetModel) {
        return this.map(this.photosDao.findByPhotoSetId(photoSetModel.getId()));
    }

    public void insert(PhotoModelInterface photoModel) {
        if (photoModel.getId() != null) {
            throw new InsertIdentifiedModelException();
        }
        final PhotoEntity photoEntity = this.map(photoModel);
        this.photosDao.insert(photoEntity);
        photoModel.setId(photoEntity.getId());
    }

    public void update(PhotoModelInterface photoModel) {
        if (photoModel.getId() == null) {
            throw new UpdateUnidentifiedModelException();
        }
        this.photosDao.update(this.map(photoModel));
    }

    public void delete(PhotoModelInterface photoModel) {
        if (photoModel.getId() == null) {
            throw new DeleteUnidentifiedModelException();
        }
        this.photosDao.delete(this.map(photoModel));
    }

    private PhotoModelInterface map(PhotoEntity photoEntity) {
        final PhotoModelInterface photoModel = new PhotoModel();
        photoModel.map(photoEntity);
        return photoModel;
    }

    private PhotoEntity map(PhotoModelInterface photoModel) {
        final PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.map(photoModel);
        return photoEntity;
    }

    private List<PhotoModelInterface> map(List<PhotoEntity> photoEntities) {
        final List<PhotoModelInterface> photoModels = new ArrayList<>(photoEntities.size());
        for (PhotoEntity photoEntity: photoEntities) {
            photoModels.add(this.map(photoEntity));
        }
        return photoModels;
    }
}
