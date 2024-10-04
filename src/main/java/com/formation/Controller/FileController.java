package com.formation.Controller;

import com.formation.dao.FileInfoRepository;
import com.formation.dao.UtilisateurRepository;
import com.formation.entity.FileInfo;
import com.formation.entity.Utilisateur;
import com.formation.security.jwt.JwtAuthTokenFilter;
import com.formation.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class FileController {
    /*
     * @Autowired FileStorageService storageService;
     *
     * @GetMapping("/files/new") public String newFile(Model model) { return
     * "upload_form"; }
     *
     * @PostMapping( value = "/files/upload" ,consumes =
     * MediaType.MULTIPART_FORM_DATA_VALUE ) public FileInfo
     * uploadFiles( @RequestPart("files") MultipartFile files ,@RequestBody FileInfo
     * fileInfo ) {
     *
     * try {
     *
     * fileInfo.setData(files.getBytes());
     * fileInfo.setContent(files.getContentType());
     * fileInfo.setTaille(files.getSize());
     * fileInfo.setNom_fichier(files.getOriginalFilename());
     *
     * return storageService.UploadFile(fileInfo); } catch (IOException e) { // TODO
     * Auto-generated catch block e.printStackTrace();
     *
     * return null ; }
     *
     *
     * }
     */

    /*
     *
     * private FileStorageService fileStorageService;
     *
     * public FileController(FileStorageService fileStorageService) {
     * this.fileStorageService = fileStorageService; }
     *
     * @PostMapping("/storefile") public ResponseEntity<String>
     * storeFileIntoDB(@RequestParam("file") MultipartFile file) throws IOException{
     * String response =fileStorageService.StorageFile(file);
     *
     * return ResponseEntity.status(HttpStatus.OK).body(response); }
     *
     * @GetMapping("/getfileByName/{filename}") public ResponseEntity<byte[]>
     * getfile(@PathVariable String filename){ byte[] Data
     * =fileStorageService.getFileInfo(filename); }
     */


    @Autowired
    private FileInfoRepository fileInfoRepository;
    @Autowired
    private FormationService formationService;
    @Autowired
    private JwtAuthTokenFilter jwt;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @PostMapping("/upload")
    public ResponseEntity<FileInfo> CreateNewFile(@RequestParam String nom_fichier, @RequestPart("file") MultipartFile file, @RequestParam String nom_formateur, @RequestParam String code_cours, @AuthenticationPrincipal UserDetails user) {
        /* System.out.println(jwt.getUserDetails().getUsername()); */
        var utilisateur = getUtilisateur(user);
        FileInfo fileInfo;
        try {
            fileInfo = FileInfo.builder()
                    .nom_fichier(nom_fichier)
                    .utilisateur(utilisateur)
                    .code_cours(code_cours)
                    .data(file.getBytes())
                    .build();
            fileInfoRepository.save(fileInfo);
            fileInfo.setData(null);
            return ResponseEntity.ok(fileInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;

        }

    }

    private Utilisateur getUtilisateur(UserDetails user) {
        String principal =
                SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        System.out.println(principal + "abcd" + user.getUsername());
        var utilisateur = utilisateurRepository.findByUsername(user.getUsername()).orElseThrow();
        return utilisateur;
    }
    
    private Utilisateur getUtilisateurByid(Long id) {
        
        var utilisateur = utilisateurRepository.findById(id).orElseThrow();
        return utilisateur;
    }
    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) {
        // Récupérer votre fichier en fonction de l'ID
        FileInfo file = fileInfoRepository.findById(fileId).orElseThrow(RuntimeException::new);

        return ResponseEntity.ok()
                .contentType((MediaType.MULTIPART_FORM_DATA))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getNom_fichier() + "\"")
                .body(new InputStreamResource(new ByteArrayInputStream(file.getData())));
    }

    @GetMapping("/filesformateurs")
    public List<FileInfo> getAllFiles(@AuthenticationPrincipal UserDetails user) {
        var utilisateur = getUtilisateur(user);
        return fileInfoRepository.findByUtilisateur(utilisateur);
    }
    @GetMapping("/touslesfiles")
    public List<FileInfo> getAllfiles(){
    	return fileInfoRepository.findAll();
    }
    @GetMapping("/filesparformateur")
    public List<FileInfo> getAllfilesByformateur(@RequestParam Long id_utilisateur){
    	  var utilisateur = getUtilisateurByid(id_utilisateur);
          return fileInfoRepository.findByUtilisateur(utilisateur);
    }
    

    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getallFile() {
        List<FileInfo> fileList = fileList = fileInfoRepository.findAll();
        try {
            fileList = fileInfoRepository.findAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResponseEntity.ok(fileList);
    }

    @DeleteMapping("/filedetails/delete/{id}")
    public String deletefile(@PathVariable(value = "id") Long id) {
        return formationService.deletefile(id);
    }

}
