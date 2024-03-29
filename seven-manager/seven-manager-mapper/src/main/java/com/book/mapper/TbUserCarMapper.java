package com.book.mapper;

import com.book.pojo.TbUserCar;
import com.book.pojo.TbUserCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserCarMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_car
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int countByExample(TbUserCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_car
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int deleteByExample(TbUserCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_car
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_car
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int insert(TbUserCar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_car
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int insertSelective(TbUserCar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_car
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    List<TbUserCar> selectByExample(TbUserCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_car
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    TbUserCar selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_car
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int updateByExampleSelective(@Param("record") TbUserCar record, @Param("example") TbUserCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_car
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int updateByExample(@Param("record") TbUserCar record, @Param("example") TbUserCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_car
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int updateByPrimaryKeySelective(TbUserCar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user_car
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    int updateByPrimaryKey(TbUserCar record);
}