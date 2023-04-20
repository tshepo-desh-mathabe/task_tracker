import API from '../../utils/constants/api_constants.json';
import { httpRequest, combinedPaths } from './helper/Request';

const userPath = API.user;

export function signIn(requestBody) {
    return httpRequest(API.httpRequestType.post, combinedPaths(userPath.base, userPath.signIn), requestBody);
}

// export function getAll(requestBody) {
//     return httpRequest(API.httpRequestType.get, combinedPaths(userPath.base, userPath.getAll), requestBody);
// }

// export async function signOut(requestBody) {
//     return httpRequest(API.httpRequestType.post, combinedPaths(basePath, API.signOut), requestBody);
// }