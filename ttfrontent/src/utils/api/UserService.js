import API from '../../utils/';
import { httpRequest } from './helper/Request';

export async function signIn(requestBody) {
    return httpRequest(api.HTTP_REQUEST_TYPE.POST, api.USER_LOGIN, requestBody);
}

export async function signOut(requestBody) {
    return httpRequest(api.HTTP_REQUEST_TYPE.POST, api.USER_LOGOUT, requestBody);
}

export async function getSignedInUser(requestBody) {
    return httpRequest(api.HTTP_REQUEST_TYPE.GET, api.GET_USER_LOGGED_IN, requestBody);
}