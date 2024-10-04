package com.formation.dao;

import com.formation.entity.FileInfo;
import com.formation.entity.FileInfo.FileInfoBuilder;
import com.formation.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {

    FileInfoBuilder save(FileInfoBuilder fileInfo);

    List<FileInfo> findByUtilisateur(Utilisateur utilisateur);




}
