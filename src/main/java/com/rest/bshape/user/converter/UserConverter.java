package com.rest.bshape.user.converter;



import com.rest.bshape.user.domain.User;
import com.rest.bshape.user.domain.UserDTO;

import java.util.List;
import java.util.stream.Collectors;


public class UserConverter {


    public static UserDTO convertToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .weight(user.getWeight())
                .height(user.getWeight())
                .sex(user.getSex())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    }

    public static User convertFromDTO(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .age(userDTO.getAge())
                .weight(userDTO.getWeight())
                .height(userDTO.getWeight())
                .sex(userDTO.getSex())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .build();
    }

    // zmapowalem BodyTYpe na liste BodyTYpeDto zeby latwiej wykorzystywac solid, Single resposibility converter do mapowania, controler to fasada z opakowującymi metodami
    public static List<UserDTO> mapToListDto(List<User> userList){
        return userList.stream()
                .map(UserConverter::convertToDTO)
                .collect(Collectors.toList());
    }


}
