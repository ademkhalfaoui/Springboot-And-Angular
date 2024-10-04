package com.formation.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.UtilisateurRepository;
import com.formation.entity.Utilisateur;
@Service
public class UserDeatilsServiceImpl implements UserDetailsService{

	
	@Autowired
	private UtilisateurRepository  utilisateurRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Utilisateur user= utilisateurRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException("user not found "+username)
				);
				
		return UserPrincipale.build(user);
	}

}
