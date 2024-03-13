package com.joalvarez.examplegraphql.data.model.generals;

import java.util.UUID;

public abstract class MultitenantEntity {

	public abstract UUID getUserId();
	public abstract void setUserId(UUID userId);
}
