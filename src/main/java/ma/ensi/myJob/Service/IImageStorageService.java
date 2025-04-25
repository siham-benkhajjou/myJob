package ma.ensi.myJob.service;

import org.springframework.web.multipart.MultipartFile;

public interface IImageStorageService {
    String saveProfileImage(MultipartFile file, String folderName);
}
