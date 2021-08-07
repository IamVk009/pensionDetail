package com.cts.pensioner.detail.repository;

import com.cts.pensioner.detail.exception.AadharNumberNotFound;
import com.cts.pensioner.detail.feignclient.AuthorisingClient;
import com.cts.pensioner.detail.model.PensionerDetail;

public interface PensionerDetailRepo {
	
	public PensionerDetail getPensionerDetailByAadharCard(String token,long aadharNumber ,AuthorisingClient authorisingClient) ;

}
