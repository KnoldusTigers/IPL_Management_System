package com.service;


import com.dao.MatchRepo;
import com.model.MatchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


/**
 * The type Match service.
 */
@Service
public class MatchService {
    @Autowired
    private MatchRepo matchRepo;

    /**
     * Gets all matches.
     *
     * @return the all matches
     */
    public List<MatchModel> getAllMatches() {
//        System.out.println(getPlayers());

        return (List<MatchModel>) matchRepo.findAll();
    }

    /**
     * Save.
     *
     * @param match_model the match model
     */
    public void save(final MatchModel match_model) {

        matchRepo.save(match_model);
    }

    /**
     * Get match model.
     *
     * @param Id the id
     * @return the match model
     */
    public MatchModel get(int Id) {

        return matchRepo.findById(Id).get();
    }


    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(int id) {

        matchRepo.deleteById(id);
    }
//public boolean cehckVenue(String schduledate, String venue){
//
//        for(int i=0;i<3;i++){
//            MatchModel matchModelVenue=matchRepo.findByVenue(venue).get();
//            MatchModel matchModelDate=matchRepo.findByScheduledate(schduledate).get();
//            if(matchModelVenue==null || matchModelDate==null){
//                return false;
//            }
//             if(matchModelVenue.getMatchid()==matchModelDate.getMatchid()){
//    System.out.println("=-==============----------------================="+i);
//    return true;
//              }
//        }
//
//    return false;
//}
//
//    @Transactional
//    public Optional<MatchModel> findVenueIsExist (String venue) {
//        return matchRepo.findByVenue(venue);
//    }
//    public boolean venueExists (String venue,BindingResult result) {
//        try {
//            return findVenueIsExist(venue).isPresent();
//        }
//        catch (Exception e) {
//            result.addError(new FieldError("match", "scheduledate", "date or venue already exist"));
//        }
//        return false;
//    }

    /**
     * Find date is exist optional.
     *
     * @param date the date
     * @return the optional
     */
    @Transactional
    public Optional<MatchModel> findDateIsExist (String date){
        Optional<MatchModel> matchModeldate= matchRepo.findByScheduledate(date);

        return matchModeldate;
    }

    /**
     * Date is exist boolean.
     *
     * @param date the date
     * @return the boolean
     */
    public boolean DateIsExist (String date){
        Optional<MatchModel> matchModeldate= findDateIsExist(date);
        if(matchModeldate.isPresent()){
            String dates= matchModeldate.get().getScheduledate();
            String  D = dates.substring(0, 10);
            System.out.println(D);
            if(matchModeldate.get().getScheduledate().contains(D))
                return  true;

        }

        return false;
    }


}
