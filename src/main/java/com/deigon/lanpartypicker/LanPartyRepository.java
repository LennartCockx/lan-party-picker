package com.deigon.lanpartypicker;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LanPartyRepository {
    public List<LanParty> getAllLanParties(){
        LanParty sampleParty1 = new LanParty();
        sampleParty1.setName("Old Year Mini-LAN");
        sampleParty1.setDescription("Three people, Three games. A short LAN Party to end 2019");
        LanParty sampleParty2 = new LanParty();
        sampleParty2.setName("I-Got-A-New-Gaming-PC LAN");
        sampleParty2.setDescription("Time to play some games with this beast. Februari 2020");

        return List.of(sampleParty1, sampleParty2);
    }
}
