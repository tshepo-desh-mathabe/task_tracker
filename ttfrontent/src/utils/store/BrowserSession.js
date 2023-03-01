import APP_CONST from '../constants/app_contants.json';

export function setUserSession(httpResponse) {
    sessionStorage.setItem(APP_CONST.userSession, JSON.stringify(httpResponse));
}
export function getSecretToken() {
    return JSON.parse(sessionStorage.getItem(APP_CONST.userSession));
}

