package monumemory.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import monumemory.models.MonumentModelInterface;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class MonumentDto {

    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String name;

    @NotNull
    @NotEmpty
    @Size(max = 250)
    private String description;

    @Size(max = 500)
    private String history;

    public void map(MonumentModelInterface monumentModel) {
        this.setName(monumentModel.getName());
        this.setDescription(monumentModel.getDescription());
        this.setHistory(monumentModel.getHistory());
    }

    public void mapInto(MonumentModelInterface monumentModel) {
        monumentModel.setName(this.getName());
        monumentModel.setDescription(this.getDescription());
        monumentModel.setHistory(this.getHistory());
    }
}
