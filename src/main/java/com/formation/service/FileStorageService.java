package com.formation.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.formation.dao.FileInfoRepository;
import com.formation.dao.FormateurRepository;
import com.formation.entity.FileInfo;
import com.formation.entity.FileInfo.FileInfoBuilder;
import com.formation.entity.Formateur;

@Service
public class FileStorageService {
	
	/*
	 * @Autowired private FormateurRepository formateurRepository;
	 * 
	 * @Autowired private FileInfoRepository fileInfoRepository1 ;
	 * 
	 * public List<FileInfo> listfile(){ return fileInfoRepository1.findAll();
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public FileInfo UploadFile(FileInfo fileInfo )throws IOException {
	 * 
	 * FileInfo document= new FileInfo(); Formateur formateur =
	 * 
	 * document.setNom_fichier(fileInfo.getNom_fichier());
	 * document.setTaille(fileInfo.getTaille()); document.setDate(new Date());
	 * document.setData(fileInfo.getData());
	 * 
	 * 
	 * return fileInfoRepository1.save(document); }
	 */
	 
	@Autowired
	private FileInfoRepository fileInfoRepository; 
	
	
	public String StorageFile(MultipartFile file )throws IOException{
		
      
		FileInfoBuilder fileInfo =FileInfo
					.builder()
				.nom_fichier(file.getOriginalFilename())
				
				.data(file.getBytes());
		fileInfo=fileInfoRepository.save(fileInfo);
		
		if(fileInfo.getClass()!=null) {
			return "File uplaoded succesfuly into database";
		}else {
			return "Failed to upload file into database";
		}
		
	}


	public byte[] getFileInfo(String filename) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
	
	
}
