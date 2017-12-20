package org.apache.shiro.web.faces.tags;

import java.util.Arrays;
import java.util.List;
import org.apache.shiro.subject.Subject;
import static org.apache.shiro.web.faces.utils.BooleanArrays.anyTrue;

import javax.faces.view.facelets.TagConfig;


/**
 * Displays body content if the current user has any of the roles specified.
 *
 * @author Deluan Quintao
 * @author Jeremy Haile
 */
public class HasAnyRolesTag extends PermissionTagHandler {

    //TODO - complete JavaDoc

    // Delimeter that separates role names in tag attribute
    private static final String ROLE_NAMES_DELIMETER = ",";

    public HasAnyRolesTag(TagConfig config) {
        super(config);
    }

    @Override
    protected boolean showTagBody(String roleNames) {
        Subject subject = getSubject();
        List<String> roleIdentifiers = Arrays.asList(roleNames.split(ROLE_NAMES_DELIMETER));
        boolean[] matches = subject.hasRoles(roleIdentifiers);
        return anyTrue(matches);
    }

}
