package monumemory.entities;

import lombok.Data;
import monumemory.models.MonumentModelInterface;

@Data
public class MonumentEntity {

    private Integer id;

    private String name;

    private String description;

    private String history;

    public void map(MonumentModelInterface monumentModel) {
        this.setId(monumentModel.getId());
        this.setName(monumentModel.getName());
        this.setDescription(monumentModel.getDescription());
        this.setHistory(monumentModel.getHistory());
    }
}
