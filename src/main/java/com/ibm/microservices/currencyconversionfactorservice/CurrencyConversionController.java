package com.ibm.microservices.currencyconversionfactorservice;

import java.net.URI;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@RestController
public class CurrencyConversionController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public CurrencyFactorRepository repo;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/CrncyFctr/FrmCrncy/{fromCtry}/ToCrncy/{toCtry}")
	public CurrencyFactor retrieveConversionfactor(@PathVariable String fromCtry,@PathVariable String toCtry) {
		
		CurrencyFactor currencyFactor = repo.findByFromCtryAndToCtry(fromCtry, toCtry);
		currencyFactor.setPort(environment.getProperty("local.server.port"));
		logger.info("CurrencyFactor "+currencyFactor.toString());
		return currencyFactor;
	
	}
	
	@GetMapping("/CrncyFctr/{id}")
	public CurrencyFactor retrieveConversionfactorById(@PathVariable Long id) {
		
		Optional<CurrencyFactor> optionalCf = repo.findById(id);
		CurrencyFactor cf = optionalCf.get();
		if(!optionalCf.isPresent())
			throw new CurrencyFactorNotFoundException("NOt Found id ---> "+id);
		logger.info("In retrieveConversionfactorById CurrencyFactor "+cf.toString());
		return cf;
	
	}
		
	@PutMapping("/CrncyFctr/{id}")
	public ResponseEntity<Object> updateConversionFactor(@RequestBody CurrencyFactor currencyFactor)
	{
		//Optional<CurrencyFactor> OptcurrencyFactor = repo.findById(id);
			CurrencyFactor savedCurrencyFactor = repo.save(currencyFactor);
			logger.info("In updateConversionFactor CurrencyFactor "+savedCurrencyFactor.toString());
			return ResponseEntity.ok(savedCurrencyFactor);
		
	}
	
	
	@PostMapping("/CrncyFctr")
	public ResponseEntity<Object> addConversionFactor(@RequestBody CurrencyFactor currencyFactor)
	{
		
		CurrencyFactor savedCurrencyFactor = repo.save(currencyFactor);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCurrencyFactor.getId()).toUri();
		logger.info("In addConversionFactor "+location.toString());
		return ResponseEntity.created(location).build();
	}
	
	
}
	
