package monumemory.dao;

import java.util.List;
import monumemory.entities.PhotoEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PhotosDao {
    @Results(
            id = "Photo",
            value = {
                    @Result(property = "id", column = "id"),
                    @Result(property = "name", column = "name"),
                    @Result(property = "path", column = "path"),
                    @Result(property = "photoSetId", column = "photo_set_id")
            })
    @Select("SELECT * FROM photos")
    List<PhotoEntity> findAll();

    @Select("SELECT * FROM photos WHERE id=#{id}")
    @ResultMap("Photo")
    PhotoEntity find(Integer id);

    @Select("SELECT * FROM photos WHERE photo_set_id=#{photoSetId}")
    @ResultMap("Photo")
    List<PhotoEntity> findByPhotoSetId(Integer photoSetId);

    @Insert("INSERT INTO photos (name, path, photo_set_id) VALUES (#{name}, #{path}, #{photoSetId})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void insert(PhotoEntity photoEntity);

    @Update("UPDATE photos SET name=#{name}, path=#{path}, photo_set_id=#{photoSetId} WHERE id=#{id}")
    void update(PhotoEntity photoEntity);

    @Delete("DELETE FROM photos WHERE id=#{id}")
    void delete(PhotoEntity photoEntity);
}
