package com.akoca.mvc.controller.test;

import com.akoca.mvc.domain.test.OrganizationRepresentative;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/formValidation")
public class FormValidationController {

    private static Logger LOGGER = LoggerFactory.getLogger(FormValidationController.class);

    @RequestMapping("/home")
    public ModelAndView home(Model model) {
        return new ModelAndView("test/formValidationViews/formValidationHome" , "organizationRepresentative" , new OrganizationRepresentative());
    }

    @RequestMapping(value = "/registerOrganizationRepresentative" , method = RequestMethod.POST)
    public String organizationRepresentativeRegistration(
            @Valid @ModelAttribute("organizationRepresentative") OrganizationRepresentative organizationRepresentative ,
            BindingResult bindingResult ,
            Model model) {

        if(bindingResult.hasErrors()) {
            model.addAttribute("formErrors" , bindingResult.getAllErrors());
            List<FieldError> fieldErrorsList = bindingResult.getFieldErrors();

            for(FieldError fieldError : fieldErrorsList) {
                LOGGER.info("Field Error: " + fieldError.getDefaultMessage());
            }

            List<ObjectError> globalErrorsList = bindingResult.getGlobalErrors();

            for(ObjectError objectError : globalErrorsList) {
                LOGGER.info("Global error: " + objectError.getDefaultMessage());
            }

            return "test/formValidationViews/formValidationHome";
        } else {
            return "test/formValidationViews/formValidationResult";
        }
    }
}
