package com.springactivity.config;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by a on 17/03/2018.
 */
//InternalResourceViewResolver which doesn't check for circular view paths (during tests)
public class StandaloneMvcTestViewResolver extends InternalResourceViewResolver {
    public StandaloneMvcTestViewResolver() {
        super();
    }

    @Override
    protected AbstractUrlBasedView buildView(final String viewName) throws Exception {
        final InternalResourceView view = (InternalResourceView) super.buildView(viewName);
        // prevent checking for circular view paths
        view.setPreventDispatchLoop(false);
        return view;
    }
}
