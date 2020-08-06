package com.hunter.cursomc.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.hunter.cursomc.services.exceptions.FileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class S3Services {

    private Logger log = LoggerFactory.getLogger(S3Services.class);

    @Autowired
    private AmazonS3 s3Client;

    @Value("${s3.bucket}")
    private String bucketName;

    public URI uploadFile(MultipartFile multipartFile) {
        try {
            String fileName = multipartFile.getOriginalFilename();
            InputStream is = null;
            is = multipartFile.getInputStream();
            String contentType = multipartFile.getContentType();
            return uploadFile(is, fileName, contentType);
        } catch (IOException e) {
            throw new FileException("Erro de IO: " + e.getStackTrace());
        }
    }

    public URI uploadFile(InputStream in, String filename, String contentType) {
        try {
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType(contentType);
            log.info("Iniciando upload");
            s3Client.putObject(new PutObjectRequest(bucketName, filename, in, meta));
            log.info("Upload Finalizado");
            return s3Client.getUrl(bucketName, filename).toURI();
        } catch (URISyntaxException e) {
            throw new FileException("Erro ao converter URL para URI.");
        }
    }
}
