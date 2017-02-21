package com.AdvanceSpringBootApp.web.domain.frontend;

import javassist.SerialVersionUID;

import java.io.Serializable;

/**
 * Created by user on 21-Feb-17.
 */
public class FeedBackPojo implements Serializable {

    private static final long serialVersionUID = 1l;

    private String email;
    private String firstName;
    private String lastName;
    private String feedback;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FeedBackPojo{");
        sb.append("email='").append(email).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", feedback='").append(feedback).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
