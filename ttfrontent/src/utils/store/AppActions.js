import dispatcher from './AppDispatcher';
import STORE_CONST from '../constants/store_constants.json';

class AppActions {
  userDetailsHolder(data) {
    dispatcher.dispatch({
      actionType: STORE_CONST.userDetails,
      payload: data
    });
  }

  isLoading(data) {
    dispatcher.dispatch({
      actionType: STORE_CONST.isLoading,
      payload: data
    });
  }
}

export default new AppActions();