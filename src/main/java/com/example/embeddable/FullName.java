package com.example.embeddable;

import com.example.domain.FirstName;
import com.example.domain.LastName;
import org.seasar.doma.Embeddable;

@Embeddable
public class FullName {

    private final FirstName firstName;
    private final LastName lastName;

    public FullName(final FirstName firstName, final LastName lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public FirstName getFirstName(){
        return this.firstName;
    }

    public LastName getLastName(){
        return this.lastName;
    }

}
