package cn.libra.dao;

import cn.libra.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface IUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Jan 11 13:19:37 CST 2017
     */
    @Delete({
        "delete from user",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Jan 11 13:19:37 CST 2017
     */
    @Insert({
        "insert into user (Name, Age)",
        "values (#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Jan 11 13:19:37 CST 2017
     */
    @Select({
        "select",
        "ID, Name, Age",
        "from user",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="Age", property="age", jdbcType=JdbcType.INTEGER)
    })
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Jan 11 13:19:37 CST 2017
     */
    @Select({
        "select",
        "ID, Name, Age",
        "from user",
        "order by age desc,username asc"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="Age", property="age", jdbcType=JdbcType.INTEGER)
    })
    List<User> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Jan 11 13:19:37 CST 2017
     */
    @Update({
        "update user",
        "set Name = #{name,jdbcType=VARCHAR},",
          "Age = #{age,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}