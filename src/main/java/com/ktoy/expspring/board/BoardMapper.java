package com.ktoy.expspring.board;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("Select * from board_table")
    List<BoardDTO> selectAll();

}
