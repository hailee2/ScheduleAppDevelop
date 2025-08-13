package org.example.scheduleappdevelop.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.scheduleappdevelop.common.entity.BaseEntity;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true, nullable=false)
    private String email;
    private String password;

    public User(String name, String email ) {
        this.name = name;
        this.email = email;
    }

    public void userUpdate(String name, String email){
        this.name = name;
        this.email = email;
    }
}
