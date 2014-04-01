package com.nanotweets.dao.custom;

import org.apache.ibatis.annotations.Select;

public interface SequenceMapper {
	String SELECT_NEXT_VALUE_SEQ_ANNOTATION = "SELECT NEXTVAL('annotation_id_seq')";

	@Select(SELECT_NEXT_VALUE_SEQ_ANNOTATION)
	Integer getNextValueSeqAnnotation();
}
