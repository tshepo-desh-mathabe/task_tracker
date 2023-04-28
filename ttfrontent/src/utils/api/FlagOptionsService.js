import API from '../../utils/constants/api_constants.json';
import { httpRequest, combinedPaths } from './helper/Request';

export function getAllFlagOptions() {
    return httpRequest(API.httpRequestType.get, combinedPaths(API.flagOption.base, API.general.getAll), null);
}
