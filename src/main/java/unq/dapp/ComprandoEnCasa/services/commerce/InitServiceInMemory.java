package unq.dapp.ComprandoEnCasa.services.commerce;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import unq.dapp.ComprandoEnCasa.model.domain.commerce.AttentionSchedule;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.PayMethods;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Sector;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class InitServiceInMemory {

	@Autowired
	private CommerceService commerceService;

	@PostConstruct
	public void initialize() {
			fireInitialData();
		}


	private void fireInitialData() {
		//Commerce1
		Sector sector =(Sector.FARMACY);
		String address = "Av.Callo 110";
		List<PayMethods> payMethods = new ArrayList<PayMethods>();
		payMethods.add(PayMethods.CASH);
		Integer maxDistance = 100 ;
		AttentionSchedule attentionSchedule = new AttentionSchedule();
		Commerce commerce = new Commerce(sector, address, payMethods,maxDistance, attentionSchedule);

		//Commerce2
		Sector sector2 =(Sector.FOOD);
		String address2 = "Av.Mitre 550";
		List<PayMethods> payMethods2 = new ArrayList<PayMethods>();
		payMethods2.add(PayMethods.CREDIT_CARD);
		payMethods2.add(PayMethods.CASH);
		Integer maxDistance2 = 300;
		AttentionSchedule attentionSchedule2 = new AttentionSchedule();
		Commerce commerce2 = new Commerce(sector2, address2, payMethods2,maxDistance2, attentionSchedule2);

		//Add commerce

		commerceService.save(commerce);
		commerceService.save(commerce2);


	}
}
