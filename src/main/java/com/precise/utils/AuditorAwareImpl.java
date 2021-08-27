package com.precise.utils;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import com.precise.models.entities.User;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return Optional.of(currentUser.getEmail());
	}

}
