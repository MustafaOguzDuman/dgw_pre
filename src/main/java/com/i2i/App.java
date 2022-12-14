package com.i2i;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class App 
{
    public static final Logger logger = LogManager.getLogger(App.class);
    public static void main( String[] args ) {
        //BasicConfigurator.configure();

        MSISDNGenerator msisdnGenerator = new MSISDNGenerator();
        LocationGenerator locationGenerator = new LocationGenerator();
        ServiceGenerator serviceGenerator = new ServiceGenerator();
        AmountGenerator amountGenerator = new AmountGenerator();
        Random rand = new Random();
        while(true) {
            if(rand.nextInt()%5!=0){ //randomly select 1 of 5 cycles
                continue;
            }
            String msisdn = msisdnGenerator.getMsisdn();
            String location = locationGenerator.getLocation();
            String service = serviceGenerator.getService();
            int amount = amountGenerator.getAmount(service);
            logger.info("MSISDN: " + msisdn);
            logger.warn("Location: " + location);
            logger.error("Service: " + service);
            logger.fatal("Amount: " + amount);
        }
    }
}
