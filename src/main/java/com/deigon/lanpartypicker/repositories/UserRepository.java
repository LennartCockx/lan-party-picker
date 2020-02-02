package com.deigon.lanpartypicker.repositories;

import com.deigon.lanpartypicker.domain.LanPartyUser;

import java.util.UUID;

public interface UserRepository {

    LanPartyUser getById(UUID id);

    LanPartyUser getByUsername(String username);
}
