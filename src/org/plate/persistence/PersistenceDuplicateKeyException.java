package org.plate.persistence;

public class PersistenceDuplicateKeyException extends PersistenceRuntimeException {

	private static final long serialVersionUID = 9061688259667888231L;

	public PersistenceDuplicateKeyException(String message) {
		super(message);
	}

}
