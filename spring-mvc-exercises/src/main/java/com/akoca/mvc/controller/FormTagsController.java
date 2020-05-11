package com.akoca.mvc.controller;

import com.akoca.mvc.domain.test.OrganizationRegistration;
import com.akoca.mvc.service.test.OrganizationRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/formTags")
public class FormTagsController {

    @Autowired
    private OrganizationRegistrationService organizationRegistrationService;

    @RequestMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("test/formTagsTestViews/formTagsHome" , "orgRegistration" , new OrganizationRegistration());
    }

    @RequestMapping("/registerOrg")
    public String registerOrganization(@ModelAttribute("orgRegistration") OrganizationRegistration organizationRegistration ,
                                       Model model) {

        model.addAttribute("registeredOrganization" , organizationRegistration);

        return "test/formTagsTestViews/formTagsResult";
    }

    @ModelAttribute
    public void populateFormObjectWithData(Model model) {
        Map<String , Object> map = model.asMap();
        map.put("turnoverList" , organizationRegistrationService.populateTurnover());
        map.put("typeList" , organizationRegistrationService.populateTypes());
        map.put("serviceLengthList" , organizationRegistrationService.populateServiceLengths());
        map.put("registeredPreviouslyList" , organizationRegistrationService.populateRegisteredPreviously());
        map.put("subscriptionList" , organizationRegistrationService.populateOptionalServices());
        map.put("premiumServiceList" , organizationRegistrationService.populatePremiumServices());
        map.put("employeeStrengthList" , organizationRegistrationService.populateEmployeeStrength());
    }
}
