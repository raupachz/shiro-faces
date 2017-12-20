package org.apache.shiro.web.faces.tags;

import java.util.Arrays;
import java.util.List;
import org.apache.shiro.subject.Subject;

import javax.faces.view.facelets.TagConfig;
import static org.apache.shiro.web.faces.utils.BooleanArrays.anyTrue;

/**
 * Tag that renders the tag body only if the current user has <em>at least one</em> of the comma-delimited
 * string permissions specified in <tt>name</tt> attribute.
 *
 * @author Deluan
 */
public class HasAnyPermissionTag extends PermissionTagHandler {

    private static final String PERMISSIONS_DELIMETER = ",";

    public HasAnyPermissionTag(TagConfig config) {
        super(config);
    }

    @Override
    protected boolean showTagBody(String permissions) {
        Subject subject = getSubject();
        boolean[] matches = subject.isPermitted(permissions.split(PERMISSIONS_DELIMETER));
        return anyTrue(matches);
    }
}
