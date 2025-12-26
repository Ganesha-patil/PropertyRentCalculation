package org.techhub.repository;

import org.techhub.model.AdminLogin;

public interface ValidateAdminRepository {

	public boolean validateAdminLogin(AdminLogin al);
}
