package com.ktoy.expspring.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public List<BoardDTO> selectAll(){
        return boardMapper.selectAll();
    }

}
