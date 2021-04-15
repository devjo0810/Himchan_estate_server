package site.himchan.estate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.himchan.estate.mapper.BoardMapper;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public List<Map<String, Object>> findAll() {
        return boardMapper.findAll();
    }

    public String selectTest() {
        return boardMapper.selectTest();
    }
}
