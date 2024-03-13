package com.joalvarez.examplegraphql.validation;

import com.joalvarez.examplegraphql.data.dao.UserDAO;
import com.joalvarez.examplegraphql.data.model.User;
import com.joalvarez.examplegraphql.data.repository.UserRepository;
import com.joalvarez.examplegraphql.validation.general.GenericValidation;
import com.joalvarez.examplegraphql.validation.interfaces.ExistsByUsernameOrEmail;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class ExistsByUsernameOrEmailValidation extends GenericValidation<ExistsByUsernameOrEmail, String, UserRepository, User, Long, UserDAO> {

	public ExistsByUsernameOrEmailValidation(UserDAO dao) {
		super(dao);
	}

	@Override
	public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
		return !this.dao.existsUsernameOrEmail(s, s);
	}
}
