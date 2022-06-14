package com.team3.letschat.DataFetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.team3.letschat.Service.userService;
import com.team3.letschat.Users.UserRole;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

@DgsComponent
public class RoleDataFetcher {

    @Autowired
    private userService UserService;

    @DgsMutation
    public void addRole(DataFetchingEnvironment dfe)
    {
        UserRole role = new UserRole(dfe.getArgument("roleType"));
        UserService.SaveRole(role);
    }

    @DgsMutation
    public void editRole(DataFetchingEnvironment dfe)
    {
        UserRole role = new UserRole(dfe.getArgument("updatedRole"));
        UserService.editRole(dfe.getArgument("oldRole"), role);
    }

    @DgsMutation
    public void deleteRole(DataFetchingEnvironment dfe)
    {
        UserService.removeRole(dfe.getArgument("roleType"));
    }

    @DgsMutation
    public void addRoletoUser(DataFetchingEnvironment dfe)
    {
        UserService.addRoleToUser(dfe.getArgument("username"), dfe.getArgument("roleType"));
    }
}
