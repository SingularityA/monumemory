package monumemory.models;

import java.util.List;
import lombok.Data;
import monumemory.entities.MonumentEntity;
import monumemory.models.empty.ModelsListEmpty;

@Data
public class MonumentModel implements MonumentModelInterface {

    private Integer id;

    private String name;

    private String description;

    private String history;

    private List<PhotoSetModelInterface> photoSets;

    public void map(MonumentEntity monumentEntity) {
        this.setId(monumentEntity.getId());
        this.setName(monumentEntity.getName());
        this.setDescription(monumentEntity.getDescription());
        this.setHistory(monumentEntity.getHistory());
        this.setPhotoSets(new ModelsListEmpty());
    }
}
