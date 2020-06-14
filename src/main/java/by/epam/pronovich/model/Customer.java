package by.epam.pronovich.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer {

    private Integer id;
    private String login;
    private String email;
    private String name;
    private String lastName;
    private Role role;
    private Integer phoneNumber;
    private String address;


}
