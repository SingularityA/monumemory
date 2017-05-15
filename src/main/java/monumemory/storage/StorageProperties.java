package monumemory.storage;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("storage")
@Component
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    @Getter
    @Setter
    private String location = "/home/kiiru/TestProjects/monumemory/src/main/resources/public/img/";
}
