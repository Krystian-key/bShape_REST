package com.rest.bshape.user.impl;


import com.rest.bshape.user.UserRepository;
import com.rest.bshape.user.UserService;
import com.rest.bshape.user.domain.User;
import com.rest.bshape.user.domain.UserID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

    // Klasy wyzszego rzedu musza korzystac z abstrakcji wyzszego, Stowrzyc interfejs o nazwie user service z
    // Naglowkami i klase w pakiecie IMPL ktora implementuje ten service. SOLID w controlerze uzywam interfejsu a nie jego implementacji
    // w controlerze robie logie ktora powinna znalexc sie w serwisie
    // powininem stworzyc Edvice Controller oznaczone adnotacja AdviceController i tam metody oznaczone adnotacjami exception handler i tam zwracac statusy.

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();

    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id :" + id));
    }

    @Override
    public UserID create(User user) {
        user = userRepository.save(user);
        return new UserID(user.getId());
    }


    @Override
    public User update(User user, Long id) {

        return userRepository.save(findById(id)
                .toBuilder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .weight(user.getWeight())
                .height(user.getHeight())
                .sex(user.getSex())
                .password(user.getPassword())
                .email(user.getEmail())
                .build());
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }

}
