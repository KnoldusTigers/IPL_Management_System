package com.service;


import com.dao.MatchRepo;
import com.model.MatchModel;
import com.model.PlayersModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Service
public class MatchService {
    @Autowired
    private MatchRepo matchRepo;

    public List<MatchModel> getAllMatches() {
//        System.out.println(getPlayers());

        return (List<MatchModel>) matchRepo.findAll();
    }

    public void save(final MatchModel match_model) {

        matchRepo.save(match_model);
    }
    public MatchModel get(int Id) {

        return matchRepo.findById(Id).get();
    }


    public void delete(int id) {

        matchRepo.deleteById(id);
    }



    @Transactional
    public Optional<MatchModel> findVenueIsExist (String venue) {

        return matchRepo.findByVenue(venue);

    }
    public boolean venueExists (String venue,BindingResult result) {
        try {
            return findVenueIsExist(venue).isPresent();


        } catch (Exception e) {
            result.addError(new FieldError("match", "scheduledate", "date or venue already exist"));
        }
        return true;
    }

    @Transactional
    public Optional<MatchModel> findDateIsExist (String date){
        return matchRepo.findByScheduledate(date);
    }
    public boolean DateIsExist (String date){
        return findDateIsExist(date).isPresent();
    }


}
