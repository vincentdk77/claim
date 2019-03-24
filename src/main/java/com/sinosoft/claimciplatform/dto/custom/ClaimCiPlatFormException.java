package com.sinosoft.claimciplatform.dto.custom;

public class ClaimCiPlatFormException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClaimCiPlatFormException(String message) {
		super(message);
	}
	
	public ClaimCiPlatFormException(){
		super();
	}
	
    public ClaimCiPlatFormException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ClaimCiPlatFormException(Throwable cause) {
        super(cause);
    }
}
