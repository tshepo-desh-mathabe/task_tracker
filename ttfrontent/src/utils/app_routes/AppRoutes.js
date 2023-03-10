import React from 'react';
import {
    Routes, // instead of "Switch"
    Route,
} from 'react-router-dom';
import PATH from '../constants/route_path.json';
import * as page from '../../components/index';

export function AppRoutes() {
    return (
        <Routes>
            <Route exact path={PATH.signIn} element={<page.Login />} />
            <Route exact path={PATH.home} element={<page.Home />} />
            <Route path={PATH.defect} element={<page.Defect />} />
        </Routes>
    );
}
