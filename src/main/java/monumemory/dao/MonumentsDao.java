package monumemory.dao;

import java.util.List;
import monumemory.entities.MonumentEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MonumentDao {
    @Results(
            id = "Monument",
            value = {
                    @Result(property = "id", column = "id"),
                    @Result(property = "name", column = "name"),
                    @Result(property = "description", column = "description"),
                    @Result(property = "history", column = "history")
            })
    @Select("SELECT * FROM monuments")
    List<MonumentEntity> findAll();

    @Select("SELECT * FROM monuments WHERE id=#{id}")
    @ResultMap("Monument")
    MonumentEntity find(Integer id);

    @Insert("INSERT INTO monuments (name, description, history) VALUES (#{name}, #{description}, #{history})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void insert(MonumentEntity monumentEntity);

    @Update("UPDATE monuments SET name=#{name}, description=#{description}, history=#{history} WHERE id=#{id}")
    void update(MonumentEntity monumentEntity);

    @Delete("DELETE FROM monuments WHERE id=#{id}")
    void delete(MonumentEntity monumentEntity);
}
