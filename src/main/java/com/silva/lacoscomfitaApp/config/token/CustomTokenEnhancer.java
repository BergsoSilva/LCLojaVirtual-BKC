package com.silva.lacoscomfitaApp.config.token;



import com.silva.lacoscomfitaApp.security.UsuarioCorrente;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		UsuarioCorrente usuarioCorrente = (UsuarioCorrente) authentication.getPrincipal();

		Map<String, Object> addInfo = new HashMap<>();
		addInfo.put("name", usuarioCorrente.getUsuario().getNome());
		addInfo.put("id", usuarioCorrente.getUsuario().getId());

		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addInfo);
		return accessToken;
	}

}
