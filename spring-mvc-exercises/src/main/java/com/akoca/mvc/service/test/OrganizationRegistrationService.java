package com.akoca.mvc.service.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class OrganizationRegistrationService {

    @Value("#{serviceLengthOptions}")
    private Map<String , String> serviceLengthList;

    public Map<String , String> populateTurnover() {
        Map<String , String> turnover = new LinkedHashMap<>();

        turnover.put("none" , "select");
        turnover.put("1000" , "<1000");
        turnover.put("10000" , "1000 < < 10000");
        turnover.put("100000" , "10000 < < 100000");

        return turnover;
    }

    public Map<String , String> populateTypes() {
        Map<String , String> types = new LinkedHashMap<>();

        types.put("gov" , "<Government");
        types.put("semigov" , "SemiGovernment");
        types.put("private" , "Private");

        return types;
    }

    public Map<String , String> populateServiceLengths() {

        return new TreeMap<String , String>(serviceLengthList);
    }

    public Map<String , String> populateRegisteredPreviously() {
        Map<String , String> registeredPreviously = new LinkedHashMap<>();

        registeredPreviously.put("true" , "yes");
        registeredPreviously.put("false" , "no");

        return registeredPreviously;
    }

    public Map<String , String> populateOptionalServices() {
        Map<String , String> optionalServices = new LinkedHashMap<>();

        optionalServices.put("emailService" , "Mailing List");
        optionalServices.put("promotionalService" , "Promotional Services");
        optionalServices.put("newsLetterService" , "Weekly NewsLetter");

        return optionalServices;
    }

    public Map<String , String> populatePremiumServices() {
        Map<String , String> premiumServices = new LinkedHashMap<>();

        premiumServices.put("directoryService" , "Directory");
        premiumServices.put("revenueReportService" , "Revenue Report");
        premiumServices.put("revenueAnalyticsService" , "Revenue Analytics");

        return premiumServices;
    }

    public Map<String , String> populateEmployeeStrength() {
        Map<String , String> employeeStrength = new LinkedHashMap<>();

        employeeStrength.put("small" , "< 100");
        employeeStrength.put("medium" , "100 < < 1000");
        employeeStrength.put("large" , "1000 < ");

        return employeeStrength;
    }
}
