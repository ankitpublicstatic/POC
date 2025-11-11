package com.ankit.poc.aws;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentService {

  @Autowired
  private RedisTemplate<String, Document> redis;
  @Autowired
  private DocumentRepository repository;
  @Autowired
  private AmazonS3 s3;

  public Document getDocument(String docId) {
    return redis.opsForValue().get(docId);
  }

  public void uploadDocument(MultipartFile file) {
    String key = UUID.randomUUID().toString();
    s3.putObject("secure-docs", key, file.getInputStream(), new ObjectMetadata());
    repository.save(new Document(key, file.getOriginalFilename()));
  }
}
