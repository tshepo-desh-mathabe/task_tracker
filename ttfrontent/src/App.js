import React, { Fragment, useEffect, useState } from 'react';
import Footer from './components/footer/Footer';
import NavigationBar from './components/navbar/NavigationBar';
import { AppRoutes } from './utils/app_routes/AppRoutes';
import { BrowserRouter as Router } from 'react-router-dom';
import { Login } from './components/login/Login';
import { getSecretToken } from './utils/store/BrowserSession';
import PATH from './utils/constants/route_path.json';
import APP_CONST from './utils/constants/app_contants.json';
import history from './utils/BrowserHistory';
import './App.scss';
import { DisplayWrapper } from './utils/wrapper';

function App() {
  const [token, setToken] = useState();

  useEffect(() => {
    window.addEventListener(APP_CONST.userSession, () => {
      setToken(getSecretToken().token);
    });
  });

  if (!token) {
    history.push(PATH.signIn);
    return (
      <DisplayWrapper body={<Login />} />
    );
  } else {
    history.push(PATH.home);
    return (
      <DisplayWrapper body={
        <Fragment>
          <NavigationBar>
            <Router>
              <AppRoutes />
            </Router>
          </NavigationBar>
          <Footer />
        </Fragment>
      } />
    );
  }
}


export default App;
