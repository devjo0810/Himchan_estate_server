package site.himchan.estate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import site.himchan.estate.config.PropertyUploadConfig;
import site.himchan.estate.service.FileService;
import site.himchan.estate.vo.BoardFileVO;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

@Controller
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;
    private final PropertyUploadConfig propertyUploadConfig;

    @GetMapping(path = "/download/{id}")
    public void fileDownload(@PathVariable(name = "id") String fileName, HttpServletResponse response) {
        String uploadFilePath = propertyUploadConfig.getPath();
        String uploadFileSeparator = propertyUploadConfig.getSeparator();

        BoardFileVO boardFileVO = fileService.findByFileName(fileName);
        if(boardFileVO != null) {
            String filePath = uploadFilePath + uploadFileSeparator + boardFileVO.getFileNm();
            String contentType = boardFileVO.getFileType();
            String fileOriginName = boardFileVO.getFileOriginNm();
            File file = new File(filePath);
            long fileLength = file.length();

            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOriginName + "\";");
            response.setHeader("Content-Transfer-Encoding", "binary");
            response.setHeader("Content-Type", contentType);
            response.setHeader("Content-Length", "" + fileLength);
            response.setHeader("Pragma", "no-cache;");
            response.setHeader("Expires", "-1;");

            try {
                FileInputStream fis = new FileInputStream(filePath);
                OutputStream out = response.getOutputStream();

                int readCount = 0;
                byte[] buffer = new byte[1024];
                // ?????? ?????? ?????? ????????? buffer??? ????????? ???
                while ((readCount = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, readCount);
                    // outputStream??? ????????????
                }
            } catch (Exception e) {
                throw new RuntimeException("file Load Error");
            }
        }
    }

}
