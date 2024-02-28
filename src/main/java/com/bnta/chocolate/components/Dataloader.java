package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements ApplicationRunner {

    @Autowired
    ChocolateService chocolateService;

    @Autowired
    EstateService estateService;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        Estate estate1 = new Estate("Harun", "Afghanistan");
        Estate estate2 = new Estate("Karen", "China");

        Chocolate chocolate1 = new Chocolate("Cadbury", 60, estate1 );
        Chocolate chocolate2 = new Chocolate("Mars", 50, estate2);

        chocolateService.saveChocolate(chocolate1);
        chocolateService.saveChocolate(chocolate2);

        estateService.saveEstate(estate1);
        estateService.saveEstate(estate2);

    }

}
