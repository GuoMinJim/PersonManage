package cn.pzhu.pserson.dao.dao;

import cn.pzhu.pserson.dao.provider.DocumentDynaSqlProvider;
import cn.pzhu.pserson.domain.Document;
import cn.pzhu.pserson.domain.response.documentResDTO;
import cn.pzhu.pserson.util.Constants;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

public interface DocumentMapper extends Mapper<Document> {

  //查询
  @Select("select * from " + Constants.DOCUMENTTABLE + " order by id ASC")
  List<Document> get_List();

  @Select("select * from " + Constants.DOCUMENTTABLE
      + " where title like CONCAT('%',#{content},'%') order by id ASC")
  List<Document> get_LikeList(String content);


  @SelectProvider(type = DocumentDynaSqlProvider.class, method = "insert")
  void insert_Info(Document dept);

  @Select("select * from " + Constants.DOCUMENTTABLE + " where id = #{id}")
  Document get_Info(Integer id);

  @SelectProvider(type = DocumentDynaSqlProvider.class, method = "update")
  void update_Info(Document dept);

  // 根据id删除部门
  @Delete(" delete from " + Constants.DOCUMENTTABLE + " where id = #{id} ")
  void delete_Info(Integer id);

  List<documentResDTO> selectById(@Param("content") String content);
}