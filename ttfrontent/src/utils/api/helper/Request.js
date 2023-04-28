import axios from 'axios';
import HTTP_CONST from '../../constants/api_constants.json';
import appStore from '../../store/AppStore';


export const httpRequest = async (requestType, url, requestBody) => {
    const http = HTTP_CONST.httpRequestType;
    const options = {};

    const token = appStore.getUserToken();

    if (token) {
        options.headers = {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
        };
    }

    switch (requestType) {
        case http.get:
            return await axios.get(url, options)
                .then(res => { return Promise.resolve(res); })
                .catch(err => { return Promise.reject(err); });

        case http.post:
            return await axios.post(url, requestBody, options)
                .then(res => { return Promise.resolve(res); })
                .catch(err => { return Promise.reject(err); });

        case http.put:
            return await axios.put(url, requestBody, options)
                .then(res => { return Promise.resolve(res); })
                .catch(err => { return Promise.reject(err); });

        case http.delete:
            return await axios.delete(url, requestBody, options)
                .then(res => { return Promise.resolve(res); })
                .catch(err => { return Promise.reject(err); });
        default:
            break;
    }
}

export function combinedPaths(prePath, postPath) {
    return `${HTTP_CONST.apiBaseUrl}${prePath}${postPath}`;
}
