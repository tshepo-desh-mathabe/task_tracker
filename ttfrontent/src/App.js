import React, { Fragment, useEffect } from 'react';
import './App.scss';
import Footer from './components/footer/Footer';
import NavigationBar from './components/navbar/NavigationBar';
<<<<<<< Updated upstream
=======
import { AppRoutes } from './utils/app_routes/AppRoutes';
import { BrowserRouter as Router } from 'react-router-dom';
import { Login } from './components/login/Login';
import { getSecretToken } from './utils/store/BrowserSession';
import PATH from './utils/constants/route_path.json';
import history from './utils/BrowserHistory';
>>>>>>> Stashed changes

function App() {
  useEffect(() => {
    if (getSecretToken() === null) history.push(PATH.signIn);
    else return (<AppRoutes />);
  });

  return (
    <div className='app'>
<<<<<<< Updated upstream
      <NavigationBar>
        <div className='body'>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        </div>
        {/* <AppRoutes /> */}
      </NavigationBar>
      <Footer />
=======
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
>>>>>>> Stashed changes
    </div>
  );
}

export default App;
