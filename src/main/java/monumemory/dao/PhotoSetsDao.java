package monumemory.dao;

import java.util.List;
import monumemory.entities.PhotoSetEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PhotoSetsDao {
    @Results(
            id = "PhotoSet",
            value = {
                    @Result(property = "id", column = "id"),
                    @Result(property = "description", column = "description"),
                    @Result(property = "monumentId", column = "monument_id")
            })
    @Select("SELECT * FROM photo_sets")
    List<PhotoSetEntity> findAll();

    @Select("SELECT * FROM photo_sets WHERE id=#{id}")
    @ResultMap("PhotoSet")
    PhotoSetEntity find(Integer id);

    @Select("SELECT * FROM photo_sets WHERE monument_id=#{monumentId}")
    @ResultMap("PhotoSet")
    List<PhotoSetEntity> findByMonumentId(Integer monumentId);

    @Insert("INSERT INTO photo_sets (description, monument_id) values (#{description}, #{monumentId})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void insert(PhotoSetEntity photoSetEntity);

    @Update("UPDATE photo_sets SET description=#{description}, monument_id=#{monumentId} WHERE id=#{id}")
    void update(PhotoSetEntity photoSetEntity);

    @Delete("DELETE FROM photo_sets WHERE id=#{id}")
    void delete(PhotoSetEntity photoSetEntity);
}
