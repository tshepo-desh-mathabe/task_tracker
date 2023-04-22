import React, { Fragment, useEffect, useState } from 'react';
import Footer from './components/footer/Footer';
import NavigationBar from './components/navbar/NavigationBar';
import AppRoutes from './utils/app_routes/AppRoutes';
import { Login } from './components/login/Login';
import PATH from './utils/constants/route_path.json';
import history from './utils/BrowserHistory';
import { DisplayWrapper } from './utils/wrapper';
import './App.scss';
import appStore from './utils/store/AppStore';

function App() {
  const [token, setToken] = useState();

  useEffect(() => {
    const session = () => setToken(appStore.getUserToken());
    appStore.addChangeListener(session);

    return () => appStore.removeChangeListener(session)
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
            <AppRoutes />
          </NavigationBar>
          <Footer />
        </Fragment>
      } />
    );
  }
}


export default App;
