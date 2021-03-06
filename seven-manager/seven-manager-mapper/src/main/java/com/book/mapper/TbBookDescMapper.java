package com.book.mapper;

import com.book.pojo.TbBookDesc;
import com.book.pojo.TbBookDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbBookDescMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_book_desc
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int countByExample(TbBookDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_book_desc
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int deleteByExample(TbBookDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_book_desc
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int deleteByPrimaryKey(Long bookId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_book_desc
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int insert(TbBookDesc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_book_desc
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int insertSelective(TbBookDesc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_book_desc
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    List<TbBookDesc> selectByExampleWithBLOBs(TbBookDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_book_desc
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    List<TbBookDesc> selectByExample(TbBookDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_book_desc
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    TbBookDesc selectByPrimaryKey(Long bookId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_book_desc
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int updateByExampleSelective(@Param("record") TbBookDesc record, @Param("example") TbBookDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_book_desc
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") TbBookDesc record, @Param("example") TbBookDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_book_desc
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int updateByExample(@Param("record") TbBookDesc record, @Param("example") TbBookDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_book_desc
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int updateByPrimaryKeySelective(TbBookDesc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_book_desc
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(TbBookDesc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_book_desc
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int updateByPrimaryKey(TbBookDesc record);
}