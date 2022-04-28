package eu.ensup.demospringsecurity.domain;

import com.fasterxml.jackson.annotation.*;

@JsonRootName("role")
public enum Roles
{
    USER,
    ADMIN;

    @JsonCreator
    public Roles getRoleByName(@JsonProperty("role") String name) {
        for(Roles role : Roles.values())
            if(role.name().equals(name))
                return role;

        return null;
    }

    @JsonValue
    public String getName() { return this.name(); }
}
