package com.example.eindopdracht.user;

import com.example.eindopdracht.exceptions.RecordNotFoundException;
import com.example.eindopdracht.role.Role;
import com.example.eindopdracht.role.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepos;

    private final PasswordEncoder encoder;
    private final RoleRepository roleRepos;


    public String createUser(UserDto userDto) {
        User newUser = new User();
        newUser.setEmail(userDto.email);
        newUser.setFirstName(userDto.firstName);
        newUser.setLastName(userDto.lastName);
        newUser.setPassword(encoder.encode(userDto.password));
        Set<Role> userRoles = newUser.getRoles();
        for (String rolename : userDto.roles) {
            Optional<Role> or = roleRepos.findById("ROLE_" + rolename);
            if (or.isPresent()) {
                userRoles.add(or.get());
            }
        }
        userRepos.save(newUser);
        return "gebruiker aangemaakt";
    }

    public List<UserDto> userListToDtoList(List<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = userToDto(user);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }


    public UserDto userToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.email = user.getEmail();
        userDto.firstName = user.getFirstName();
        userDto.lastName = user.getLastName();
        return userDto;
    }

    public void deleteUser(Long id) {
     if (userRepos.findById(id).isEmpty()) {
            throw new RecordNotFoundException("geen gebruiker gevonden");
        }else {
            userRepos.deleteById(id);        }
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepos.findById(id).orElseThrow(() -> new RecordNotFoundException("geen gebruikers gevonden"));
        user.setFirstName(userDto.firstName);
        user.setLastName(userDto.lastName);
        userRepos.save(user);
        return userDto;
    }

    public List<UserDto> getUsers() {
        List<User> users = userRepos.findAll();
        return userListToDtoList(users);
    }

    public User getUser(Long id) {
        return userRepos.findById(id).orElseThrow(() -> new RecordNotFoundException("geen gebruiker gevonden"));
    }

}