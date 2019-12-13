package com.ibm.microservices.currencyconversionfactorservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyFactorRepository extends JpaRepository<CurrencyFactor, Long> {
	
	CurrencyFactor findByFromCtryAndToCtry(String fromCtry,String toCtry);

}
