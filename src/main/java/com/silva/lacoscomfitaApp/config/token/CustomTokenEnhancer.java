package com.silva.lacoscomfitaApp.config.token;



import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
//		CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
//
//		Map<String, Object> addInfo = new HashMap<>();
//		addInfo.put("name", currentUser.getUserDTO().getName());
//		addInfo.put("id", currentUser.getUserDTO().getId());
//
//		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addInfo);
//		return accessToken;

		return  null;
	}

}
