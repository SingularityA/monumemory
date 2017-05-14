package monumemory.services;

import java.util.ArrayList;
import java.util.List;
import monumemory.dao.MonumentsDao;
import monumemory.entities.MonumentEntity;
import monumemory.models.MonumentModel;
import monumemory.models.MonumentModelInterface;
import monumemory.services.exceptions.DeleteUnidentifiedModelException;
import monumemory.services.exceptions.InsertIdentifiedModelException;
import monumemory.services.exceptions.UpdateUnidentifiedModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonumentsService {

    @Autowired
    private MonumentsDao monumentsDao;

    public List<MonumentModelInterface> findAll() {
        return this.map(this.monumentsDao.findAll());
    }

    public MonumentModelInterface find(Integer id) {
        final MonumentEntity monumentEntity = this.monumentsDao.find(id);
        if (monumentEntity == null) {
            return null;
        }
        return this.map(monumentEntity);
    }

    public void insert(MonumentModelInterface monumentModel) {
        if (monumentModel.getId() != null) {
            throw new InsertIdentifiedModelException();
        }
        final MonumentEntity monumentEntity = this.map(monumentModel);
        this.monumentsDao.insert(monumentEntity);
        monumentModel.setId(monumentEntity.getId());
    }

    public void update(MonumentModelInterface monumentModel) {
        if (monumentModel.getId() == null) {
            throw new UpdateUnidentifiedModelException();
        }
        this.monumentsDao.update(this.map(monumentModel));
    }

    public void delete(MonumentModelInterface monumentModel) {
        if (monumentModel.getId() == null) {
            throw new DeleteUnidentifiedModelException();
        }
        this.monumentsDao.delete(this.map(monumentModel));
    }

    private MonumentModelInterface map(MonumentEntity monumentEntity) {
        final MonumentModelInterface monumentModel = new MonumentModel();
        monumentModel.map(monumentEntity);
        return monumentModel;
    }

    private MonumentEntity map(MonumentModelInterface monumentModel) {
        final MonumentEntity monumentEntity = new MonumentEntity();
        monumentEntity.map(monumentModel);
        return monumentEntity;
    }

    private List<MonumentModelInterface> map(List<MonumentEntity> monumentEntities) {
        final List<MonumentModelInterface> monumentModels = new ArrayList<>(monumentEntities.size());
        for (MonumentEntity monumentEntity: monumentEntities) {
            monumentModels.add(this.map(monumentEntity));
        }
        return monumentModels;
    }
}
