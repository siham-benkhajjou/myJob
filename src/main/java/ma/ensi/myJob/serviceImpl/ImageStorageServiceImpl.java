package ma.ensi.myJob.serviceImpl;

import ma.ensi.myJob.service.IImageStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageStorageServiceImpl implements IImageStorageService {

    @Value("${app.upload-dir}")
    private String uploadDir;
    @Override
    public String saveProfileImage(MultipartFile file, String folderName) {
        try {
            String fileName = "profile.png";
            Path uploadPath = Paths.get(uploadDir + "/src/main/resources/static/assets/img/" + folderName);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            Path filePath = uploadPath.resolve(fileName);
            file.transferTo(filePath.toFile());

            return "/assets/img/" + folderName + "/" + fileName;
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de l'enregistrement de l'image", e);
        }
    }
}
