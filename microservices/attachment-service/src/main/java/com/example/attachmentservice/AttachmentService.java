package com.example.attachmentservice;



/*
Возможность добавлять
1) картинка лимит 5 картинок к посту, если нет ошибка,
2) пдф макс размер 5мб вынести в конфиг,
3) торрент

* Статика
* https://www.baeldung.com/spring-mvc-static-resources
* Каким шифрованием пользоваться?
*
*
*
* */

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
// todo @RequiredArgsConstructor надо ли?
// todo Refactor to FileManagerService
@Slf4j
public class AttachmentService {

//    @Value("${upload.path}")
//    private String path;

    private final Path filesStoragePath = Paths.get("files");

    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BlogService blogService;

    @Override
    public void initService() {
        //todo Проверка есть ли папка на компе если нет создать, обработать исключения, добавить код в главный клас чтобы при запуске отрабатывал
        try {
            Files.createDirectories(filesStoragePath);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public File saveFile(MultipartFile file, Principal principal, String tag) throws IOException {

        User userFromDb = userRepository.findByUsername(principal.getName()).get();

        String fileName = tag + "_" + userFromDb.getId() + "_" + UUID.randomUUID().toString() + ".png";
        Path filepath = Paths.get(filesStoragePath.toString(), fileName );
        file.transferTo(filepath);

        return new File(filepath.toUri());
    }


    public File deleteFile(MultipartFile file, Principal principal, String tag) throws IOException {

        return null;
    }

    @Override
    public void resizeImage(File originalImage, File resizedImage, int width, int height, String format){
        try {
            BufferedImage original = ImageIO.read(originalImage);
            BufferedImage resized = new BufferedImage(width, height, original.getType() );
            Graphics2D g2 = resized.createGraphics();
            g2.drawImage(original, 0, 0, width, height, null );
            g2.dispose();
            ImageIO.write(resized, format,resizedImage);
        }
        catch (IOException ex) {
            System.out.println("err"); //todo Обработать ошибку красиво
        }
    }


    @Override
    public Attachment addAttachment(String originalFilename, String contentType, File saveFile, Principal principal) throws IOException {

        User userFromDb = userRepository.findByUsername(principal.getName()).get();

        // todo COMPLETE! применить шаблон билдер ломбока, два раза вызываю юзераизбд править
     /*   Attachment attachment1 = new Attachment(
                originalFilename,
                Instant.now(),
                contentType,
                "/files/" + saveFile.getName(),
                userFromDb);*/
        Attachment attachment = Attachment.builder()
                .attachTitle(originalFilename)
                .uploadDate(Instant.now())
                .extension(contentType)
                .downloadLink("/files/" + saveFile.getName())
                .author(userFromDb)
                .build();

        attachmentRepository.save(attachment);

        return attachment;
    }


    @Override
    public Attachment findAttachById(Long attachId) {
        return  attachmentRepository.findById(attachId).orElseThrow();

    }

    // todo До конца не понята логика
    @Override
    public Resource loadFileAsResource(String fileName) throws MalformedURLException {
        Path fileStorageLocation = filesStoragePath.toAbsolutePath().normalize();
        log.info(fileStorageLocation.toString());
        Path filePath = fileStorageLocation.resolve(fileName).normalize();
        return new UrlResource(filePath.toUri());
    }





}


enum FileExtensions {
    PDF, TORRENT, PIC, jpg
}

