package com.book.pojo;

import java.util.Date;

public class TbBookCat {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_book_cat.id
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_book_cat.parent_id
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    private Long parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_book_cat.name
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_book_cat.is_parent
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    private Boolean isParent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_book_cat.created
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    private Date created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_book_cat.updated
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    private Date updated;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_book_cat.id
     *
     * @return the value of tb_book_cat.id
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_book_cat.id
     *
     * @param id the value for tb_book_cat.id
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_book_cat.parent_id
     *
     * @return the value of tb_book_cat.parent_id
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_book_cat.parent_id
     *
     * @param parentId the value for tb_book_cat.parent_id
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_book_cat.name
     *
     * @return the value of tb_book_cat.name
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_book_cat.name
     *
     * @param name the value for tb_book_cat.name
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_book_cat.is_parent
     *
     * @return the value of tb_book_cat.is_parent
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    public Boolean getIsParent() {
        return isParent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_book_cat.is_parent
     *
     * @param isParent the value for tb_book_cat.is_parent
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_book_cat.created
     *
     * @return the value of tb_book_cat.created
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_book_cat.created
     *
     * @param created the value for tb_book_cat.created
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_book_cat.updated
     *
     * @return the value of tb_book_cat.updated
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_book_cat.updated
     *
     * @param updated the value for tb_book_cat.updated
     *
     * @mbggenerated Wed Aug 21 15:37:39 CST 2019
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}