import APP_CONST from '../constants/app_contants.json';

export function setUserSession(httpResponse) {
    window.sessionStorage.setItem(APP_CONST.userSession, JSON.stringify(httpResponse));
    window.dispatchEvent(new Event(APP_CONST.userSession));
}
export function getSecretToken() {
    return JSON.parse(sessionStorage.getItem(APP_CONST.userSession));
}

