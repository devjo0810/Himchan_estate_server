package site.himchan.estate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.himchan.estate.mapper.FileMapper;
import site.himchan.estate.vo.BoardFileVO;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileMapper fileMapper;

    public BoardFileVO findByFileName(String fileName) {
        return fileMapper.findByFileName(fileName);
    }

}
