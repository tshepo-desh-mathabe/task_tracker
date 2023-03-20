import React from 'react';
import { useRoutes } from 'react-router-dom';
import PATH from '../constants/route_path.json';
import * as page from '../../components/index';

const AppRoutes = () => {
    const routes = useRoutes([
        { path: PATH.signIn, element: <page.Login /> },
        { path: PATH.home, element: <page.Home /> },
        { path: PATH.defect, element: <page.Defect /> },
        { path: PATH.changeRequest, element: <page.ChangeRequest /> },
        { path: PATH.userStory, element: <page.UserStory /> },
        { path: PATH.other, element: <page.Other /> },
        { path: PATH.allRoutes, element: <page.Home /> }
    ]);

    return routes;
}

export default AppRoutes;