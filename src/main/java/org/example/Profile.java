package org.example;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Profile {
    private String name;
    private String surname;
    private String login;
    private String password;
}