package com.learn.mybatis;

import org.apache.commons.lang3.RandomStringUtils;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.api.Randomizer;

import java.util.Random;

import static java.nio.charset.Charset.forName;

public class DataFaker {

    static EasyRandomParameters parameters = new EasyRandomParameters()
            .seed(123L)
            .objectPoolSize(100)
            .randomizationDepth(3)
            .charset(forName("UTF-8"))
            .stringLengthRange(5, 50)
            .collectionSizeRange(1, 10)
            .scanClasspathForConcreteTypes(true)
            .overrideDefaultInitialization(false)
            .ignoreRandomizationErrors(true);

    public static EasyRandom easyRandom = new EasyRandom(parameters);

    public static class EmailRandomizer implements Randomizer<String> {
        public String getRandomValue() {
            // generate a random alphanumeric string of length 10 for the username part of the email address
            String username = RandomStringUtils
                    .randomAlphanumeric(10);
            // generate a random top-level domain from a list of popular ones
            String[] tlds = {"com", "net", "org", "gov", "edu"};
            String tld = tlds[new Random().nextInt(tlds.length)];
            // return the random email address
            return username + "@" + tld;
        }
    }
}
