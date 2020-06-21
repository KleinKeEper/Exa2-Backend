package com.klein.exa.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.klein.exa.dao.UsuarioDao;
import com.klein.exa.entity.Usuario;
import com.klein.exa.service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService, UserDetailsService{

	private Logger logger = LoggerFactory.getLogger(UsuarioServiceImp.class);
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Usuario usuario = usuarioDao.findByUsername(username);
		
		if (usuario == null) {
			logger.error(" Error en el login: no existe el " + usuario + " en el sistema ");
			throw new UsernameNotFoundException(" Error en el login: no existe el " + usuario + "en el sistema ");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles().stream().map( rol -> new SimpleGrantedAuthority( rol.getNombreRol())).peek(authority -> logger.info("Rol" + authority.getAuthority())).collect(Collectors.toList());
		
		return new User( usuario.getUsername(), usuario.getPassword(), usuario.isEstado(), true , true , true, authorities);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		// TODO Auto-generated method stub
		return usuarioDao.findByUsername(username);
	}

}
