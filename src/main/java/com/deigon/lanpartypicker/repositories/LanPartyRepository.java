package com.deigon.lanpartypicker.repositories;

import com.deigon.lanpartypicker.domain.LanParty;
import com.deigon.lanpartypicker.domain.LanPartyBuilder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class LanPartyRepository {
    public List<LanParty> getAllLanParties(){
        LanParty sampleParty1 = LanPartyBuilder.createLanParty().withName("Old Year Mini-LAN").withDescription("Three people, Three games. A short LAN Party to end 2019").build();
        LanParty sampleParty2 = LanPartyBuilder.createLanParty().withName("I-Got-A-New-Gaming-PC LAN").withDescription("Time to play some games with this beast. Februari 2020").build();

        return List.of(sampleParty1, sampleParty2);
    }

    public LanParty getLanPartyByUUID(UUID uuid) {
        if (uuid.equals(UUID.fromString("b199ae66-f554-4726-ad04-b7f7caa1c959"))){
            return LanPartyBuilder.createLanParty()
                    .withUuid(UUID.fromString("b199ae66-f554-4726-ad04-b7f7caa1c959"))
                    .withName("Old Year Mini-LAN")
                    .withDescription("Three people, Three games. A short LAN Party to end 2019")
                    .build();
        } else if (uuid.equals(UUID.fromString("a0a3c168-436c-4394-8f1a-32af10fdcc72"))){
            return LanPartyBuilder.createLanParty()
                    .withUuid(UUID.fromString("a0a3c168-436c-4394-8f1a-32af10fdcc72"))
                    .withName("I-Got-A-New-Gaming-PC LAN")
                    .withDescription("Time to play some games with this beast. Februari 2020")
                    .build();
        } else {
            return null;
        }
    }
}
