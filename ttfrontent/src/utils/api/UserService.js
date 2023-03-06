import API from '../../utils/constants/api_constants.json';
import { httpRequest } from './helper/Request';

const basePath = API.apBaseUrl;

export async function signIn(requestBody) {
    console.log('--->>>', API.httpRequestType.post);
    return httpRequest(API.httpRequestType.post, combinedPaths(basePath, API.signIn), requestBody);
}

export async function signOut(requestBody) {
    return httpRequest(API.httpRequestType.post, combinedPaths(basePath, API.signOut), requestBody);
}

export async function getSignedInUser(requestBody) {
    return httpRequest(API.httpRequestType.get, combinedPaths(basePath, API.currentUser), requestBody);
}

function combinedPaths(prePath, postPath) {
    return `${prePath}${postPath}`;
}
