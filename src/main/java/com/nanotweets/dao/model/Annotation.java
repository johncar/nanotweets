package com.nanotweets.dao.model;

import java.io.Serializable;
import java.util.Date;

public class Annotation implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.annotation.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.annotation.original_text
     *
     * @mbggenerated
     */
    private String originalText;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.annotation.annotated_text
     *
     * @mbggenerated
     */
    private String annotatedText;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.annotation.document
     *
     * @mbggenerated
     */
    private String document;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.annotation.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.annotation.creation
     *
     * @mbggenerated
     */
    private Date creation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.annotation.completed
     *
     * @mbggenerated
     */
    private Date completed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.annotation
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.annotation.id
     *
     * @return the value of public.annotation.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.annotation.id
     *
     * @param id the value for public.annotation.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.annotation.original_text
     *
     * @return the value of public.annotation.original_text
     *
     * @mbggenerated
     */
    public String getOriginalText() {
        return originalText;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.annotation.original_text
     *
     * @param originalText the value for public.annotation.original_text
     *
     * @mbggenerated
     */
    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.annotation.annotated_text
     *
     * @return the value of public.annotation.annotated_text
     *
     * @mbggenerated
     */
    public String getAnnotatedText() {
        return annotatedText;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.annotation.annotated_text
     *
     * @param annotatedText the value for public.annotation.annotated_text
     *
     * @mbggenerated
     */
    public void setAnnotatedText(String annotatedText) {
        this.annotatedText = annotatedText;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.annotation.document
     *
     * @return the value of public.annotation.document
     *
     * @mbggenerated
     */
    public String getDocument() {
        return document;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.annotation.document
     *
     * @param document the value for public.annotation.document
     *
     * @mbggenerated
     */
    public void setDocument(String document) {
        this.document = document;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.annotation.status
     *
     * @return the value of public.annotation.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.annotation.status
     *
     * @param status the value for public.annotation.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.annotation.creation
     *
     * @return the value of public.annotation.creation
     *
     * @mbggenerated
     */
    public Date getCreation() {
        return creation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.annotation.creation
     *
     * @param creation the value for public.annotation.creation
     *
     * @mbggenerated
     */
    public void setCreation(Date creation) {
        this.creation = creation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.annotation.completed
     *
     * @return the value of public.annotation.completed
     *
     * @mbggenerated
     */
    public Date getCompleted() {
        return completed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.annotation.completed
     *
     * @param completed the value for public.annotation.completed
     *
     * @mbggenerated
     */
    public void setCompleted(Date completed) {
        this.completed = completed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.annotation
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Annotation other = (Annotation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOriginalText() == null ? other.getOriginalText() == null : this.getOriginalText().equals(other.getOriginalText()))
            && (this.getAnnotatedText() == null ? other.getAnnotatedText() == null : this.getAnnotatedText().equals(other.getAnnotatedText()))
            && (this.getDocument() == null ? other.getDocument() == null : this.getDocument().equals(other.getDocument()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreation() == null ? other.getCreation() == null : this.getCreation().equals(other.getCreation()))
            && (this.getCompleted() == null ? other.getCompleted() == null : this.getCompleted().equals(other.getCompleted()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.annotation
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOriginalText() == null) ? 0 : getOriginalText().hashCode());
        result = prime * result + ((getAnnotatedText() == null) ? 0 : getAnnotatedText().hashCode());
        result = prime * result + ((getDocument() == null) ? 0 : getDocument().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreation() == null) ? 0 : getCreation().hashCode());
        result = prime * result + ((getCompleted() == null) ? 0 : getCompleted().hashCode());
        return result;
    }
}