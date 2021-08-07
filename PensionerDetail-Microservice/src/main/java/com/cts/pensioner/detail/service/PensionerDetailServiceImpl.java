package com.cts.pensioner.detail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pensioner.detail.exception.AadharNumberNotFound;
import com.cts.pensioner.detail.feignclient.AuthorisingClient;
import com.cts.pensioner.detail.model.PensionerDetail;
import com.cts.pensioner.detail.repository.PensionerDetailRepository;
import com.cts.pensioner.detail.repository.PensionerDetailRepo;


@Service
public class PensionerDetailServiceImpl implements PensionerDetailRepo {

	@Autowired
	private PensionerDetailRepository pensionerDetailRepository;
	
	@Override
	public PensionerDetail getPensionerDetailByAadharCard(String token,long aadharNumber ,AuthorisingClient authorisingClient) 
	{
		 
		try {
			if (authorisingClient.authorizeTheRequest(token))
		
		return pensionerDetailRepository.findById(aadharNumber).orElseThrow(()-> new AadharNumberNotFound("Aadhar Card Number is not Valid. Please check it and try again"));		
			else
				 return null;
		}
		catch(Exception e) {
			return null;
		}
		
		
		}
	
	public List<PensionerDetail> getAllPensioner(String token,AuthorisingClient authorisingClient)
	{
		try {if (authorisingClient.authorizeTheRequest(token))
		{
		
		return pensionerDetailRepository.findAll();
	}
		
		else return null;
		}
		catch(Exception e) {
			return null;
		}
		}
	
}
