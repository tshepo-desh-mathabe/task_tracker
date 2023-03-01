import React, { Fragment, useEffect } from 'react';
import './App.scss';
import Footer from './components/footer/Footer';
import NavigationBar from './components/navbar/NavigationBar';
import { AppRoutes } from './utils/app_routes/AppRoutes';
import { BrowserRouter as Router } from 'react-router-dom';
import { Login } from './components/login/Login';
import { getSecretToken } from './utils/store/BrowserSession';
import PATH from './utils/constants/route_path.json';
import history from './utils/BrowserHistory';

function App() {
  useEffect(() => {
    if (getSecretToken() === null) history.push(PATH.signIn);
    else return (<AppRoutes />);
  });

  return (
    <div className='app'>
      {
        getSecretToken() === null ?
          <Login /> :
          <Fragment>
            <NavigationBar>
              <Router>
                <AppRoutes />
              </Router>
            </NavigationBar>
            <Footer />
          </Fragment>
      }
    </div>
  );
}

export default App;
