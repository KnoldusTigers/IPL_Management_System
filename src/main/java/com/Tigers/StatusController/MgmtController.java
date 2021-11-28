package com.Tigers.StatusController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




   @Controller
   public class MgmtController {

        @RequestMapping("/status")
        public String getP_name() {

            return "/status";
        }

       @GetMapping("/Matches")
       public String getMatches() {
           return "/Matches";
       }

   }
