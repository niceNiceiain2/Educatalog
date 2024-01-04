package edu.utsa.cs3443.educatalog.model;

import java.util.ArrayList;

public class AccountUser {
        String userName;
        String password;
        String firstName;
        String lastName;
        String employeeID;

        /*
         * Returns the first name of user.
         * @return A string of the first name of user.
         */
        public String getFirstName() {
            return firstName;
        }

        /*
         * Sets the first name of the user.
         * @param name the User name.
         */
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        /*
         * Returns the last name of the user name.
         * @return The last name of the user.
         */
        public String getLastName() {
            return lastName;
        }

        /*
         * Sets a account last name.
         * @param sets up the last Name of the user on the account.
         */
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        /*
         * constructor.
         *
         * @param name this is the name of the Account.
         * @param classOfAccount
         */
        public AccountUser(String userName, String password, String firstName, String lastName, String employeeID){
            this.firstName = firstName;
            this.lastName = lastName;
            this.employeeID = employeeID;
            this.userName = userName;
            this.password = password;
        }

        /*
         * String that represents a Account.
         * @return the name, class of Account of the Educatalog.
         */
        public String toString() {
            String returnString="";

            return returnString;
        }
    }
